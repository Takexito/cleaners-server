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

    @GetMapping(path = "/{id}/full")
    public TrashPoint setFullPoint(@PathVariable Long id,
                                   @RequestParam(value = "isFull") boolean isFull) {
        TrashPoint point = pointRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        point.setFull(isFull);
        return pointRepository.save(point);
    }

}
