package com.example.carmanager.Service;

import com.example.carmanager.Model.Car;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import java.util.ArrayList;

@Service
public class CarService {
    private ArrayList<Car> cars = XMLRead.ReadFile();
    public ArrayList<Car> getCars(){
        return cars;
    }
    public Car getCar(String id) { return cars.get(Integer.parseInt(id)); }
    public ArrayList<Car> addNewCar (Car car) throws DuplicateKeyException {
        Boolean tru = false;
        for (Car forCar:cars) {
            if (forCar.getId().equals(car.getId())){
                tru = true;
                throw new IllegalArgumentException("Duplikált azonosító. Adjon meg másikat");
            }
        }
        if (!tru){
            cars.add(car);
            XMLWrite.Save(cars);
        }
        return cars;

    }
    public Boolean removeCar (String id) {
        int intID = Integer.parseInt(id);
        for (int i = 0; i<cars.size();i++) {
            if (cars.get(i).getId().equals(intID)){
                cars.remove(i);
                break;
            }

        }
        XMLWrite.Save(cars);
        return true;
    }
    public Boolean updateCar(Car car){
        for (int i = 0; i<cars.size();i++) {
            if (cars.get(i).getId().equals(car.getId())){
                cars.set(i,car);
                XMLWrite.Save(cars);
                return true;
            }
        }
        return false;
    }

}
