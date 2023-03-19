package MineField;
import mvc.*;
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
