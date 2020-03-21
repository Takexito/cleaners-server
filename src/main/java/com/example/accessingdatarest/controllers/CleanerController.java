package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.Cleaner;
import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.repo.CleanerRepository;
import com.example.accessingdatarest.repo.ClientRepository;
import com.example.accessingdatarest.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cleaner")
public class CleanerController {

    @Autowired
    CleanerService cleanerService;

    @GetMapping("/create")
    public Cleaner createCleaner(@RequestParam long clientId) {
        return cleanerService.createCleaner(clientId);
    }

    @GetMapping()
    public Iterable<Cleaner> getCleaners() {
        return cleanerService.getCleaners();
    }

    @GetMapping("/{id}")
    public Cleaner getCleaner(@PathVariable long id) {
        return cleanerService.getCleaner(id);
    }

    @GetMapping("/{id}/rank/inc")
    public Cleaner incRank(@PathVariable long id) {
        return cleanerService.incRank(id);
    }

    @GetMapping("/{id}/rank/dec")
    public Cleaner decRank(@PathVariable long id) {
        return cleanerService.decRank(id);
    }

    @GetMapping("/{id}/balance/plus")
    public Cleaner plusBalance(@PathVariable long id,
                               @RequestParam(value = "value") int value) {
        return cleanerService.plusBalance(id, value);
    }

    @GetMapping("/{id}/balance/minus")
    public Cleaner minusBalance(@PathVariable long id,
                                @RequestParam(value = "value") int value) {
        return cleanerService.minusBalance(id, value);
    }

    @GetMapping("/{id}/order/add")
    public Cleaner addOrder(@PathVariable long id,
                            @RequestParam(value = "orderId") long orderId) {
        return cleanerService.addOrder(id, orderId);
    }

    @GetMapping("/{id}/order/delete")
    public Cleaner deleteOrder(@PathVariable long id,
                               @RequestParam(value = "orderId") long orderId) {
        return cleanerService.deleteOrder(id, orderId);
    }
}
