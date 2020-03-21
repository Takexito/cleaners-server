package com.example.accessingdatarest.service;

import com.example.accessingdatarest.exceptions.ObjectNotFoundException;
import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class PointService {
    @Autowired
    private PointRepository pointRepository;

    public TrashPoint addNewPoint(@RequestBody TrashPoint point) {
        return pointRepository.save(point);
    }

    public @ResponseBody
    Iterable<TrashPoint> getAllPoints() {
        return pointRepository.findAll();
    }

    public TrashPoint getPoint(TrashPoint trashPoint) {
        return trashPoint;
    }

    public TrashPoint setFullPoint( Long id, boolean isFull) {
        TrashPoint point = pointRepository.findById(id).orElseThrow(new ObjectNotFoundException(id));
        point.setFull(isFull);
        return pointRepository.save(point);
    }
}
