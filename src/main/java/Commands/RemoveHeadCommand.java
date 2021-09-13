package Commands;

import Core.CollectionManager;

public class RemoveHeadCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public RemoveHeadCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        System.out.println("Был удален вот этот объект. Он являлся началом коллекции");
        return collectionManager.removeHead();
    }
}
