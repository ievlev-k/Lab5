package Core;

import Date.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.io.InputStreamReader;
import java.util.*;

public class CommandAsker {

    private static final Scanner scanner = new Scanner(System.in);
    private final InputChecker inputChecker;

    public CommandAsker(InputChecker ic) {
        this.inputChecker = ic;
    }

    public Dragon createDragon() {
        Dragon newDragon = new Dragon();
        System.out.println("Созвдаем Dragon");
        newDragon.setId(idAsker());
        newDragon.setName(nameAsker());
        newDragon.setCoordinates(coordinatesAsker());
        newDragon.setCreationDate(dateAsker());
        newDragon.setAge(ageAsker());
        newDragon.setDescription(descriptionAsker());
        newDragon.setWeight(weightAsker());
        newDragon.setCharacter(characterAsker());
        newDragon.setCave(dragonCaveAsker());
        return newDragon;
    }

    public long idAsker() {
        System.out.println("Id генерируется само.");
        long newID = new Random().nextLong();
        if (CollectionManager.IDChecker.contains(newID) || newID < 0) {
            return idAsker();
        } else {
            CollectionManager.IDChecker.add(newID);
            System.out.println("ID = " + newID + " успешно сгенерировался");
            return newID;
        }
    }

    public String nameAsker() {
        while (true) {
            System.out.println("Вставте имя: ");
            String name = scanner.nextLine().trim();
            if (name.equals("")) {
                System.out.println("Вставсте имя еще раз. Name не может быть пустым.");
            } else {
                return name;
            }

        }


    }

    public Coordinates coordinatesAsker() {
        System.out.println("Ввод координат: ");
        System.out.println("Введите X: ");
        long X = longAsker(Long.MIN_VALUE, Long.MAX_VALUE, false);
        System.out.println("Введите Y: ");
        float Y = floatAsker(-Float.MIN_VALUE, 221, false);
        return new Coordinates(X, Y);
    }

    public LocalDateTime dateAsker() {
        return java.time.LocalDateTime.now();
    }

    public Integer ageAsker() {
        System.out.println("Введите age: ");
        return intAsker(0, Integer.MAX_VALUE, false);
    }

    public String descriptionAsker() {
        System.out.println("Введите discription: ");
        return scanner.nextLine();
    }

    public int weightAsker() {
        System.out.println("Введите weight: ");
        return intAsker(0, Integer.MAX_VALUE, false);
    }

    public DragonCharacter characterAsker() {
        while (true) {
            System.out.println("Введите character: ");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if (inputNumber.length != 1) {
                System.out.println("Введите тоько 1 character");
            } else {
                try {
                    return DragonCharacter.valueOf(inputNumber[0]);
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверный character! Такого character нет");
                    System.out.println("Введите характер из следующего списка");
                    for (DragonCharacter dragonCharacter : DragonCharacter.values()) {
                        System.out.println(dragonCharacter);
                    }
                }
            }
        }
    }

    public DragonCave dragonCaveAsker() {
        System.out.println("Введите depth: ");
        long depth = longAsker(Long.MIN_VALUE, Long.MAX_VALUE, true);
        System.out.println("Введите numberOfTreasures: ");
        float numberOfTreasures = floatAsker(0, Float.MAX_VALUE, true);

        return new DragonCave(depth, numberOfTreasures);

    }


    public Integer intAsker(int min, int max, boolean canEmpty) {
        while (true) {
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if (canEmpty && inputNumber[0].equals("")) {
                return null;
            } else {
                if (inputNumber.length != 1) {
                    System.out.println("Введите ровно 1 integer число: ");
                } else {
                    if (!inputChecker.intChecker(inputNumber[0], min, max, canEmpty)) continue;
                    return Integer.parseInt(inputNumber[0]);
                }
            }
        }
    }


    public Long longAsker(long min, long max, boolean canEmpty) {
        while (true) {

            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if (canEmpty && inputNumber[0].equals("")) {
                return null;
            } else {
                if (inputNumber.length != 1) {
                    System.out.println("Введите ровно 1 long число: ");
                } else {
                    if (!inputChecker.longChecker(inputNumber[0], min, max, canEmpty)) continue;
                    return Long.parseLong(inputNumber[0]);

                }
            }
        }
    }


    public Float floatAsker(float min, float max, boolean canEmpty) {
        while (true) {
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if (canEmpty && inputNumber == null) {
                return null;
            }
            if (inputNumber.length != 1) {
                System.out.println("Введите ровно 1 float число: ");
            } else {
                if (!inputChecker.floatChecker(inputNumber[0], min, max, canEmpty)) continue;
                return Float.parseFloat(inputNumber[0]);
            }
        }
    }
}


