package Commands;

public class HalpCommand extends AbstractCommand {
    @Override
    public boolean execute() {
        System.out.println("help                                - вывести справку по доступным командам");
        System.out.println("info                                - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show                                - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element}                       - добавить новый элемент в коллекцию");
        System.out.println("update id {element}                 - обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id {id}                   - удалить элемент из коллекции по его id");
        System.out.println("clear                               - очистить коллекцию");
        System.out.println("save                                - сохранить коллекцию в файл");
        System.out.println("execute_script file_name            - читать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit                                - завершить программу (без сохранения в файл)");
        System.out.println("remove_head                         - вывести первый элемент коллекции и удалить его");
        System.out.println("head                                - вывести первый элемент коллекции");
        System.out.println("history                             - вывести последние 6 команд (без их аргументов)");
        System.out.println("remove_any_by_character character   - удалить из коллекции один элемент, значение поля character которого эквивалентно заданному");
        System.out.println("min_by_weight                       - вывести любой объект из коллекции, значение поля weight которого является минимальным");
        System.out.println("print_unique_weight                 - вывести уникальные значения поля weight всех элементов в коллекции");


        return true;
    }
}
