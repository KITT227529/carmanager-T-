package com.example.carmanager.Service;

import com.example.carmanager.Controller.XMLRead;
import com.example.carmanager.Model.Car;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    public List<Car> getCar(){
        return XMLRead.XMLRead();
    }

    public void addNewCar (Car car){
        System.out.println(car);
    }
}
