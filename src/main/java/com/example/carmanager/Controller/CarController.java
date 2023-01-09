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
    public ArrayList<Car> getCars(){
        carService.ReadCars();
        return carService.getCars();
    }

    //Add a new car
    @PostMapping(value = "/cars", produces = {"application/json"}, consumes = {"application/json"})
    public void addNewCar(@RequestBody Car car){
        System.out.println(car);
        carService.addNewCar(car);
        getCars();
    }

    //Remove a car
    @DeleteMapping("/cars")
    public void removeCar(@RequestParam String id) {
        carService.removeCar(Integer.parseInt(id));
    }

    //TODO: UPDATE METHOD
}
