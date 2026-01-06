package br.com.jsctecnologia.target30k_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EarningResponseDTO(
        Long id,
        String description,
        BigDecimal value,
        LocalDate date
) {public EarningResponseDTO(br.com.jsctecnologia.target30k_api.model.FreelaEarning entity) {
    this(entity.getId(), entity.getDescription(), entity.getValue(), entity.getDate());}}