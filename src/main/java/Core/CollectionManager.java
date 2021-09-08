package Core;
import Date.*;
import com.opencsv.CSVWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;


import java.time.LocalDateTime;

public class CollectionManager {
    private ArrayDeque<Dragon> listDragon = new ArrayDeque<>();
    public static HashSet<Long> IDChecker = new HashSet<>();
    public final HashSet<Integer> WeightChecker = new HashSet<>();
    private final LocalDateTime creationDate = LocalDateTime.now();
    private final FileParser fileParser = new FileParser();
    private final FileParserCsv fileParserCsv =new FileParserCsv();

//    public void reedInputFromXmlFile(String InputFileName){
//        try {
//            listDragon = fileParser.parse(InputFileName);
//        }catch (Exception e){
//            System.out.println("Возникла непредвиденная ошибкаЭ");
//        }
//    }

    public void reedInputFromCsvFile(String InputFileName){
        try {
            listDragon = fileParserCsv.parse(InputFileName);
        }catch (Exception e){
            System.out.println("Возникла непредвиденная ошибка");
        }
    }

    public int size(){
        return listDragon.size();
    }

    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    public void add(Dragon D){
        listDragon.add(D);
    }



    public void clear(){ listDragon.clear();}

    public boolean removeHead(){
        int size = listDragon.size();
        if (size == 0){
            System.out.println("В коллекции нет элементов");
            return false;
        }


        if (size == 1){
            System.out.println(listDragon.peek());
            listDragon.clear();
            return true;
        }

        if (size > 1){
            Iterator<Dragon> iterator = listDragon.iterator();
            if (iterator.hasNext()){
                Dragon firstDragon = iterator.next();
                System.out.println(firstDragon);
                iterator.remove();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean head(){
        int size = listDragon.size();
        if (size == 0){
            System.out.println("В коллекции нет элементов");
            return true;
        }
        else
            { System.out.println(listDragon.peek());
                return true;
            }
    }


    public boolean addIfMin(Dragon D){
        Dragon minDragon = listDragon.peek();
        if (minDragon.compareTo(D)>0){
            listDragon.add(D);
            return true;
        }

        else {
            System.out.println("Этот дракон весит больше");
            return false;}
    }

    public boolean removeAnyByCharacter(DragonCharacter character){
        for (Dragon dragon: listDragon){
            if (dragon.getCharacter() == character){
                listDragon.remove(dragon);
                return true;
            }
        }
        System.out.println("Dragon с таким character нет");
        return false;
    }


    public void removeAllByDescription(String description){
        listDragon.removeIf( dragon -> dragon.getDescription().equals(description) );
    }

    public void minByWeight(){
        if (listDragon.size()>0){
            int[] a = new int[listDragon.size()];
            int index = 0;
            for (Dragon dragon : listDragon) {
                a[index] = dragon.getWeight();
                ++index;
            }
            int min = a[0];
            for (int i : a) {
                if (i < min) {
                    min = i;
                }
            }
            for (Dragon dragon : listDragon) {
                if (dragon.getWeight() == min) {
                    System.out.println(dragon);
                    System.out.println("Этот dragon имеет минимальный weight");

                } else {
                    System.out.println("Коллекция пуста");
                }
            }
        }else{
            System.out.println("Коллекция пуста!");
        }

    }

    public boolean printUniqueWeight(){
        if(listDragon.size()>0){
            System.out.print("Уникальные значения weight коллекции: ");
            for (Dragon dragon : listDragon) {
                if (WeightChecker.contains(dragon.getWeight())) {
                    continue;
                } else {
                    System.out.print(dragon.getWeight()+ " ");
                    WeightChecker.add(dragon.getWeight());
                }
            }
            System.out.println("");
            return true;
        }
        System.out.println("Коллекция пуста!");
        return false;
    }

    public void printCollectiom(){
        if(listDragon.size() == 0){
            System.out.println("Коллекция пуста");
        }
        else {
            listDragon.forEach(p -> System.out.println(p.toString()));
        }
    }

    public void printElement(DragonCharacter character){listDragon.forEach(p -> {if (p.getCharacter()==character ){
        System.out.println(p.toString());
    }});}

    public void countWeight( int weight){
        int count = 0;
        for (Iterator<Dragon> iterator = listDragon.iterator();iterator.hasNext();){
            Dragon dragon = iterator.next();
            if (dragon.getWeight()>weight){
                count+=1;
            }
        }
        System.out.println("Количество Dragon, вес которых больше " + weight +", равно " + count);
    }

    public void filterGreater (String characret){

    }



    public boolean removeByID(long id){
        boolean flag = false;
        for (Iterator<Dragon> iterator = listDragon.iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            if(dragon.getId() == id){
                flag = true;
                iterator.remove();

            }
        }
        return !flag;
    }


    public void saveCsv(String fileName){
        try (PrintWriter pw = new PrintWriter(fileName); CSVWriter writer = new CSVWriter(pw,",".charAt(0),'"','"',"\n")){
            for (Dragon dragon : listDragon){
                writer.writeNext(new String[]{
                        String.valueOf(dragon.getId()),
                        dragon.getName(),
                        String.valueOf(dragon.getCoordinates().getX()),
                        String.valueOf(dragon.getCoordinates().getY()),
                        String.valueOf(dragon.getCreationDate()),
                        String.valueOf(dragon.getAge()),
                        dragon.getDescription(),
                        String.valueOf(dragon.getWeight()),
                        String.valueOf(dragon.getCharacter()),
                        String.valueOf(dragon.getCave().getDepth()),
                        String.valueOf(dragon.getCave().getNumberOfTreasures())
                });
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }



}
