package Commands;

import Core.CollectionManager;

public class ClearCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        collectionManager.clear();
        System.out.println("Коллекция отчистилась");
        return true;
    }
}
