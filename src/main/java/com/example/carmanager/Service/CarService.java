package com.example.carmanager.Service;

import com.example.carmanager.Controller.XMLRead;
import com.example.carmanager.Controller.XMLWrite;
import com.example.carmanager.Model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CarService {
    private static ArrayList<Car> cars = XMLRead.getCars();
    public void ReadCars(){ XMLRead.XMLRead(); }


    public ArrayList<Car> getCars(){
        return cars;
    }

    public ArrayList<Car> addNewCar (Car car){
        cars.add(car);
        XMLWrite.Save(cars);

        return cars;
    }
    public ArrayList<Car> removeCar (Integer id) {

        cars.remove(id);
        XMLWrite.Save(cars);
        return cars;
    }


    //TODO: UPDATE METHOD

    public ArrayList<Car> updateCar(Integer id){
        //cars.
        return getCars();
    }
}
