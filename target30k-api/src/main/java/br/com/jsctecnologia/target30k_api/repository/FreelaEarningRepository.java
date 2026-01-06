package br.com.jsctecnologia.target30k_api.repository;

import br.com.jsctecnologia.target30k_api.model.FreelaEarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreelaEarningRepository extends JpaRepository<FreelaEarning, Long> {
    @Query("SELECT f FROM FreelaEarning f WHERE MONTH(f.date) = :month AND YEAR(f.date) = :year")
    List<FreelaEarning> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}