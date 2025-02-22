package com.alex.ecom.product;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {

}
