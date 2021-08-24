package Commands;
import Core.*;
public class CountGreaterThanWeightCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    public CountGreaterThanWeightCommand(CollectionManager cm, InputChecker ic) {
        this.collectionManager = cm;
        this.inputChecker =ic;
    }

    @Override
    public boolean execute(String argument) {
        if (inputChecker.intChecker(argument,0, Integer.MAX_VALUE,false)){
            collectionManager.countWeight(Integer.parseInt(argument));

            return true;}
        return false;
    }
}
