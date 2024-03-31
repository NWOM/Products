package com.cqrs.ProductService.query.api.projections;

import com.cqrs.ProductService.command.api.data.Pdt;
import com.cqrs.ProductService.command.api.data.ProductRepository;
import com.cqrs.ProductService.command.api.model.restModel;
import com.cqrs.ProductService.query.api.queries.GetProductQuery;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductProjection {
    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;
    public List<restModel> handle(GetProductQuery getProductQuery){
        List<Pdt> pdts=productRepository.findAll();
        List<restModel> restModels=pdts.stream()
                .map(pdt -> restModel
                        .builder()
                        .quantity(pdt.getQuantity())
                        .name(pdt.getName())
                        .price(pdt.getPrice())
                        .build())
                .collect(Collectors.toList());
        return restModels;

    }
}
