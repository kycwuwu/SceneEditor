import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Creates a person shape...or a stick man
 */
public class PersonShape extends SelectableShape
{
    private int x;
    private int y;
    private int width;
    final private int UNIT;
    private int neckTop;
    private int armHeight;
    private int legTop;
    private int theMiddle;
    private int footBottom;
	private Random r = new Random();
    
    /**
     * Generates the person shape
     */
    public PersonShape(int width)
    {
        this.x = r.nextInt(650);
        this.y = r.nextInt(600);
        this.width = width;
        UNIT = width / 2;
        neckTop = 2 * UNIT;
        armHeight = 3 * UNIT;
        legTop = 5 * UNIT;
        theMiddle = UNIT;
        footBottom = 8 * UNIT;
    } 

    /**
     * Draws the person shape on the screen
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double head = new Ellipse2D.Double(x, y, width, width);
        
        Point2D.Double p1 = new Point2D.Double(x + theMiddle, y + neckTop);
        Point2D.Double p2 = new Point2D.Double(x + theMiddle, y + legTop);
        Point2D.Double p3 = new Point2D.Double(x, y + footBottom);
        Point2D.Double p4 = new Point2D.Double(x + width, y + footBottom);
        Point2D.Double p5 = new Point2D.Double(x, y + armHeight);
        Point2D.Double p6 = new Point2D.Double(x + width, y + armHeight);
        
        Line2D.Double spine = new Line2D.Double(p1, p2);
        Line2D.Double lLeg = new Line2D.Double(p2, p3);
        Line2D.Double rLeg = new Line2D.Double(p2, p4);
        Line2D.Double arms = new Line2D.Double(p5, p6);
        
        g2.draw(head);
        g2.draw(spine);
        g2.draw(lLeg);
        g2.draw(rLeg);
        g2.draw(arms);
    }
    
     /**
     * Checks if the shape contains the given point
     * 
     * @param point to be checked
     */
    public boolean contains(Point2D p)
    {
        return x <= p.getX() && p.getX() <= x + width && y <= p.getY() && p.getY() <= y + 4 * width;
    }
    
    /**
     * Moves the shape by the given number of coordinates
     * 
     * @param dx is the change in x
     * @param dy is the change in y
     */
    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    /**
     * Returns the width of the person
     * 
     * @return int representation of width
     */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Returns the height of the person
	 * 
	 * @return int representation of height
	 */
	public int getHeight()
	{
		return footBottom;
	}
}