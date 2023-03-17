package MineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

/* Class "MineField" Datalog

3/16/2023 - Niko Jokhadze: Created file
3/16/2023 - Hazuki Sugahara: edit file

 */
class Cell extends JLabel {
  Patch patch;
}

public class MineFieldView extends View{
  
  private Cell cells[][];
  
  public MineFieldView(mineField m) {
    super(m);
    
    int dim = m.getDim();
    cells = new Cell[dim][dim];
    setLayout(new GridLayout(dim, dim));
    for(int row = 0; row < dim; row++) {
      for (int col = 0; col < dim; col++) {
        cells[row][col] = new Cell();
        cells[row][col].setText("?");
        cells[row][col].patch = m.getPatch(row, col);
        cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
        if(cells[row][col].patch.occupied) {
          cells[row][col].setBackground(Color.RED);
          cells[row][col].setBorder(BorderFactory.createLineBorder(Color.white));
          cells[row][col].setText("" + cells[row][col].patch.numMinedNbrs);
        }
        if(cells[row][col].patch.goal) {
          cells[row][col].setBackground(Color.WHITE);
          cells[row][col].setBorder(BorderFactory.createLineBorder(Color.green));
        }
        this.add(cells[row][col]);
}
