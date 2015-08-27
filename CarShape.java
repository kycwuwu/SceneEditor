import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * The CarShape class creates the car shape for the user to see.
 * (Some alteration ideas taken from the Magic Number Cheatsheet)
 * 
 * @author Cay Horstmann - edits made by Kylie Wu kcw2141
 */
public class CarShape extends SelectableShape
{
    private int x;
    private int y;
    private int width;
    final private int UNIT;
    final private int WINDOW_WIDTH;
    final private int ROOF_WIDTH;
    final private int BODY_WIDTH;
    private int leftWindowLeft;
    private int roofLeft;
    private int roofRight;
    private int rightWindowRight;
    private int bodyTop;
    private int tireTop;
    
    /**
     * Creates a CarShape with given values
     * @param original x coordinate
     * @param original y coordinate
     * @param CarShape width
     */
    public CarShape(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        UNIT = width / 6;
        
        //setting constants for the dimensions of things
        WINDOW_WIDTH = UNIT;
        ROOF_WIDTH = 2 * UNIT;
        BODY_WIDTH = 6 * UNIT;
        
        //setting coordinates of certain parts
        leftWindowLeft = WINDOW_WIDTH;
        roofLeft = leftWindowLeft + WINDOW_WIDTH;
        roofRight = roofLeft + ROOF_WIDTH;
        rightWindowRight = roofRight + WINDOW_WIDTH;
        bodyTop = UNIT;
        tireTop = bodyTop + UNIT;
    }
    
    /**
     * Accessor to x position
     * 
     * @return x-coordinate of shape
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Moves the CarShape in the indicated direction
     * @param number of units to move in x-direction
     * @param number of units to move in y-direction
     */
    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
    
    /**
     * Draws the car shape for the user to see
     * 
     * @param Graphics2D to use
     */
    public void draw(Graphics2D g2)
    {
        //drawing chassis
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + bodyTop, BODY_WIDTH, UNIT);
        //drawing tires
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + leftWindowLeft, y + tireTop , UNIT,
                UNIT);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + roofRight, y + tireTop, UNIT, UNIT);
                
        //drawing roof and windows
        Point2D.Double r1 = new Point2D.Double(x + leftWindowLeft, y + bodyTop);
        Point2D.Double r2 = new Point2D.Double(x + roofLeft, y);
        Point2D.Double r3 = new Point2D.Double(x + roofRight, y);
        Point2D.Double r4 = new Point2D.Double(x + rightWindowRight, y + bodyTop);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double rooftop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
        
        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(rooftop);
        g2.draw(rearWindshield);
    }
    
    /**
     * Checks to see if point is included in the shape
     * 
     * @param point to check
     */
    public boolean contains(Point2D p)
    {
        return x <= p.getX() && p.getX() <= x + width && y <= p.getY() && p.getY() <= y + 3 * UNIT;
    }

	/**
	 * Returns the width of the car shape
	 * 
	 * @return int representing the width of the shape
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Returns the height of the car shape
	 * 
	 * @return int representing shape height
	 */
	public int getHeight()
	{
		return 3 * UNIT;
	}
}
