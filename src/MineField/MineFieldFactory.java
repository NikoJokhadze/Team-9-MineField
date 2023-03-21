package MineField;

import mvc.*;

/* Class "MineFieldFactory" Datalog
3/16/2023 - Niko Jokhadze: Created file
3/17/2023 - Hazuki Sugahara: Edited file
3/19/2023 - Owen Semersky: Added import statement.
3/19/2023 - Niko Jokhadze: Added reset button in dropdown
 */

public class MineFieldFactory implements AppFactory {

    public Model makeModel() { return new MineField(); }

    public View makeView(Model m) {
        return new MineFieldView((MineField)m);
    }

    public String[] getEditCommands() { return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE", "Reset"}; }

    public Command makeEditCommand(Model model, String type, Object source) {
        if(type == "N")
            return new MineFieldMoveCommand(model, Heading.NORTH);
        else if (type == "NW" )//create new statements for each commands
            return new MineFieldMoveCommand(model, Heading.NORTHWEST);
        else if (type == "NE")
            return new MineFieldMoveCommand(model, Heading.NORTHEAST);
        else if (type == "W")
            return new MineFieldMoveCommand(model, Heading.WEST);
        else if (type == "E")
            return new MineFieldMoveCommand(model, Heading.EAST);
        else if (type == "SW")
            return new MineFieldMoveCommand(model, Heading.SOUTHWEST);
        else if (type == "S")
            return new MineFieldMoveCommand(model, Heading.SOUTH);
        else if (type == "SE")
            return new MineFieldMoveCommand(model, Heading.SOUTHEAST);
        else if (type == "Reset")
            return new MineFieldMoveCommand(model, Heading.RESET);
        return null;
    }

    public String getTitle() { return "Mine Field"; }

    public String[] getHelp() {
        return new String[] {
                "North: Moves you one block up",
                "Northeast: Moves you to the upper right block",
                "East: Moves you one block right",
                "Southeast: Moves you to the lower right block",
                "South: Moves you one block down",
                "Southwest: Moves you to the lower left block",
                "West: Moves you one block left",
                "Northeast: Moves you to the upper left block",
                "Reset: Brings you back to the starting point",
        };
    }

    public String about() {
        return "Hazuki Sugahara, Owen Semersky, Niko Jokhadze" + "\n2023. All rights reserved.";
    }
}