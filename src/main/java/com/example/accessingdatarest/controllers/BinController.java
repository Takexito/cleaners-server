package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.TrashBin;
import com.example.accessingdatarest.repo.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bin")
public class BinController {

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
    public TrashBin getBin(@PathVariable("id") TrashBin trashBin) {
        return trashBin;
    }
}
