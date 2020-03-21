package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.TrashBin;
import com.example.accessingdatarest.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bin")
public class BinController {

    @Autowired
    private BinService binService;

//    @PostMapping()
//    public TrashBin addNewBin(@RequestBody TrashBin trashBin) {
//        return binService.addNewBin(trashBin);
//    }

    @GetMapping()
    public @ResponseBody
    Iterable<TrashBin> getAllBins() {
        return binService.getAllBins();
    }

    @GetMapping(path = "/{id}")
    public TrashBin getBin(@PathVariable("id") TrashBin trashBin) {
        return trashBin;
    }
}
