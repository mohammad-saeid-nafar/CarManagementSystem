package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.model.Car;

import java.util.List;

public interface CarService {

    public Car saveCar(Car car);

    public List<Car> getAllCars();

}
