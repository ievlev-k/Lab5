package Commands;

import Core.CollectionManager;

import javax.naming.Name;

public class SaveCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public SaveCommand(CollectionManager cm){
        this.collectionManager = cm;
    }

    @Override
    public boolean execute(String fileName) {
        collectionManager.saveCsv(fileName);
        System.out.println("Коллекция успешно сохранена!");
        return true;
    }
}
