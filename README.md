# Team-9-MineField
CS 151 (Object Oriented Design) Team 9's project of the assignment "MineField Customization of the MVC Framework"

Project Description: Implementing our own version of a customizable MVC framework, and using that MVC to make a functional MineField game. The objective of the MineField game is to be able to go from the upper-left corner of a grid to the bottom-right corner, moving one square at a time in any of the 8 directions around you. A percentage of the squares on the board are mines. Each square you step on indicates how many of the squares around you are rigged with a mine. Using logic, you must reach the goal without stepping on a mine. Stepping on a mine will end the game. The goal is to make it to the end without stepping on any mines.

Team 9 Group Members: Hazuki Sugahara, Owen Semersky,  Niko Jokhadze

Class Descriptions:


MVC:

Command: Allows commands to be represented as objects, these command objects can execute themselves using the execute method.

AppFactory: Provides an interface for an mvcApp. An mvcApp must have a model, view, title, and help, edit, and about menus.

AppPanel: An extension of the JPanel. Contains views for the user interface, controls, and the menu bar. Also serves as a PropertyChangeListener and ActionListener for the controls of the mvcApp.

Model: An extension of the given Bean class. The AppPanel contains a an instantiation of the Model class. Deals with unsaved changes and the file name of the model.

View: The individual views contained within the AppPanel. We would usually expect one view to contain the controls and one view to contain the canvas or other contents.

SafeFrame and Utilities: Given classes that contain useful utility methods.


MineField:

MineField: The model for our MineField. Contains the patch class, which is our implementation of the individual "squares". Handles the movement of the player, changing the x and y coordinates depending on the selected heading. Also handles the randomizing of the mines.

Heading: Contains the available headings or directions that the user can move inside of the MineField. Includes all eight compass directions.

MineFieldFactory: Makes a new MineField model or MineFieldView. Also contains Mine Field title, as well as the help and about menus.

MineFieldMoveCommand: The only command available for the MineField is moving one patch or tile. This creates this movement as a Command object.

MineFieldPanel: The JPanel for the MineField. Contains the controls as buttons and the MineField itself. Contains the main method used to run the program.

MineFieldShape: This class is meant to be the shape for the MineField, however, this is already handles in MineFieldView.

MineFieldView: Contains the 2D array that serves as the MineField. The 2D array contains patches, which are the tiles that can either be safe or mined.

Patch: A patch is a single tile or cell in the MineField. A patch has a boolean that determines whether it is a mine, which is chosen with RNG. The patch also contains a value that represents the number of mines that are one movement away from it (In a 3x3 square). It also has booleans that determine whether it is occupied or if it is the goal.
