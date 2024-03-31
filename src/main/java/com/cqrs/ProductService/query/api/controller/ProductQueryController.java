package com.cqrs.ProductService.query.api.controller;

import com.cqrs.ProductService.command.api.model.restModel;
import com.cqrs.ProductService.query.api.queries.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RequestMapping("/products")
@RestController
public class ProductQueryController {
    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    private QueryGateway queryGateway;
    @GetMapping
    public List<restModel> getAllProducts(){
        GetProductQuery getProductQuery=
                new GetProductQuery();
        List<restModel> restModels=
        queryGateway.query(getProductQuery,
                ResponseTypes.multipleInstancesOf(restModel.class)).join();
        return  restModels;
    }
}
