package com.cqrs.ProductService.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity

public class Pdt {
    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
