package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record RequestProduct(

        @NotBlank
        String name ,
        @NotNull
        BigDecimal price) {
}
