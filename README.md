# carmanager-T-
CAR
 - id (Integer)
 - make (String)
 - model (String)
 - price (Integer)
 - first_registration (Integer)
 - mileage (Integer)
 - fuel (ENUM)
 - bodytype (ENUM)
 - dop (LocalDate)
 
CONTROLLER implements ICar
 - getAllCars
 - getCar (String id)
 - addNewCar
 - updateCar (Car car)
 - removeCar (String id)

SERVICE
 - getCars
 - getCar (String id)
 - addNewCar (Car car)
 - removeCar (String id)
 - updateCar (Car car)

READ and WRITE file:
 - save (Arraylist<Car>)
 - readFile (Arraylist<Car>)
 
 API:  
 - Get: localhost:8080/cars
 - Get: localhost:8080/cars/{id}
 - POST: localhost:8080/cars
 - PUT: localhost:8080/cars  (
 - DELET: localhost:8080/cars/{id}
