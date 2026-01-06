import { useEffect, useState } from 'react'
import { earningService } from './services/api'
import { EarningForm } from './components/EarningForm'

function App() {
  const [earnings, setEarnings] = useState([])
  const meta = 30000
  
  const fetchEarnings = async () => {
    try {
      const response = await earningService.getAll()
      setEarnings(response.data)
    } catch (error) { console.error("Erro ao buscar:", error) }
  }

  const handleSave = async (newEarning) => {
  try {
    await earningService.create(newEarning); // Envia para o Java
    await fetchEarnings(); // BUSCA NOVAMENTE para atualizar a tela
  } catch (error) { 
    console.error("Erro ao salvar:", error);
    alert("Erro ao conectar com o servidor!"); 
  }
}

  const handleDelete = async (id) => {
    if (window.confirm("Deseja realmente excluir esse ganho?")) {
      try {
        await earningService.delete(id)
        fetchEarnings()
      } catch (error) { console.error("Erro ao deletar:", error) }
    }
  }

  useEffect(() => { fetchEarnings() }, [])

  const totalGeral = earnings?.length > 0 
    ? earnings.reduce((acc, curr) => acc + (curr.value || 0), 0) 
    : 0;
  const porcentagem = ((totalGeral / meta) * 100).toFixed(1)

  return (
    <div className="min-h-screen bg-gray-900 text-white p-8 font-sans">
      <div className="max-w-4xl mx-auto">
        <header className="flex justify-between items-center mb-10">
          <h1 className="text-3xl font-bold bg-gradient-to-r from-green-400 to-blue-500 bg-clip-text text-transparent">
            Target 30k Dashboard 🚀
          </h1>
          <div className="text-right">
            <p className="text-gray-400 text-sm">Total Acumulado</p>
            <p className="text-2xl font-mono text-green-400">R$ {totalGeral.toLocaleString()}</p>
          </div>
        </header>

        {/* Componente de Formulário que você criou */}
        <EarningForm onSave={handleSave} />

        {/* Barra de Progresso */}
        <div className="bg-gray-800 rounded-full h-6 mb-12 overflow-hidden border border-gray-700 relative">
          <div 
            className="bg-gradient-to-r from-green-500 to-blue-600 h-full transition-all duration-1000"
            style={{ width: `${Math.min(porcentagem, 100)}%` }}
          ></div>
          <p className="absolute inset-0 text-center text-xs font-bold flex items-center justify-center">
            {porcentagem}% da meta atingida
          </p>
        </div>

        {/* Lista de Freelas */}
        <div className="grid gap-4">
          <h2 className="text-xl font-semibold mb-2 text-gray-300">Últimos Recebimentos</h2>
          {earnings.map(item => (
            <div key={item.id} className="bg-gray-800 p-5 rounded-xl border border-gray-700 flex justify-between items-center group">
              <div>
                <p className="font-medium text-lg">{item.description}</p>
                <p className="text-gray-500 text-sm">{new Date(item.date).toLocaleDateString()}</p>
              </div>
              <div className="flex items-center gap-6">
                <p className="text-xl font-bold text-green-400">+ R$ {item.value}</p>
                <button 
                  onClick={() => handleDelete(item.id)}
                  className="text-gray-500 hover:text-red-500 transition-colors p-2"
                  title="Excluir ganho"
                >
                  🗑️
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  )
}

export default App