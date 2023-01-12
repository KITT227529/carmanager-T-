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
    public ArrayList<Car> getAllCars(){
        carService.ReadCars();
        return carService.getCars();
    }
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable String id){
        return carService.getCar(id);
    }

    //Add a new car
    @PostMapping(value = "/cars", produces = {"application/json"}, consumes = {"application/json"})
    public void addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @PutMapping("/cars/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable String id){
        carService.updateCar(id, car);
    }
    @DeleteMapping("/cars/{id}")
    public void removeCar(@PathVariable String id) {
        carService.removeCar(id);
    }
}
