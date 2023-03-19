package mvc;

/* Class "AppFactory" Datalog

3/10/2023 - Niko Jokhadze: Created file

3/11/2023 - Owen Semersky: Changed file from a class to an interface.
                           Added interface methods.
3/17/2023 - Niko Jokhadze: Changed getEditCommands to a type String array
                           Edited makeEditCommand

 */

public interface AppFactory {
    Model makeModel();

    View makeView(Model m);

    String getTitle();

    String[] getHelp();

    String about();

    String[] getEditCommands();

    Command makeEditCommand(Model model, String name, Object source);
}