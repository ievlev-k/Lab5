package Commands;
import Core.*;
public class UpdateIdCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;
    public UpdateIdCommand(CollectionManager cm, InputChecker ic, CommandAsker ca){
        this.collectionManager = cm;
        this.inputChecker = ic;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute(String argument) {
        if(inputChecker.intChecker(argument,0, Integer.MAX_VALUE, false)){
            int id = Integer.parseInt(argument);
            if (collectionManager.removeByID(id)){
                System.out.println("Такого Id нет");
                return false;
            }
            collectionManager.add(commandAsker.createDragon());
            System.out.println("Dragon успешно обновлен!");
            return true;
        }
        System.out.println("Введен неверный id. Тип id - intager, id больше 0");
        return false;
    }
}
