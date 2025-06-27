package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestProduct(

        Long id,
        @NotBlank
        String name ,
        @NotNull
        BigDecimal price) {
}
