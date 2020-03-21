package com.example.accessingdatarest.service;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.Cleaner;
import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.repo.CleanerRepository;
import com.example.accessingdatarest.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CleanerService {

    @Autowired
    private CleanerRepository cleanerRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Cleaner createCleaner(long clientId) {
        Cleaner cleaner = new Cleaner();
        Client client = clientRepository.findById(clientId).orElseThrow(new ObjectNotFoundException(clientId));
        cleaner.copyFromClient(client);
        return cleanerRepository.save(cleaner);
    }

    public Iterable<Cleaner> getCleaners() {
        return cleanerRepository.findAll();
    }

    public Cleaner getCleaner(long id) {
        return cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
    }

    public Cleaner incRank(long id) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.incRank();
        return cleanerRepository.save(cleaner);
    }

    public Cleaner decRank(long id) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.decRank();
        return cleanerRepository.save(cleaner);
    }

    public Cleaner plusBalance(long id, int value) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setBalance(cleaner.getBalance() + value);
        return cleanerRepository.save(cleaner);
    }

    public Cleaner minusBalance(long id, int value) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setBalance(cleaner.getBalance() - value);
        return cleanerRepository.save(cleaner);
    }

    public Cleaner addOrder(long id, long orderId) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setOrdersId(orderId);
        return cleanerRepository.save(cleaner);
    }

    public Cleaner deleteOrder(long id, long orderId) {
        Cleaner cleaner = cleanerRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        cleaner.setOrdersId(0);
        return cleanerRepository.save(cleaner);
    }
}
