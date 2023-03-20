package MineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

/* Class "MineField" Datalog
3/16/2023 - Niko Jokhadze: Created file
3/16/2023 - Hazuki Sugahara: edit file
3/19/2023 - Hazuki Sugahara: added statement for the repaint method called
3/19/2023 - Owen Semersky: Minor edits to use findSurroundingMines.
 */

class Cell extends JLabel {
    MineField.Patch patch;
}

public class MineFieldView extends View{

    private Cell cells[][];
    MineField minefield;

    public MineFieldView(MineField m) {
        super(m);
        minefield = m;

        int dim = m.getDim();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col] = new Cell();
                cells[row][col].setText("?");
                cells[row][col].patch = m.getPatch(row, col);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
                if (cells[row][col].patch.occupied) {
                    cells[row][col].setBackground(Color.RED);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.white));
                    cells[row][col].patch.findSurroundingMines();
                    cells[row][col].setText("" + cells[row][col].patch.surroundingMines);
                }
                if (cells[row][col].patch.goal) {
                    cells[row][col].setBackground(Color.WHITE);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.green));
                }
                this.add(cells[row][col]);
            }
        }
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        MineField m = (MineField)model;
        int row = minefield.getLocationX();
        int col = minefield.getLocationY();
        cells[row][col].patch.findSurroundingMines();
        cells[row][col].setText("" + cells[row][col].patch.surroundingMines);
        cells[row][col].setBorder(BorderFactory.createLineBorder(Color.white));
    }
//    public void propertyChange(PropertyChangeEvent evt) {
//        String event = evt.getPropertyName();
//
//        if(!("New".equals(event)) || (!"Open".equals(event))) {
//            int row = minefield.getLocationX();
//            int col = minefield.getLocationY();
//            cells[row][col].setText("" + cells[row][col].patch.getSurroundingMines());
//            cells[row][col].setBorder(BorderFactory.createLineBorder(Color.white));
//        }
//    }

}
