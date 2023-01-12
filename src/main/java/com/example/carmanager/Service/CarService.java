package com.example.carmanager.Service;

import com.example.carmanager.Model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CarService {
    private ArrayList<Car> cars = XMLRead.ReadFile();


    public ArrayList<Car> getCars(){
        return cars;
    }
    public Car getCar(String id) {return cars.get(Integer.parseInt(id));}

    public ArrayList<Car> addNewCar (Car car){
        cars.add(car);
        XMLWrite.Save(cars);

        return cars;
    }
    public Boolean removeCar (String id) {

        int intID = Integer.parseInt(id);
        if (intID < cars.size()) {
            cars.remove(intID);
            XMLWrite.Save(cars);
            return true;
        }else{
            return false;
        }

    }

    public void updateCar(String id, Car car){

        Integer intID = Integer.parseInt(id);

        if (intID >= cars.size()){
            cars.set(intID,car);
        }
    }
}
