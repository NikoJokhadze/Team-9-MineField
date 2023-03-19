package MineField;

import mvc.*;

/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/17/2023 - Hazuki Sugahara: Edited file

 */

public class MineFieldFactory implements AppFactory {

    public Model makeModel() { return new MineField(); }

    public View makeView(Model m) {
        return new MineFieldView((MineField)m);
    }

    public String[] getEditCommands() { return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE"}; }

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
                "Northeast: Moves you to the upper left block"
        };
    }

    public String about() {
        return "Hazuki Sugahara, Owen Semersky, Niko Jokhadze" + "\n2023. All rights reserved.";
    }
}
