package MineField;

import mvc.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/* Class "MineField" Datalog
3/16/2023 - Niko Jokhadze: Created file
3/19/2023 - Niko Jokhadze: Implemented all functions
3/19/2023 - Owen Semersky: Added getters for patches, dimensions, and surrounding mines.
                           These are used in the hint for MineFieldView.
3/19/2023 - Hazuki Sugahara: modified the swtich statment
 */

public class MineField extends Model {
    public static int minePercent = 5;
    private int height = 20; // 20 rows
    private int width = 20; // 20 columns
    private Patch[][] patches;
    private Point location;
    private final ArrayList<Point> path;

    public MineField() {
        patches = new Patch[width][height]; // makes an empty 20 x 20 2D array
        Random random = new Random();

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
        patches[width - 1][height - 1].mine = false; //guarentees that the goal patch won't be mined
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
        }

        if (x < 0 || x >= width || y < 0 || y >= height){
            throw new Exception("You have reached the edge of the field.");
            // this is the bounds check, as the user will not be allwoed to leave the field
        }

        if (patches[x][y].mine){
            throw new Exception("You have stepped on a mine.");
        }

        if (patches[x][y].goal){
            throw new Exception("You have reached the goal!");
        }

        location = new Point(x, y);
    }

    public class Patch {
        public boolean mine = false;//initial patch is not a mine, will be set randomly in Minefield class
        public int surroundingMines = 0;
        public boolean occupied = false; // this becomes true for one patch at a time, being the one that the player is on
        public boolean goal = false; // since we start away from the finish line, it will be false.
        // there will be only one goal patch at the bottom right
        public int getSurroundingMines() {
            return surroundingMines;
        }

    }
}
