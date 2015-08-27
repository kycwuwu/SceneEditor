import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Basic structure that the other shapes will follow.
 * @author Cay Horstmann, edits made by Kylie Wu kcw2141
 */

public interface SceneShape
{
	//sets the selected 
    void setSelected(boolean b);
    
    //determines whether the shape is selected
    boolean isSelected();
    
    //draws the shape so the user can see it
    void draw(Graphics2D g2);
    
    //draws selected version of shape
    void drawSelection(Graphics2D g2);
    
    //moves the shape by indicated coordinates
    void translate(int dx, int dy);
    
    //determines whether the shape contains given point
    boolean contains(Point2D aPoint);
	
	//returns width of the shape
	int getWidth();
	
	//returns height of the shape
	int getHeight();
}