package MineField;
import mvc.*;

/* Class "MineField" Datalog
3/16/2023 - Niko Jokhadze: Created file
3/17/2023 - Hazuki Sugahara: Edited file
3/19/2023 - Owen Semersky: Added try/catch for execute
 */

public class MineFieldMoveCommand extends Command{
    Heading heading;

    public MineFieldMoveCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() {
        MineField m = (MineField)model;
        try {
            m.move(heading);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
