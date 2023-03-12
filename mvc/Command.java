package mvc;

/* Class "Command" Datalog

3/10/2023 - Niko Jokhadze: Created file
3/12/2023 - Hazuki Sugahara: edited file

 */

public class Command {
    
    private Model model;
    private CommandProcessor processor = CommandProcessor.getInstance();

    public Command(Model model){
        this.model = model;
    }
  
    public void execute(){
        processor.execute(this);
    }

    public void undo(){
        processor.undo(this);
    }
}

class CommandProcessor {
  
    private static CommandProcessor single_instance = null;
  
    private CommandProcessor(){
    }
  
    public static synchronized CommandProcessor getInstance(){
        if(single_instance == null)
        {
            single_instance = new CommandProcessor();
        }
        return single_instance;
    }

    public void execute(Command command){

    }

    public void undo(Command command){

    }
}
