package Commands;

import Core.CollectionManager;

public class RemoveHeadCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public RemoveHeadCommand(CollectionManager cm){
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        return collectionManager.removeHead();
    }
}
