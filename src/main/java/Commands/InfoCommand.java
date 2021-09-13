package Commands;

import Core.*;

public class InfoCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        System.out.println("Тип коллекции: ArrayDequeue");
        System.out.println("Дата инициализации: " + collectionManager.getCreationDate());
        System.out.println("Размер коллекции: " + collectionManager.size());
        return true;
    }
}
