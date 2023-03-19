package MineField;

import mvc.*;
import javax.swing.*;
/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/18/2023 - Hazuki Sugahara: Edited file

 */

public class MineFieldPanel extends AppPanel {
    private JButton northWest;
    private JButton north;
    private JButton northEast;
    private JButton west;
    private JButton east;
    private JButton southWest;
    private JButton south;
    private JButton southEast;

    public MineFieldPanel(AppFactory factory) {
        super(factory);
        northWest = new JButton("NW");
        northWest.addActionListener(this);
        addControl(northWest);

        north = new JButton("N");
        north.addActionListener(this);
        addControl(north);

        northEast = new JButton("NW");
        northEast.addActionListener(this);
        addControl(northEast);

        west = new JButton("W");
        west.addActionListener(this);
        addControl(west);

        east = new JButton("E");
        east.addActionListener(this);
        addControl(east);

        southWest = new JButton("SW");
        southWest.addActionListener(this);
        addControl(southWest);

        south = new JButton("S");
        south.addActionListener(this);
        addControl(south);

        southEast = new JButton("SE");
        southEast.addActionListener(this);
        addControl(southEast);
    }

    public static void mian(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
