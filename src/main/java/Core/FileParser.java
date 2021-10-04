package Core;

import Date.Coordinates;
import Date.Dragon;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

import Date.DragonCave;
import Date.DragonCharacter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileParser {

    public PriorityQueue<Dragon> parse(String inputFileName) throws Exception {
        File xmlFile = new File(inputFileName);
        PriorityQueue<Dragon> dragonList = new PriorityQueue<Dragon>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("dragon");

            for (int i = 0; i < nodeList.getLength(); i++) {
                dragonList.add(getDragon(nodeList.item(i)));
            }
        } catch (IOException e) {
            System.out.println("Файл не устраивает>");
        } catch (SAXException e) {
            System.out.println("l");
        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка с конфигом");
        } catch (NumberFormatException | NullPointerException exception) {
            System.out.println("Неверные данные в файле");
        }


        return dragonList;
    }

    private Dragon getDragon(Node node) {
        Dragon d = new Dragon();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element e = (Element) node;


            // set ID
            long newID = Integer.parseInt(getTagValue("ID", e));

            if (CollectionManager.IDChecker.contains(newID)) {
                System.out.println("Не верное ID");
            } else {
                CollectionManager.IDChecker.add(newID);
                d.setId(newID);
            }

            // set Name
            d.setName(getTagValue("Name", e));

            // set Coordinaties
            d.setCoordinates(new Coordinates(Long.parseLong(getTagValue("X", e)), Long.parseLong(getTagValue("Y", e))));

            // set LocalDareTime

            String dateString = getTagValue("CreationDate", e);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
            d.setCreationDate(dateTime);

            //set age
            d.setAge(Integer.parseInt(getTagValue("Age", e)));

            //set description
            d.setDescription(getTagValue("Description", e));

            //set weight

            d.setWeight(Integer.parseInt(getTagValue("Weight", e)));

            //set character

            String character = getTagValue("Character", e);
            DragonCharacter dragonCharacter = DragonCharacter.valueOf(character);
            d.setCharacter(dragonCharacter);

            //set cave

            d.setCave(new DragonCave(Long.parseLong(getTagValue("Depth", e)), Float.parseFloat(getTagValue("NumberOfTreasures", e))));
        }
        return d;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }


}
