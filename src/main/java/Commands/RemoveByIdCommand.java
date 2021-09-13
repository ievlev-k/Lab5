package Commands;

import Core.CollectionManager;
import Core.CommandAsker;
import Core.InputChecker;

public class RemoveByIdCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;

    public RemoveByIdCommand(CollectionManager cm, InputChecker ic, CommandAsker ca) {
        this.collectionManager = cm;
        this.inputChecker = ic;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute(String argument) {
        if (inputChecker.longChecker(argument, 0, Long.MAX_VALUE, false)) {
            long id = Long.parseLong(argument);
            if (collectionManager.removeByID(id)) {
                System.out.println("Такого Id нет");
                return false;
            }
            System.out.println("Dragon с Id = " + id + " успешно удален");
            return true;
        }
        System.out.println("Введен неверный id. Тип id - intager, id больше 0");
        return false;
    }
}
