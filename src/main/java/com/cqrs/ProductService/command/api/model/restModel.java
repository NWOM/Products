package com.cqrs.ProductService.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class restModel {
    //TO COLLECT THE DATA
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
