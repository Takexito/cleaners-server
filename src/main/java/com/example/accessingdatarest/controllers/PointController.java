package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/point")
public class PointController {

    @Autowired
    private PointService pointService;

//    @PostMapping()
//    public TrashPoint addNewPoint(@RequestBody TrashPoint point) {
//        return pointService.addNewPoint(point);
//    }

    @GetMapping()
    public @ResponseBody
    Iterable<TrashPoint> getAllPoints() {
        return pointService.getAllPoints();
    }

    @GetMapping(path = "/{id}")
    public TrashPoint getPoint(@PathVariable("id") TrashPoint trashPoint) {
        return trashPoint;
    }

    @GetMapping(path = "/{id}/full")
    public TrashPoint setFullPoint(@PathVariable Long id,
                                   @RequestParam(value = "isFull") boolean isFull) {
        return pointService.setFullPoint(id, isFull);
    }

}
