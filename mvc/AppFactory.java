package mvc;

/* Class "AppFactory" Datalog

3/10/2023 - Niko Jokhadze: Created file

3/11/2023 - Owen Semersky: Changed file from a class to an interface.
                           Added interface methods.

 */

public interface AppFactory {
    Model makeModel();

    View makeView();

    String getTitle();

    String getHelp();

    String about();

    String getEditCommands();

    Command makeEditCommand(String name);
}
