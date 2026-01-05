package br.com.jsctecnologia.target30k_api.repository;

import br.com.jsctecnologia.target30k_api.model.FreelaEarning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelaEarningRepository extends JpaRepository<FreelaEarning, Long> {
    // Só isso! O Spring Data JPA faz toda a mágica do CRUD sozinho.
}