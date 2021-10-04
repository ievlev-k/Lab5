package Core;

import Date.Coordinates;
import Date.Dragon;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

import Date.DragonCave;
import Date.DragonCharacter;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvMalformedLineException;

/**
 * этот класс используется для анализа файла CSV и сохранения данных в коллекцию
 */


import com.opencsv.exceptions.CsvValidationException;

public class FileParserCsv {
    public ArrayDeque<Dragon> parse(String imputFileName) throws IOException {
        ArrayDeque<Dragon> listDragon = new ArrayDeque<>();
        String delimiter = ",";
        CSVParser parser = new CSVParserBuilder().withSeparator(delimiter.charAt(0)).build();
        try (FileInputStream fileInputStream = new FileInputStream(imputFileName);
             BufferedInputStream bis = new BufferedInputStream(fileInputStream);
             BufferedReader br = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));
             CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).build()
        ) {
            String[] line;
            int lineCount = 1;
            do {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                if (line.length != 11) {
                    System.out.println("Не удалось загрузить элемент. Строка " + lineCount + " имеет неверный формат");

                } else {
                    Dragon dragon = TransformArgument(line, lineCount);
                    if (dragon != null) {
                        int key = 1;
                        ++key;
                        listDragon.add(dragon);

                    }

                }
            } while (true);


        } catch (IOException e) {
            System.out.println("Этот файл не правильный или возможно это вообще не файл");
            e.printStackTrace();
            System.exit(-1);
        } catch (CsvValidationException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return listDragon;
    }


    private Dragon TransformArgument(String[] arguments, int count) {
        try {
            for (String argument : arguments) {
                Dragon d = new Dragon();
                if (argument.isEmpty()) throw new Exception();

                long newID = Long.parseLong(arguments[0]);
                if (newID > 0) {
                    if (CollectionManager.IDChecker.contains(newID)) {
                        System.out.println("Не верное ID");
                    } else {
                        CollectionManager.IDChecker.add(newID);
                        d.setId(newID);
                    }
                } else {
                    System.out.println("Не удалось добавить элемент номер " + count + ", Некоторые данные введены неверно!");
                    return null;
                }

                d.setName(arguments[1]);

                if (Float.parseFloat(arguments[3]) <= 211) {
                    d.setCoordinates(new Coordinates(Long.parseLong(arguments[2]), Float.parseFloat(arguments[3])));
                } else {
                    System.out.println("Не удалось добавить элемент номер " + count + ", Некоторые данные введены неверно!");
                    return null;
                }

                String dateString = arguments[4];
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
                d.setCreationDate(dateTime);

                if (Integer.parseInt(arguments[5]) > 0) {
                    d.setAge(Integer.parseInt(arguments[5]));
                } else {
                    System.out.println("Не удалось добавить элемент номер " + count + ", Некоторые данные введены неверно!");
                    return null;
                }

                d.setDescription(arguments[6]);

                if (Integer.parseInt(arguments[7]) > 0) {
                    d.setWeight(Integer.parseInt(arguments[7]));
                } else {
                    System.out.println("Не удалось добавить элемент номер " + count + ", Некоторые данные введены неверно!");
                    return null;
                }

                String character = arguments[8];

                DragonCharacter dragonCharacter = DragonCharacter.valueOf(character);
                d.setCharacter(dragonCharacter);

                if (Float.parseFloat(arguments[10]) > 0) {
                    d.setCave(new DragonCave(Long.parseLong(arguments[9]), Float.parseFloat(arguments[10])));
                } else {
                    System.out.println("Не удалось добавить элемент номер " + count + ", Некоторые данные введены неверно!");
                    return null;
                }

                return d;
            }
        } catch (Exception e) {
            System.out.print("Не удалось добавить элемент номер " + count + ". Некоторые данные введены неверно!");
            System.out.println("");
            e.printStackTrace();
            return null;
        }
        return null;
    }
}