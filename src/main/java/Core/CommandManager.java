package Core;
import Commands.*;
public class CommandManager {

    private final Command HelpCommand;
    private final Command AddCommand;
    private final Command InfoCommand;
    private final Command SaveCommand;
    private final Command ShowCommand;
    private final Command PrintUniqueWeightCommand;
    private final Command UpdateIdCommand;
    private final Command RemoveByIdCommand;
    private final Command ClearCommand;
    private final Command ExitCommand;
    private final Command HeadCommand;
    private final Command RemoveHeadCommand;
    private final Command MinByWeightCommand;
    private final Command RemoveAnyByCharacterCommand;
    public CommandManager(Command helpCommand, Command saveCommand,
                          Command printUniqueWeightCommand, Command minByWeightCommand,
                          Command removeAnyByCharacterCommand, Command removeHeadCommand, Command addCommand,
                          Command infoCommand,Command HeadCommand, Command showCommand, Command updateIdCommand,
                          Command removeByIdCommand, Command clearCommand, Command exitCommand){
        this.HelpCommand = helpCommand;
        this.SaveCommand = saveCommand;
        this.PrintUniqueWeightCommand = printUniqueWeightCommand;
        this.RemoveAnyByCharacterCommand =removeAnyByCharacterCommand;
        this.AddCommand = addCommand;
        this.MinByWeightCommand = minByWeightCommand;
        this.RemoveHeadCommand = removeHeadCommand;
        this.InfoCommand = infoCommand;
        this.ShowCommand = showCommand;
        this.UpdateIdCommand = updateIdCommand;
        this.RemoveByIdCommand = removeByIdCommand;
        this.ClearCommand = clearCommand;
        this.ExitCommand = exitCommand;
        this.HeadCommand = HeadCommand;
    }

    public boolean help(){
        return HelpCommand.execute();
    }

    public boolean add(){
        return AddCommand.execute();
    }

    public boolean info(){
        return InfoCommand.execute();
    }

    public boolean show(){
        return ShowCommand.execute();
    }

    public boolean min_by_weight(){
        return MinByWeightCommand.execute();
    }

    public boolean update_id(String argument){ return UpdateIdCommand.execute(argument);}

    public boolean remove_by_id(String argument){
        return RemoveByIdCommand.execute(argument);
    }

    public boolean save(String argument){return SaveCommand.execute(argument);}

    public boolean clear(){return ClearCommand.execute();}

    public boolean exit(){return ExitCommand.execute();}

    public boolean remove_head(){
        return RemoveHeadCommand.execute();
    }

    public boolean remove_any_by_character(String argument){
        return RemoveAnyByCharacterCommand.execute(argument);
    }

    public boolean print_unique_weight(){
        return PrintUniqueWeightCommand.execute();
    }

    public boolean head(){return HeadCommand.execute();}
}
