import { useState } from 'react';

export function EarningForm({ onSave }) {
    const [description, setDescription] = useState('');
    const [value, setValue] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!description || !value) return;
        
        onSave({
            description: description,
            value: parseFloat(value),
            date: new Date().toISOString().split('T')[0]
        });

        // Limpa os campos após salvar
        setDescription('');
        setValue('');
    }; // <--- A CHAVE FECHA AQUI!

    // O return do componente deve vir DEPOIS das funções
    return (
        <form onSubmit={handleSubmit} className="bg-gray-800 p-6 rounded-xl border border-gray-700 mb-8 flex gap-4 items-end">
            <div className="flex-1">
                <label className="block text-gray-400 text-sm mb-2">Descrição do Freela</label>
                <input
                    type="text" value={description} onChange={(e) => setDescription(e.target.value)}
                    className="w-full bg-gray-900 border border-gray-600 rounded-lg p-2 focus:border-green-500 outline-none"
                    placeholder="Ex: Projeto React"
                />
            </div>
            <div className="w-32">
                <label className="block text-gray-400 text-sm mb-2">Valor (R$)</label>
                <input
                    type="number" value={value} onChange={(e) => setValue(e.target.value)}
                    className="w-full bg-gray-900 border border-gray-600 rounded-lg p-2 focus:border-green-500 outline-none"
                    placeholder="0.00"
                />
            </div>
            <button type="submit" className="bg-green-600 hover:bg-green-500 px-6 py-2 rounded-lg font-bold transition-colors">
                Adicionar
            </button>
        </form>
    );
}