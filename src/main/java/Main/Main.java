package Main;
import Commands.*;
import Core.*;
import Date.DragonCave;

import java.io.*;
import java.nio.*;
import java.util.Scanner;

public class Main {
//    static final String FILE_PATH = "src/main/java/File/";
    static String fileName;

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        try {
            fileName = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вставте ввод файла с помощью аргумента командной строки");
            System.exit(-1);
        }
        if (fileName.matches("[/\\\\]dev.*")) {
            System.out.println("Не могу исполнить данный файл");
            System.exit(-1);
        }else{
            collectionManager.reedInputFromCsvFile(fileName);
        }


        InputChecker inputChecker = new InputChecker();
        CommandAsker commandAsker = new CommandAsker(inputChecker);
        CommandManager commandManager = new CommandManager(
                new HalpCommand(),
                new SaveCommand(collectionManager),
                new PrintUniqueWeightCommand(collectionManager),
                new MinByWeightCommand(collectionManager),
                new RemoveAnyByCharacterCommand(collectionManager),
                new RemoveHeadCommand(collectionManager),
                new AddCommand(collectionManager,commandAsker),
                new InfoCommand(collectionManager),
                new HeadCommand(collectionManager),
                new ShowCommand(collectionManager),
                new UpdateIdCommand(collectionManager,inputChecker,commandAsker),
                new RemoveByIdCommand(collectionManager,inputChecker,commandAsker),
                new ClearCommand(collectionManager),
                new ExitCommand()
        );
        Commander commander = new Commander(new Scanner(System.in),commandManager, fileName);
        System.out.println("Программа готова начать. Введите команду.");


        commander.interactiveMode();


    }
}
