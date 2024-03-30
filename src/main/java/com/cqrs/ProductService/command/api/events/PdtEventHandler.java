package com.cqrs.ProductService.command.api.events;

import com.cqrs.ProductService.command.api.data.Pdt;
import com.cqrs.ProductService.command.api.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PdtEventHandler {
    public PdtEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        Pdt pdt=new Pdt();
        BeanUtils.copyProperties(event,pdt);
        productRepository.save(pdt);
    }
}
