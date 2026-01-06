package br.com.jsctecnologia.target30k_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

// FreelaEarning.java

@Entity
@Data
public class FreelaEarning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // Usamos aspas duplas escapadas para o H2 aceitar a palavra reservada
    @Column(name = "valor_ganho")
    private BigDecimal value;

    private LocalDate date;
}