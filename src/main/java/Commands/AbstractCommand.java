package Commands;

public abstract class AbstractCommand implements Command {
    @Override
    public boolean execute(String argument){
        return false;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
