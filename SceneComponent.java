import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
 * This component shows a scene composed of shapes.
 */
public class SceneComponent extends JComponent
{
    private ArrayList<SceneShape> shapes;
    private Point mousePoint;
    
    /**
     * Creates the SceneComponent
     */
    public SceneComponent()
    {
        shapes = new ArrayList<SceneShape>();
    
        //define what happens when mouse is clicked
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent event)
            {
                mousePoint = event.getPoint();
                for (SceneShape s : shapes)
                {
                    //if shape has the clicked point, switch the selection field to the opposite value
                    if (s.contains(mousePoint))
                    {
                        s.setSelected(!s.isSelected());
                    }
                }
                repaint();
            }
        });
    
        //define what occurs when the mouse is dragged
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent event)
            {
                Point lastMousePoint = mousePoint;
                mousePoint = event.getPoint();
                for (SceneShape s : shapes)
                {
                    if (s.isSelected())
                    {
                        double dx = mousePoint.getX() - lastMousePoint.getX();
                        double dy = mousePoint.getY() - lastMousePoint.getY();
                        s.translate((int) dx, (int) dy);
                    }
                }
                repaint();
            }
        });
    }
    
    /**
      * Adds a shape to the scene.
      * @param s the shape to add
      */
    public void add(SceneShape s)
    {
        shapes.add(s);
        repaint();
    }
    
    /**
     * Removes all of the selected shapes from the scene
     */
    public void removeSelected()
    {
        for (int i = shapes.size() - 1; i >= 0; i--)
        {
            SceneShape s = shapes.get(i);
            if (s.isSelected())
            {
                shapes.remove(i);
            }
        }
        repaint();
   }
   
   /**
    * Paints shapes
    */
   public void paintComponent(Graphics g)
   {
       Graphics2D g2 = (Graphics2D) g;
       for (SceneShape s : shapes)
       {
           s.draw(g2);
           if (s.isSelected())
           {
               s.drawSelection(g2);
           }
       }
    }
    
   /**
    * Returns size of shapes ArrayList
    * 
    * @return the number of shapes in the ArrayList
    */
   public int getNumShapes()
   {
       return shapes.size();
   }
   
   /**
    * Returns the collection of shapes
    * 
    * @return the ArrayList of shapes
    */
   public ArrayList<SceneShape> getShapes()
   {
       return shapes;
   }
}

