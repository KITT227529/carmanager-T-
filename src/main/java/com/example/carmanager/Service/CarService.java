package com.example.carmanager.Service;

import com.example.carmanager.Controller.XMLRead;
import com.example.carmanager.Model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CarService {
    ArrayList<Car> cars = XMLRead.getCars();

    public void ReadCars(){
        XMLRead.XMLRead();
    }

    public ArrayList<Car> getCar(){
        return cars;
    }

    public void addNewCar (Car car){
        cars.add(car);
    }

    public void removeCar (Long id) {

//        cars = (ArrayList<Car>) cars.stream().filter(car -> car.getId()!=id).
//                collect(Collectors.toList());
        cars.remove(id);

    }

}
