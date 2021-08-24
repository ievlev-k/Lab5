package Commands;
import Core.*;
public class ShowCommand extends AbstractCommand{
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager cm){
        this.collectionManager = cm;
    }

    @Override
    public boolean execute() {
        collectionManager.printCollectiom();
        return true;
    }
}
