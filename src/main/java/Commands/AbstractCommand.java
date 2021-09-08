package Commands;
/**
 * Этот абстрактный класс создан, чтобы избежать реализации всех ненужных методов интерфейса
 */
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
