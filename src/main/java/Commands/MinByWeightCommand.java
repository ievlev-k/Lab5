package Commands;

import Core.CollectionManager;

public class MinByWeightCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public MinByWeightCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        collectionManager.minByWeight();
        return true;
    }
}
