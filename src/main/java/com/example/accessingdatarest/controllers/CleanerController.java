package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.Cleaner;
import com.example.accessingdatarest.repo.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cleaner")
public class CleanerController {

    @Autowired
    private CleanerRepository cleanerRepository;


    @PostMapping()
    public Cleaner createCleaner(@RequestBody Cleaner cleaner) {
        return cleanerRepository.save(cleaner);
    }

    @GetMapping()
    public Iterable<Cleaner> getCleaners() {
        return cleanerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cleaner getCleaner(@PathVariable long id) {
        return cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
    }

    @GetMapping("/{id}/rank/inc")
    public Cleaner incRank(@PathVariable long id) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.incRank();
        return cleanerRepository.save(cleaner);
    }

    @GetMapping("/{id}/rank/dec")
    public Cleaner decRank(@PathVariable long id) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.decRank();
        return cleanerRepository.save(cleaner);
    }

    @GetMapping("/{id}/balance/plus")
    public Cleaner plusBalance(@PathVariable long id,
                               @RequestParam(value = "value") int value) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setBalance(cleaner.getBalance() + value);
        return cleanerRepository.save(cleaner);
    }

    @GetMapping("/{id}/balance/minus")
    public Cleaner minusBalance(@PathVariable long id,
                                @RequestParam(value = "value") int value) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setBalance(cleaner.getBalance() - value);
        return cleanerRepository.save(cleaner);
    }

    @GetMapping("/{id}/order/add")
    public Cleaner addOrder(@PathVariable long id,
                            @RequestParam(value = "orderId") long orderId) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setOrdersId(orderId);
        return cleanerRepository.save(cleaner);
    }

    @GetMapping("/{id}/order/delete")
    public Cleaner deleteOrder(@PathVariable long id,
                               @RequestParam(value = "orderId") long orderId) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setOrdersId(0);
        return cleanerRepository.save(cleaner);
    }
}
