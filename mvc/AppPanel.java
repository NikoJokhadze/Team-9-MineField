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

 */

public class AppPanel extends JPanel implements ActionListener {
    class ControlPanel extends JPanel {
    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}