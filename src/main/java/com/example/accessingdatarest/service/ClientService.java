package com.example.accessingdatarest.service;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.model.TrashBin;
import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.repo.BinRepository;
import com.example.accessingdatarest.repo.ClientRepository;
import com.example.accessingdatarest.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PointRepository pointRepository;

    @Autowired
    BinRepository binRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(long id) {
        return clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
    }

    public Client getClientByPhone(String phone) {
        return clientRepository.findByPhone(phone);
    }

    public Client setBin(long id, TrashBin bin) {
        binRepository.save(bin);
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setTrashBinId(bin.getId());
        return clientRepository.save(client);
    }

    public Client setPoint(long id, TrashPoint point) {
        pointRepository.save(point);
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setTrashPointId(point.getId());
        return clientRepository.save(client);
    }

    public Client plusBalance(long id, int value) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setBalance(client.getBalance() + value);
        return clientRepository.save(client);
    }

    public Client minusBalance(long id, int value) {
        Client client = clientRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        client.setBalance(client.getBalance() - value);
        return clientRepository.save(client);
    }
}
