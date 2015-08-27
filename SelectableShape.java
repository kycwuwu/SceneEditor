import java.awt.*;

/**
 * This class works to define commonalities between the HouseShape and CarShape classes, which both extend this
 * class and hence SceneShape
 * 
 * @author Cay Horstmann, edits made by Kylie Wu kcw2141
 */

public abstract class SelectableShape implements SceneShape, Cloneable
{
    private boolean selected;
    
    /**
	 * Sets the selected condition to the given boolean value
     * @param the desired boolean
	 */
    public void setSelected(boolean b)
    {
        selected = b;
    }
	    
    /**
     * Determines whether the shape is selected
     * 
     * @return boolean indicating if shape is selected
     */
    public boolean isSelected()
    {
        return selected;
    }
    
    /**
     * Draws the selected shape
     */
    public void drawSelection(Graphics2D g2)
    {
        //draws the shape repeatedly in a way to give it a bolded appearance
        translate(1, 1);
        draw(g2);
        translate(1, 1);
        draw(g2);
        translate(-2, -2);
    }
    
    /**
     * Clones the shape
     * 
     * @return a duplicate of the shape
     */
    protected SelectableShape clone() throws CloneNotSupportedException
    {
        return (SelectableShape) super.clone();
    }
}