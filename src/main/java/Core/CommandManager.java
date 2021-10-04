package Core;

import Commands.*;

public class CommandManager {

    private final Command helpCommand;
    private final Command addCommand;
    private final Command infoCommand;
    private final Command saveCommand;
    private final Command showCommand;
    private final Command printUniqueWeightCommand;
    private final Command updateIdCommand;
    private final Command removeByIdCommand;
    private final Command clearCommand;
    private final Command exitCommand;
    private final Command headCommand;
    private final Command removeHeadCommand;
    private final Command minByWeightCommand;
    private final Command removeAnyByCharacterCommand;

    public CommandManager(Command helpCommand, Command saveCommand,
                          Command printUniqueWeightCommand, Command minByWeightCommand,
                          Command removeAnyByCharacterCommand, Command removeHeadCommand, Command addCommand,
                          Command infoCommand, Command HeadCommand, Command showCommand, Command updateIdCommand,
                          Command removeByIdCommand, Command clearCommand, Command exitCommand) {
        this.helpCommand = helpCommand;
        this.saveCommand = saveCommand;
        this.printUniqueWeightCommand = printUniqueWeightCommand;
        this.removeAnyByCharacterCommand = removeAnyByCharacterCommand;
        this.addCommand = addCommand;
        this.minByWeightCommand = minByWeightCommand;
        this.removeHeadCommand = removeHeadCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.updateIdCommand = updateIdCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.exitCommand = exitCommand;
        this.headCommand = HeadCommand;
    }

    public boolean help() {
        return helpCommand.execute();
    }

    public boolean add() {
        return addCommand.execute();
    }

    public boolean info() {
        return infoCommand.execute();
    }

    public boolean show() {
        return showCommand.execute();
    }

    public boolean min_by_weight() {
        return minByWeightCommand.execute();
    }

    public boolean update_id(String argument) {
        return updateIdCommand.execute(argument);
    }

    public boolean remove_by_id(String argument) {
        return removeByIdCommand.execute(argument);
    }

    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    public boolean clear() {
        return clearCommand.execute();
    }

    public boolean exit() {
        return exitCommand.execute();
    }

    public boolean remove_head() {
        return removeHeadCommand.execute();
    }

    public boolean remove_any_by_character(String argument) {
        return removeAnyByCharacterCommand.execute(argument);
    }

    public boolean print_unique_weight() {
        return printUniqueWeightCommand.execute();
    }

    public boolean head() {
        return headCommand.execute();
    }
}
