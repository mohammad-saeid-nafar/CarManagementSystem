package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String add(@RequestBody Car car) {
        carService.saveCar(car);
        return "New car is sucessfully added";
    }

    @GetMapping("/getAll")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}
