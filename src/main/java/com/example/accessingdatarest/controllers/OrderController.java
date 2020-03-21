package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.Order;
import com.example.accessingdatarest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping()
    public Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/{id}/accept")
    public Order setIsAcceptOrder(@PathVariable long id,
                                  @RequestParam(value = "isAccept") boolean isAccept) {
        return orderService.setIsAcceptOrder(id, isAccept);
    }

    @GetMapping("/{id}/complete")
    public String completeOrder(@PathVariable long id) {
        orderService.completeOrder(id);
        return "Deleted";
    }

}
