import java.awt.*;
import java.awt.geom.*;

/**
 * Creates a house shape.
 * 
 * @author Cay Horstmann, edits made by Kylie Wu kcw2141
 */
public class HouseShape extends SelectableShape
{
    private int x;
    private int y;
    private int width;
    final private int UNIT;
    private int baseTop;
    private int roofTopX;
    private int roofRight;
    
    /**
     * Makes the house shape
     * @param x is the left of the bounding rectangle of the house shape
     * @param y is the top of the bounding rectangle
     * @param width is the width of the bounding rectangle
     */
    public HouseShape(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        UNIT = width / 2;
        baseTop = 2 * UNIT;
        roofTopX = UNIT;
        roofRight = 2 * UNIT;
    }
    
    /**
     * Draws the house shape
     * 
     * @param Graphics2D to utilize
     */
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double base = new Rectangle2D.Double(x, y + baseTop, width, width);
        
        Point2D.Double r1 = new Point2D.Double(x, y + baseTop);
        Point2D.Double r2 = new Point2D.Double(x + roofTopX, y);
        Point2D.Double r3 = new Point2D.Double(x + roofRight, y + baseTop);
        Line2D.Double l1 = new Line2D.Double(r1, r2);
        Line2D.Double l2 = new Line2D.Double(r2, r3);
        
        g2.draw(base);
        g2.draw(l1);
        g2.draw(l2);
    }
    
    /**
     * Checks if the shape contains the given point
     * 
     * @param point to be checked
     */
    public boolean contains(Point2D p)
    {
        return x <= p.getX() && p.getX() <= x + width && y <= p.getY() && p.getY() <= y + 2 * width;
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
     * Returns width of the house shape
     * 
     * @return int representing shape width
     */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Returns height of the house shape
	 * 
	 * @return int representing height of shape
	 */
	public int getHeight()
	{
		return 2 * UNIT;
	}
}