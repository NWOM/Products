package com.cqrs.ProductService.command.api.controller;

import com.cqrs.ProductService.command.api.commands.CreateProductCommand;
import com.cqrs.ProductService.command.api.model.restModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private CommandGateway commandGateway;
    public ProductController(CommandGateway commandGateway){
        this.commandGateway=commandGateway;
    }
    @PostMapping
    public String addProduct(@RequestBody restModel restmodel){
        CreateProductCommand createProductCommand=CreateProductCommand
                .builder()
                .productId(UUID.randomUUID().toString())
                .name(restmodel.getName())
                .price(restmodel.getPrice())
                .quantity(restmodel.getQuantity())
                .build();
        String result=commandGateway.sendAndWait(createProductCommand);

        return result;
    }
}
