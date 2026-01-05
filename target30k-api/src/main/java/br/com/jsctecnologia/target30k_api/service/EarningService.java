package br.com.jsctecnologia.target30k_api.service;

import br.com.jsctecnologia.target30k_api.dto.EarningRequestDTO;
import br.com.jsctecnologia.target30k_api.dto.EarningResponseDTO;
import br.com.jsctecnologia.target30k_api.model.FreelaEarning;
import br.com.jsctecnologia.target30k_api.repository.FreelaEarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EarningService {

    @Autowired
    private FreelaEarningRepository repository;

    // Busca todos e transforma em DTO de resposta
    public List<EarningResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(earning -> new EarningResponseDTO(
                        earning.getId(),
                        earning.getDescription(),
                        earning.getValue(),
                        earning.getDate()))
                .collect(Collectors.toList());
    }

    // Recebe um DTO de requisição, salva no banco e retorna o DTO de resposta
    public EarningResponseDTO save(EarningRequestDTO dto) {
        FreelaEarning entity = new FreelaEarning();
        entity.setDescription(dto.description());
        entity.setValue(dto.value());
        entity.setDate(dto.date());

        entity = repository.save(entity);

        return new EarningResponseDTO(
                entity.getId(),
                entity.getDescription(),
                entity.getValue(),
                entity.getDate());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}