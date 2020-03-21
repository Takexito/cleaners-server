package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/point")
public class PointController {

    @Autowired
    private PointRepository pointRepository;

    @PostMapping()
    public TrashPoint addNewPoint(@RequestBody TrashPoint point) {
        return pointRepository.save(point);
    }

    @GetMapping()
    public @ResponseBody
    Iterable<TrashPoint> getAllPoints() {
        return pointRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public TrashPoint getPoint(@PathVariable("id") TrashPoint trashPoint) {
        return trashPoint;
    }

    @PostMapping(path = "/full")
    public TrashPoint setFullPoint(@RequestBody Long id,
                                   @RequestBody boolean isFull) {
        TrashPoint point = pointRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        point.setFull(isFull);
        return pointRepository.save(point);
    }

}
