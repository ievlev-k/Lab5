package Core;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Commander {
    private final HashMap<String, Boolean> inStack = new HashMap<>();
    private final Scanner userScanner;
    private final CommandManager commandManager;
    private final String outputFile;

    static final String FILE_PATH = "src/main/java/File/";
    private final Deque<String> historyRecorder = new ArrayDeque<>(8);
    public Commander(Scanner sc, CommandManager cm, String oFile){
        this.userScanner = sc;
        this.commandManager = cm;
        this.outputFile = oFile;
    }


    public void interactiveMode(){
        while (true){
            if (!userScanner.hasNextLine()) System.exit(-1);
            String[] userCommand = userScanner.nextLine().trim().split(" ");
            if (userCommand.length > 2 ){
                System.out.println("Неверная комманда! Комманда содержит 1 или 2 аргумента.");
                continue;
            }
            if (userCommand[0].equals("Exit")){

                System.exit(0);

            }


            if (categorizeCommand(userCommand)){
                System.out.println("------------");
                System.out.println("Вы можете ввести следующую команду");

                continue;
            }

            updateHistory(userCommand[0]);
            System.out.println("-----------");
            System.out.println("Вы можете ввести следующую команду");
        }
    }

    public void updateHistory(String newCommand){
        String s;
        s = String.join(" ",newCommand);

        if (historyRecorder.size() == 8) historyRecorder.removeFirst();
        historyRecorder.addLast(s);
    }

    private boolean scriptMode(String fileName){
        System.out.println("Выполняется файл " + fileName  );
        if (inStack.get(fileName) != null){
            if (inStack.get(fileName)){
                System.out.println("Чтобы избежать рекурсии, файл " + fileName + " не может быть выполнен ");
                return false;
            }
        }
        inStack.put(fileName, true);

        File scriptFile =new File(FILE_PATH + fileName);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(scriptFile);
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("Этого файла не существует!");
            return false;
        }

        while (fileScanner.hasNextLine()){
            String[] userCommand = fileScanner.nextLine().trim().split(" ");
            if (userCommand.length > 2){
                System.out.println("Неверная комманда! Комманда содержит 1 или 2 аргумента.");
                continue;
            }
            if (categorizeCommand(userCommand)){
                System.out.println("Комманда не выполнена");
                continue;
            }
            System.out.println("");
            updateHistory(userCommand[0]);

        }


        return true;

    }


    private boolean categorizeCommand(String[] userCommand){
        switch (userCommand[0]){
            case "help":
                if(userCommand.length == 1){
                    return !commandManager.help();
                }
                return true;
            case "execute_script":
                if (userCommand.length != 1) {
                    return !scriptMode(userCommand[1]);
                }
                System.out.println("Нет названия файла");
                return true;

            case "info":
                if (userCommand.length == 1){
                    return !commandManager.info();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "show":
                if (userCommand.length == 1){
                    return !commandManager.show();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "add":
                if (userCommand.length == 1){
                    return !commandManager.add();
                }
                System.out.println("Для создания dragon нужно только написать 'add'");
                return true;
            case "clear":
                if (userCommand.length == 1){
                    return !commandManager.clear();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "update":
                if (userCommand.length == 2){
                    return !commandManager.update_id(userCommand[1]);

                }
                System.out.println("Вставте команду и id");
                return true;
            case "remove_by_id":
                if (userCommand.length == 2){
                    return !commandManager.remove_by_id(userCommand[1]);
                }
                System.out.println("Вставте команду и id");
            case "save":
                if (userCommand.length == 1){
                    return !commandManager.save(outputFile);
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "exit":
                if (userCommand.length == 1){
                    System.out.println("Работа программы завершена");
                    return !commandManager.exit();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "head":
                if (userCommand.length == 1){
                    return !commandManager.head();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "remove_head":
                if (userCommand.length == 1){
                    return !commandManager.remove_head();
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "history":
                if (userCommand.length == 1){
                    if (historyRecorder.size() == 0) System.out.println("История пуста!");
                    for (String cm: historyRecorder){
                        System.out.println(cm);
                    }
                    return false;
                }
                System.out.println("У этой команды нет аргумента");
                return true;
            case "remove_any_by_character":
                if (userCommand.length!=1){
                    return !commandManager.remove_any_by_character(userCommand[1]);
                }
                System.out.println("нет description");
                return true;

            case "min_by_weight":
                if (userCommand.length == 1){
                    return !commandManager.min_by_weight();
                }
                System.out.println("У этой команды нет аргумента");
                return true;

            case "print_unique_weight":
                if (userCommand.length == 1){
                    return !commandManager.print_unique_weight();
                }
                System.out.println("У этой команды нет аргумента");
                return true;



            default:
                System.out.println("Нет введненной команды");
                return true;
        }
    }
}
