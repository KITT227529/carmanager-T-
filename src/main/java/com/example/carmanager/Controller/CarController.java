package com.example.carmanager.Controller;

import com.example.carmanager.Model.Car;
import com.example.carmanager.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getCar(){
        return carService.getCar();
    }

    @PostMapping("/cars")
    public void postNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @DeleteMapping("/cars")
    public void removeCar(@RequestParam Long id) {
        carService.removeCar(id);
    }
}
