package com.cqrs.ProductService.command.api.events;

import com.cqrs.ProductService.command.api.data.Pdt;
import com.cqrs.ProductService.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class PdtEventHandler {
    public PdtEventHandler(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event)throws Exception{
        Pdt pdt=new Pdt();
        BeanUtils.copyProperties(event,pdt);
        productRepository.save(pdt);
        throw new Exception("Exception OOPS");
    }
    @ExceptionHandler
    public void handle(Exception exception)throws Exception{
        throw exception;
    }
}
