package com.cqrs.ProductService.command.api.aggregrate;

import com.cqrs.ProductService.command.api.commands.CreateProductCommand;
import com.cqrs.ProductService.command.api.events.ProductCreatedEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregrate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregrate(CreateProductCommand createProductCommand) {
           //PERFORM ALL THE VALIDATION
        ProductCreatedEvent productCreatedEvent=new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);

    }

    public ProductAggregrate() {
    }
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.quantity=productCreatedEvent.getQuantity();
        this.name=productCreatedEvent.getName();
        this.productId=productCreatedEvent.getProductId();
        this.price=productCreatedEvent.getPrice();
    }
}
