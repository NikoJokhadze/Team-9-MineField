package MineField;

/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/17/2023 - Hazuki Sugahara: Edited file

 */

public class MineFieldFactory {
  
  public Model makeModel() { return new MineField(); }
  
  public View makeView(Model m) {
    return new MineFieldView((MineField)m);
  }
  
  public String[] getEditCommands() { return new String[] {""}; } //add commnads for minefiled
  
  public Command makeEditCommand(Model model, String type, Object source) {
    if(type == "North")
      return new ChangeCommand(model);
    else if //create new statements for each commands
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
