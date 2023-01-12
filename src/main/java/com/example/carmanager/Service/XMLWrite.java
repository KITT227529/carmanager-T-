package com.example.carmanager.Service;

import com.example.carmanager.Model.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLWrite {

    private static File file = new File("src/main/java/com/example/carmanager/CarsXML.xml");

    public static void Save (ArrayList <Car> cars) {

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("Autók");
            document.appendChild(rootElement);

            for (Car car : cars) {

                Element carElement = document.createElement("Autó");

                rootElement.appendChild(carElement);

                createChildElement(document, carElement, "ID", car.getMake());
                createChildElement(document, carElement, "Márka", car.getMake());
                createChildElement(document, carElement, "Modell", car.getModel());
                createChildElement(document, carElement, "Ár", car.getPrice().toString());
                createChildElement(document, carElement, "Évjárat", car.getFirst_registration().toString());
                createChildElement(document, carElement, "Km_futás", car.getMileage().toString());
                createChildElement(document, carElement, "Üzemanyag", car.getFuel().toString());
                createChildElement(document, carElement, "Kivitel", car.getBodytype().toString());
                createChildElement(document, carElement, "Megvétel_ideje", car.getDop().toString());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(file));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createChildElement (Document document, Element parent, String tagName, String text){
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }

}
