package Commands;

import Core.*;
import Date.Dragon;

public class AddIfMinCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;
    public AddIfMinCommand(CollectionManager cm, InputChecker ic, CommandAsker ca){
        this.collectionManager = cm;
        this.inputChecker = ic;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute() {
        if (collectionManager.addIfMin(commandAsker.createDragon())){
            System.out.println("Dragon успешно создан!");
            return true;

        }
        else{

            return false;}

    }
}

