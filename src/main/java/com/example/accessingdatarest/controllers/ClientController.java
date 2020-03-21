package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.model.TrashPoint;
import com.example.accessingdatarest.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    @Autowired
    private PointRepository pointRepository;

    @PostMapping(path = "/point")
    public TrashPoint addNewPoint(@RequestBody TrashPoint point) {
        return pointRepository.save(point);
    }

    @GetMapping(path = "/point")
    public @ResponseBody
    Iterable<TrashPoint> getAllPoints() {
        return pointRepository.findAll();
    }

    @GetMapping(path = "/point/{id}")
    public TrashPoint getPoint(@PathVariable("id") TrashPoint trashPoint) {
        return trashPoint;
    }

//    @PostMapping(path = "/users/add")
//    public @ResponseBody
//    String addNewUser(@RequestParam String name,
//                      @RequestParam String phone) {
//        User n = new User();
//        n.setFirstName(name);
//        n.setPhone(phone);
//        userRepository.save(n);
//        return "Saved";
//    }
//
//    @GetMapping(path = "/users/all")
//    public @ResponseBody
//    Iterable<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping(path = "/users/{id}")
//    public @ResponseBody User getUser(@PathVariable String id) {
//        return userRepository.findById(Long.parseLong(id));
//    }
}