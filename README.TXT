AUTHOR: Kylie Wu
CORE CONCEPTS: javax.swing/GUI, Action pattern, interfaces, abstract class

The program allows the user to add one of three shapes: House, Car, or Person. They can only add a total of 10 shapes to the frame. When a shape is clicked on, it is bolded to indicate its selected state. Selected items can be moved around the frame (maintaining the same distance in respect to each other) or removed.

CLASSES:

SceneEditor - Contains the main method, which sets up all of the GUI present at the beginning of program execution. Also attaches ButtonActions to the buttons in the UI, and assigns opposite actions.

ButtonAction - Extends AbstractAction. Is able to set the opposite ButtonAction(s) as well as the partner ButtonAction(s) that are enabled at the same time. It also defines the action performed based on the text of the Button.

SceneShape - Interface that defines properties and methods that all shapes within the scene of this program should have.

SelectableShape - Abstract class that implements SceneShape and Cloneable. It defines selection status for the shape, creates clones, as well as draws the bolded outline for a selected shape.

CarShape, HouseShape, and PersonShape - Classes that extend SelectableShape. Each define important coordinates for integral points used to draw the shape. Each also contain methods that determine how the shape should be drawn, how it is translated, and whether the mouse pointer is contained within the shape.

SceneComponent - Displays a scene composed of various shapes. It handles addition and removal of shapes from the scene, as well as repainting and moving (due to drag-and-drop) of shapes.