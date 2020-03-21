package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping()
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping()
    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable long id) {
        return clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
    }

    @GetMapping("/{id}/bin")
    public Client setBin(@PathVariable long id,
                         @RequestParam(value = "binId") long binId) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setTrashBinId(binId);
        return clientRepository.save(client);
    }

    @GetMapping("/{id}/point")
    public Client setPoint(@PathVariable long id,
                           @RequestParam(value = "pointId") long pointId) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setTrashPointId(pointId);
        return clientRepository.save(client);
    }

    @GetMapping("/{id}/balance/plus")
    public Client plusBalance(@PathVariable long id,
                              @RequestParam(value = "value") int value) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setBalance(client.getBalance() + value);
        return clientRepository.save(client);
    }

    @GetMapping("/{id}/balance/minus")
    public Client minusBalance(@PathVariable long id,
                               @RequestParam(value = "value") int value) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setBalance(client.getBalance() - value);
        return clientRepository.save(client);
    }
}