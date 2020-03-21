package com.example.accessingdatarest.service;

import com.example.accessingdatarest.model.TrashBin;
import com.example.accessingdatarest.repo.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class BinService {

    @Autowired
    private BinRepository binRepository;

    @PostMapping()
    public TrashBin addNewBin(@RequestBody TrashBin trashBin) {
        return binRepository.save(trashBin);
    }

    @GetMapping()
    public @ResponseBody
    Iterable<TrashBin> getAllBins() {
        return binRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public TrashBin getBin(TrashBin trashBin) {
        return trashBin;
    }
}
