package Commands;

import Core.CollectionManager;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class HeadCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public HeadCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        System.out.println("Этот элемент является началом коллекции");
        return collectionManager.head();
    }
}
