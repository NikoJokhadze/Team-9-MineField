package MineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;

/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/18/2023 - Hazuki Sugahara: Edited file
3/19/2023 - Owen Semersky: Edited file
3/19/2023 - Hazuki Sugahara: add few statement to set the buttons

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
        
        JPanel p = new JPanel();
        Dimension buttonSize = new Dimension(50, 25);
        p.setLayout(new GridLayout(4, 2));

        northWest = new JButton("NW");
        northWest.addActionListener(this);
        northWest.setPreferredSize(buttonSize);
        p.add(northWest);
        add(p);

        north = new JButton("N");
        north.addActionListener(this);
        north.setPreferredSize(buttonSize);
        p.add(north);
        add(p);

        northEast = new JButton("NE");
        northEast.addActionListener(this);
        northEast.setPreferredSize(buttonSize);
        p.add(northEast);
        add(p);

        west = new JButton("W");
        west.addActionListener(this);
        west.setPreferredSize(buttonSize);
        p.add(west);
        add(p);

        east = new JButton("E");
        east.addActionListener(this);
        east.setPreferredSize(buttonSize);
        p.add(east);
        add(p);

        southWest = new JButton("SW");
        southWest.addActionListener(this);
        southWest.setPreferredSize(buttonSize);
        p.add(southWest);
        add(p);

        south = new JButton("S");
        south.addActionListener(this);
        south.setPreferredSize(buttonSize);
        p.add(south);
        add(p);

        southEast = new JButton("SE");
        southEast.addActionListener(this);
        southEast.setPreferredSize(buttonSize);
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
