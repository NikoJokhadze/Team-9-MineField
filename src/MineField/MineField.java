package MineField;

import mvc.*;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/* Class "MineField" Datalog
3/16/2023 - Niko Jokhadze: Created file.
3/19/2023 - Niko Jokhadze: Implemented all functions.
3/19/2023 - Owen Semersky: Added getters for patches, dimensions, and surrounding mines.
                           These are used in the hint for MineFieldView.
3/19/2023 - Hazuki Sugahara: modified switch statement.
3/19/2023 - Owen Semersky: added implementation for getSurroundingMines.
3/19/2023 - Owen Semersky: Changed getSurroundingMines to findSurroundingMines.
                           Now sets the variable only once.
3/19/2023 - Niko Jokhadze: Modified move to have app close once you step on a mine or reach the goal.
                           Added reset functionality
3/20/2023 - Niko Jokhadze: Added difficulty selector
                           Fixed ArrayIndexOutOfBounds error when reaching the bottom or right bounds
3/21/2023 - Owen Semersky: Small bug fix in findSurroundingMines
 */

public class MineField extends Model implements Serializable {
    public int minePercent;
    private int height = 20; // 20 rows
    private int width = 20; // 20 columns
    private int easyValue = 3;
    private int normalValue = 5;
    private int hardValue = 10;
    private Patch[][] patches;
    private Point location;
    private final ArrayList<Point> path;

    public MineField() {
        patches = new Patch[width][height]; // makes an empty 20 x 20 2D array
        Random random = new Random();
        difficultySelector();

        for (int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                patches[i][j] = new Patch();
                //builds the 2D array one patch at a time
                if(random.nextInt(100) < minePercent){
                    patches[i][j].mine = true;
                    //the random number picker for if a patch will be mined or not
                }
            }
        }
        //designate player location

        location = new Point(0, 0); // starting point
        path = new ArrayList<Point>();
        path.add(location);
        patches[width - 1][height - 1].goal = true; //sets the very end of the grid as the goal patch
        patches[0][0].mine = false; //guarantees that the starting patch won't be mined
        patches[width - 1][height - 1].mine = false; //guarantees that the goal patch won't be mined
    }

    public Patch[][] getPatches() {
        return patches;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLocationX() {
        return (int) location.getX();
    }

    public int getLocationY(){
        return (int) location.getY();
    }

    public ArrayList<Point> getPath() {
        return path;
    }

    public Patch getPatch(int row, int col) {
        return patches[row][col];
    }

    public int getDim() {
        return height;
        // dimensions will be a square, so height = width, simply return height.
    }

    public int difficultySelector(){
        JFrame frame = new JFrame("");
        Object[] options = {"Easy", "Normal", "Hard"};
        int option = JOptionPane.showOptionDialog(frame,
                "Please select your difficulty:",
                "Welcome to Minefield!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch (option) {
            case 0 :
                minePercent = easyValue;
                break;
            case 1 :
                minePercent = normalValue;
                break;
            case 2 :
                minePercent = hardValue;
                break;
            default:
                minePercent = 5;
                break;
        }

        return minePercent;
    }

    public void move(Heading heading) throws Exception {
        int x = getLocationX();
        int y = getLocationY();
        switch (heading) {
            case NORTH :
                x--;
                break;
            case NORTHEAST :
                x--;
                y++;
                break;
            case EAST :
                y++;
                break;
            case SOUTHEAST :
                x++;
                y++;
                break;
            case SOUTH :
                x++;
                break;
            case SOUTHWEST :
                x++;
                y--;
                break;
            case WEST :
                y--;
                break;
            case NORTHWEST :
                x--;
                y++;
                break;
            case RESET :
                x = 0;
                y = 0;
                break;
        }

        if (x < 0 || x >= width || y < 0 || y >= height){
            throw new Exception("You have reached the edge of the field.");
            // this is the bounds check, as the user will not be allowed to leave the field
        }

        if (patches[x][y].mine){
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame, "You have stepped on a mine!");
            JOptionPane.showMessageDialog(frame, "Game Over");
            System.exit(0);
        }

        if (patches[x][y].goal){
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame, "You have reached the goal!");
            JOptionPane.showMessageDialog(frame, "Thanks for playing!");
            System.exit(0);
        }

        location = new Point(x, y);
    }

    public class Patch implements Serializable{
        public boolean mine = false;//initial patch is not a mine, will be set randomly in Minefield class
        public int surroundingMines;
        public boolean occupied = false; // this becomes true for one patch at a time, being the one that the player is on
        public boolean goal = false; // since we start away from the finish line, it will be false.
        // there will be only one goal patch at the bottom right

        public void findSurroundingMines() {
            int mineCount = 0;
            // Current location.
            int x = getLocationX();
            int y = getLocationY();

            // Minefield patches.
            Patch[][] patches = getPatches();

            // Check North
            if((x - 1 >= 0) && (patches[x - 1][y].mine)) {
                mineCount++;
            }

            // Check Northeast
            if ((y + 1 < width) && (x - 1 >= 0) && (patches[x - 1][y + 1].mine)) {
                mineCount++;
            }

            // Check East
            if ((y + 1 < width) && (patches[x][y + 1].mine)) {
                mineCount++;
            }

            // Check Southeast
            if ((x + 1 < height) && (y + 1 < width) && (patches[x + 1][y + 1].mine)) {
                mineCount++;
            }

            // Check South
            if ((x + 1 < height) && (patches[x + 1][y].mine)) {
                mineCount++;
            }

            // Check Southwest
            if ((y - 1 >= 0) && (x + 1 < height) && (patches[x + 1][y - 1].mine)) {
                mineCount++;
            }

            // Check West
            if ((y - 1 >= 0) && (patches[x][y - 1].mine)) {
                mineCount++;
            }

            // Check Northwest
            if ((x - 1 >= 0) && (y - 1 >= 0) && (patches[x - 1][y - 1].mine)) {
                mineCount++;
            }

            // Return number of mines found around this location.
            surroundingMines = mineCount;
        }
    }
}
