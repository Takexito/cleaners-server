package com.example.accessingdatarest.service;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.exceptions.TrashNotInitException;
import com.example.accessingdatarest.model.Cleaner;
import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.model.Order;
import com.example.accessingdatarest.repo.CleanerRepository;
import com.example.accessingdatarest.repo.ClientRepository;
import com.example.accessingdatarest.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CleanerRepository cleanerRepository;
    @Autowired
    OrderRepository orderRepository;

    public void completeOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(new ObjectNotFoundException(orderId));
        Client client = clientRepository.findById(order.getClientId()).orElseThrow(new ObjectNotFoundException(order.getClientId()));
        Cleaner cleaner = cleanerRepository.findById(order.getCleanerId()).orElseThrow(new ObjectNotFoundException(order.getCleanerId()));
        client.minusBalance(order.getPrice());
        cleaner.plusBalance(Math.round(order.getPrice() / 2f));
        clientRepository.save(client);
        cleanerRepository.save(cleaner);
        orderRepository.deleteById(orderId);
    }

    public Order createOrder(Order order) {
        Client client = clientRepository.findById(order.getClientId()).orElseThrow(new ObjectNotFoundException(order.getClientId()));
        if (client.getTrashBinId() == 0 || client.getTrashPointId() == 0)
            throw new TrashNotInitException(); // не работает
        return orderRepository.save(order);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
    }

    public Order setIsAcceptOrder(long id, boolean isAccept) {
        Order order = orderRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        order.setAccept(isAccept);
        return orderRepository.save(order);
    }
}
