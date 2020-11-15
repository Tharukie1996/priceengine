package com.product.priceengine.controller;

import com.product.priceengine.domain.Order;
import com.product.priceengine.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class OrderController {

    private final OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> getBill(@RequestBody Order order) {

        return new ResponseEntity<>(orderService.getOrderPrice(order), HttpStatus.OK);
    }
}
