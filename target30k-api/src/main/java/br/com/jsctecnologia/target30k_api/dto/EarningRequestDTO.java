package br.com.jsctecnologia.target30k_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EarningRequestDTO(
        String description,
        BigDecimal value,
        LocalDate date
) {}