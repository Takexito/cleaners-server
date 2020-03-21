package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.model.TrashBin;
import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping()
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping()
    public Iterable<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable long id) {
        return clientService.getClient(id);
    }

    @GetMapping("/{id}/bin")
    public Client setBin(@PathVariable long id,
                         @RequestBody TrashBin bin) {
        return clientService.setBin(id, bin);
    }

    @PostMapping("/{id}/point")
    public Client setPoint(@PathVariable long id,
                           @RequestBody TrashPoint point) {
        return clientService.setPoint(id, point);
    }

    @GetMapping("/{id}/balance/plus")
    public Client plusBalance(@PathVariable long id,
                              @RequestParam(value = "value") int value) {
        return clientService.plusBalance(id, value);
    }

    @GetMapping("/{id}/balance/minus")
    public Client minusBalance(@PathVariable long id,
                               @RequestParam(value = "value") int value) {
        return clientService.minusBalance(id, value);
    }
}