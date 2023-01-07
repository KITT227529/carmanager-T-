package com.example.carmanager.Controller;

import com.example.carmanager.Model.Car;
import com.example.carmanager.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Get all car(s)
    @GetMapping("/cars")
    public ArrayList<Car> getCar(){
        carService.ReadCars();
        return carService.getCar();
    }

    //Add a new car
    @PostMapping("/cars")
    public void addNewCar(Car car){
        carService.addNewCar(car);
    }

    //Remove a car
    @DeleteMapping("/cars")
    public void removeCar(@RequestParam Long id) {
        carService.removeCar(id);
    }
}
