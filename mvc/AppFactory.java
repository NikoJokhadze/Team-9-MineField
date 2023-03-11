package mvc;

/* Class "AppFactory" Datalog

3/10/2023 - Niko Jokhadze: Created file

3/11/2023 - Owen Semersky: Changed file from a class to interface, added interface methods.

 */

public interface AppFactory {
    public Model makeModel();

    public View makeView();

    public String getTitle();

    public String getHelp();

    public String about();

    public String getEditCommands();

    public Command makeEditCommand(String name);
}
