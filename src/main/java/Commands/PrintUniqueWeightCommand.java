package Commands;

import Core.CollectionManager;

public class PrintUniqueWeightCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public PrintUniqueWeightCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        return collectionManager.printUniqueWeight();
    }
}
