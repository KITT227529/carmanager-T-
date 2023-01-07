package com.example.carmanager.Controller;

import com.example.carmanager.Model.Car;
import com.example.carmanager.Model.CarBodytypeEnum;
import com.example.carmanager.Model.CarFuelEnum;
import org.apache.tomcat.util.digester.ArrayStack;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLRead {
    private static ArrayList<Car> cars = new ArrayList<>();
    public static Document createFile(){
        try{
            File file = new File("src/main/java/com/example/carmanager/CarsXML.xml");
            DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docb = docbf.newDocumentBuilder();
            Document doc = docb.parse(file);
            doc.getDocumentElement().normalize();
            return doc;
        }
        catch(ParserConfigurationException | SAXException | IOException exception){
            Logger.getLogger(XMLRead.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }

    public static void XMLRead(){
        org.w3c.dom.Document doc = createFile();
        cars.clear();
        Car car;

        NodeList carNodes = doc.getElementsByTagName("Car");
        for (int i = 0; i < carNodes.getLength(); i++) {
            Node carNode = carNodes.item(i);

            if (carNode.getNodeType() == Node.ELEMENT_NODE) {
                Element carElement = (Element) carNode;

                Long id = Long.parseLong(carElement.getElementsByTagName("Azonosító").item(0).getTextContent());
                String make = carElement.getElementsByTagName("Márka").item(0).getTextContent();
                String model = carElement.getElementsByTagName("Modell").item(0).getTextContent();
                Integer price = Integer.parseInt(carElement.getElementsByTagName("Ár").item(0).getTextContent());
                Integer first_registration = Integer.parseInt(carElement.getElementsByTagName("Évjárat").item(0).getTextContent());
                Integer mileage = Integer.parseInt(carElement.getElementsByTagName("Km_futás").item(0).getTextContent());
                CarFuelEnum fuel = CarFuelEnum.valueOf(carElement.getElementsByTagName("Üzemanyag").item(0).getTextContent());
                CarBodytypeEnum bodytype = CarBodytypeEnum.valueOf(carElement.getElementsByTagName("Kivitel").item(0).getTextContent());
                LocalDate dop = LocalDate.parse(carElement.getElementsByTagName("Megvétel_ideje").item(0).getTextContent());

                car = new Car(id, make, model, price, first_registration, mileage, fuel, bodytype, dop);
                cars.add(car);
            }
        }
    }

    public static ArrayList<Car> getCars(){
        return cars;
    }
}
