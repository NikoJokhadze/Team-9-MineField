package mvc;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/* Class "View" Datalog
3/10/2023 - Niko Jokhadze: Created file
3/11/2023 - Hazuki Sugahara: edit file
3/14/2023 - Hazuki Sugahara: modified file
 */
public class View extends JPanel implements PropertyChangeListener {
    Model model;

    public View(Model model){
        this.model = model;
        setSize(500, 300);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.WHITE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){

        String event = evt.getPropertyName();

        if("New".equals(event) || "Open".equals(event)){
            this.model = (Model)evt.getNewValue();
            model.initSupport();
        }
    }
}
