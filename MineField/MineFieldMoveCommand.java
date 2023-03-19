package MineField;

import mvc.*;
/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/17/2023 - Hazuki Sugahara: Edited file

 */

public class MineFieldMoveCommand extends Command{
  Heading heading;
  
  public MineFieldMoveCommand(Model model) {
    super(model);
  }
  
  public void execute() {
    MineField mineField= (MineField)model;
    
  }
}
