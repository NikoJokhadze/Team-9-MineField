package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* Class "AppPanel" Datalog

3/10/2023 - Niko Jokhadze: Created file
                           Added class "ControlPanel"
3/12/2023 - Niko Jokhadze: Adjusted details as needed

 */

public class AppPanel extends JPanel implements ActionListener {
    private Model model;
    private ControlPanel controls;
    private View view;

    public AppPanel() {
        // create model, install controls & view
        model = new Model();
        view = new View(model);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        // create my frame with menus and display it
        SafeFrame frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Turtle Graphics");
        frame.setSize(500, 300);
        frame.setVisible(true);


        /*
        if we incorporate the subscribe and unsubscribe methods, we add something like this:
        view.setModel(model);
         */
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "North": {}

                case "Northeast": {}

                case "East": {}

                case "Southeast": {}

                case "South": {}

                case "Southwest": {}

                case "West": {}

                case "Northwest": {}


                case "Save": {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        model = (Model) is.readObject();
                        //view.setModel(model);
                        is.close();
                    }
                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = new Model();
                        //view.setModel(model);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform("Hazuki Sugahara, Owen Semersky, Niko Jokhadze" +
                                     "\n2023. All rights reserved.");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "North: Moves you one block up",
                            "Northeast: Moves you to the upper right block",
                            "East: Moves you one block right",
                            "Southeast: Moves you to the lower right block",
                            "South: Moves you one block down",
                            "Southwest: Moves you to the lower left block",
                            "West: Moves you one block left",
                            "Northeast: Moves you to the upper left block",
                    };
                    Utilities.inform(cmmds);
                    break;
                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex); // all error handling done here!
        }
    }


    class ControlPanel extends JPanel {
        public ControlPanel() {
            setLayout(new GridLayout(4, 2));
            JPanel p = new JPanel();
            Dimension buttonSize = new Dimension(50, 25);

            JButton north = new JButton("N");
            JButton northeast = new JButton("NE");
            JButton east = new JButton("E");
            JButton southeast = new JButton("SE");
            JButton south = new JButton("S");
            JButton southwest = new JButton("SW");
            JButton west = new JButton("W");
            JButton northwest = new JButton("NW");

            north.setPreferredSize(buttonSize);
            northeast.setPreferredSize(buttonSize);
            east.setPreferredSize(buttonSize);
            southeast.setPreferredSize(buttonSize);
            south.setPreferredSize(buttonSize);
            southwest.setPreferredSize(buttonSize);
            west.setPreferredSize(buttonSize);
            northwest.setPreferredSize(buttonSize);

            north.addActionListener(AppPanel.this);
            p.add(north);
            add(p);

            northeast.addActionListener(AppPanel.this);
            p.add(northeast);
            add(p);

            east.addActionListener(AppPanel.this);
            p.add(east);
            add(p);

            southeast.addActionListener(AppPanel.this);
            p.add(southeast);
            add(p);

            south.addActionListener(AppPanel.this);
            p.add(south);
            add(p);

            southwest.addActionListener(AppPanel.this);
            p.add(southwest);
            add(p);

            west.addActionListener(AppPanel.this);
            p.add(west);
            add(p);

            northwest.addActionListener(AppPanel.this);
            p.add(northwest);
            add(p);
        }
    }

    // and away we go ...
    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}
