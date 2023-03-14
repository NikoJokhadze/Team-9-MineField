package mvc;

/* Class "Command" Datalog

3/10/2023 - Niko Jokhadze: Created file
3/12/2023 - Hazuki Sugahara: edited file
3/14/2023 - Hazuki Sugahara

 */

public abstract class Command {
    
    private Model model;

    public Command(Model model){
        this.model = model;
    }
  
    abstract void execute()

    abstract void undo()
}
