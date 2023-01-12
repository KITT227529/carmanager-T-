package com.example.carmanager.Controller;

import com.example.carmanager.Model.Car;
import com.example.carmanager.Service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CarController {
    private final CarService carService;
    private Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ArrayList<Car> getAllCars(){
        logger.info("Cars are listed.");
        return carService.getCars();

    }
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable String id){

        logger.info("Selected car listed.");
        return carService.getCar(id);
    }

    //Add a new car
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cars", produces = {"application/json"}, consumes = {"application/json"})
    public void addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
        logger.info("New car added.");
    }

    @PutMapping("/cars/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable String id){
        carService.updateCar(id, car);
        logger.info("Selected car updated");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/cars/{id}")
    public void removeCar(@PathVariable String id) {
        if (carService.removeCar(id)){
            logger.info("Selected car removed");
        }else{
            logger.error("Selected car cannot be removed.");
        }

    }


    //TODO: Specific autók kilistázása
}
