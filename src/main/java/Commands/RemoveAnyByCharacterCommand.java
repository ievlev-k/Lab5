package Commands;

import Core.CollectionManager;
import Date.DragonCharacter;

public class RemoveAnyByCharacterCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    public RemoveAnyByCharacterCommand(CollectionManager cm){
        this.collectionManager = cm;
    }

    @Override
    public boolean execute(String argument) {
        try {
            DragonCharacter character = DragonCharacter.valueOf(argument);

            return collectionManager.removeAnyByCharacter(character);
        }catch (IllegalArgumentException e){
            System.out.println("Неверный character! Такого character нет");
            System.out.println("Введите характер из следующего списка");
            for (DragonCharacter dragonCharacter : DragonCharacter.values()){
                System.out.println(dragonCharacter);
            }
            return false;
        }

    }
}
