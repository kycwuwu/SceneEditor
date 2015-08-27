import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
 * This class helps change button abilities depending on the number of shapes on the scene.
 * 
 * @author Kylie Wu kcw2141, code adapted from Cay Horstmann
 */
public class ButtonAction extends AbstractAction
{
    private SceneComponent theScene;
    private SelectableShape theShape;
    private JButton theButton;
    private ButtonAction oppositeAction1;
    private ButtonAction oppositeAction2;
    private ButtonAction oppositeAction3;
    private ButtonAction partnerAction1;
    private ButtonAction partnerAction2;
    public final int MAX_OBJECTS = 10;
	private Random r;
    
    /**
     * Constructs Action appropriate for the Car and House buttons
     * 
     * @param SceneComponent to be altered
     * @param the SelectableShape that will be added
     * @param JButton to be affected
     */
    public ButtonAction(SceneComponent s, SelectableShape sh, JButton b)
    {
        theScene = s;
        theShape = sh;
        theButton = b;
        oppositeAction1 = null;
        oppositeAction2 = null;
        oppositeAction3 = null;
    }
    
    /**
     * Constructs Action for Remove and Person buttons
     * 
     * @param SceneComponent to be altered
     * @param JButton that will be affected
     */
    public ButtonAction(SceneComponent s, JButton b)
    {
        theScene = s;
        theButton = b;
        oppositeAction1 = null;
        oppositeAction2 = null;
        oppositeAction3 = null;
		r = new Random();
    }
    
    /**
     * Sets the opposite action
     * @param the action to be enabled after this certain action is performed
     */
    public void setOpposite(ButtonAction a)
    {
        oppositeAction1 = a;
    }
    
    /**
     * Sets the opposite action
     * @param the actions to be enabled after this certain action is performed
     */
    public void setOpposite(ButtonAction a, ButtonAction b, ButtonAction c)
    {
        oppositeAction1 = a;
        oppositeAction2 = b;
        oppositeAction3 = c;
    }
    
    /**
     * Sets the partner actions that are active at the same time
     * @param the actions to be enabled and disabled with this action
     */
    public void setPartner(ButtonAction a, ButtonAction b)
    {
        partnerAction1 = a;
        partnerAction2 = b;
    }
    
    /**
     * Returns the button of an action
     * 
     * @return JButton associated with this action
     */
    public JButton getButton()
    {
        return theButton;
    }
    
    /**
     * Performs action based on conditions
     */
    public void actionPerformed(ActionEvent event)
    {
		Random r = new Random();
        if (theShape != null)
        {
            try
            {
				theScene.add(theShape.clone());
            }
            catch (CloneNotSupportedException e)
            {
                System.out.println("Not cloneable.");
            }
        }
        else
        {
			if (theButton.getText().equals("Person"))
			{	
				SelectableShape pShape = new PersonShape(50);
				boolean overlap = false;
				//checks all the shapes for overlap
				for (SceneShape s : theScene.getShapes())
				{
					for (int x = 0; x < s.getWidth(); x++)
					{	
						for (int y = 0; y < s.getHeight(); y++)
						{
							Point p = new Point(x, y);
							if (pShape.contains(p))
							{
								overlap = true;
							}
						}
					}
				}
				if (overlap == false)
				{
					theScene.add(pShape);
				}
			}
            else
			{
				theScene.removeSelected();
			}
        }
        
        int numShapes = theScene.getNumShapes();
        
        //adjusting enabled/disabled button status
        if ((theButton.getText().equals("Car") || theButton.getText().equals("House") ||
				theButton.getText().equals("Person"))
                && oppositeAction1 != null && numShapes > 0)
        {
            oppositeAction1.setEnabled(true);
            oppositeAction1.getButton().setEnabled(true);
            if (numShapes >= MAX_OBJECTS)
            {
                setEnabled(false);
                theButton.setEnabled(false);
                partnerAction1.setEnabled(false);
                partnerAction1.getButton().setEnabled(false);
				partnerAction2.setEnabled(false);
                partnerAction2.getButton().setEnabled(false);
            }
        }
        else if (oppositeAction1 != null && oppositeAction2 != null && oppositeAction3 != null &&
				 numShapes < MAX_OBJECTS)
        {
            oppositeAction1.setEnabled(true);
            oppositeAction1.getButton().setEnabled(true);
            oppositeAction2.setEnabled(true);
            oppositeAction2.getButton().setEnabled(true);
            oppositeAction3.setEnabled(true);
            oppositeAction3.getButton().setEnabled(true);

            if (numShapes == 0)
            {
                setEnabled(false);
                theButton.setEnabled(false);
            }
        }
    }
}