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
        MineField m = (MineField) model;
        m.addPropertyChangeListener(this);
        setLayout(new GridLayout(4, 2));
        JPanel p = new JPanel();
        Dimension buttonSize = new Dimension(50, 25);
        
        northWest = new JButton("NW");
        northWest.addActionListener(this);
        p.add(northWest);
        add(p);

        north = new JButton("N");
        north.addActionListener(this);
        p.add(north);
        add(p);

        northEast = new JButton("NW");
        northEast.addActionListener(this);
        p.add(northEast);
        add(p);

        west = new JButton("W");
        west.addActionListener(this);
        p.add(west);
        add(p);

        east = new JButton("E");
        east.addActionListener(this);
        p.add(east);
        add(p);

        southWest = new JButton("SW");
        southWest.addActionListener(this);
        p.add(southWest);
        add(p);

        south = new JButton("S");
        south.addActionListener(this);
        p.add(south);
        add(p);

        southEast = new JButton("SE");
        southEast.addActionListener(this);
        p.add(southEast);
        add(p);

        addControl(p);
    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
