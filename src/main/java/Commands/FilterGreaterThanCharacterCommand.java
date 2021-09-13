package Commands;

import Core.CollectionManager;
import Date.DragonCharacter;

public class FilterGreaterThanCharacterCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public FilterGreaterThanCharacterCommand(CollectionManager cm) {
        this.collectionManager = cm;
    }

    @Override
    public boolean execute(String argument) {
        try {
            DragonCharacter character = DragonCharacter.valueOf(argument);
            if (character == DragonCharacter.CUNNING) {
                collectionManager.printElement(DragonCharacter.FICKLE);
                collectionManager.printElement(DragonCharacter.EVIL);
            }
            if (character == DragonCharacter.FICKLE) {
                collectionManager.printElement(DragonCharacter.EVIL);
            }
            if (character == DragonCharacter.EVIL) {
                System.out.println("Выше этоге значения нет");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный character! Такого character нет");
            System.out.println("Введите характер из следующего списка");
            for (DragonCharacter dragonCharacter : DragonCharacter.values()) {
                System.out.println(dragonCharacter);
            }
        }
        return super.execute(argument);
    }
}
