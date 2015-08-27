import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * This program allows users to edit a scene that is made up of items.
 */
public class SceneEditor
{
    public static int FRAME_HEIGHT = 750;
	public static int FRAME_WIDTH = 750;
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final SceneComponent scene = new SceneComponent();
        
        JPanel buttons = new JPanel();
        
        JButton houseButton = new JButton("House");
        JButton carButton = new JButton("Car");
        JButton personButton = new JButton("Person");
        JButton removeButton = new JButton("Remove");
        
        buttons.add(houseButton);
        buttons.add(carButton);
        buttons.add(personButton);
        buttons.add(removeButton);
        
        Random r = new Random();
        
        ButtonAction houseAction = new ButtonAction(scene, new HouseShape(20, 20, 50), houseButton);
        ButtonAction carAction = new ButtonAction(scene, new CarShape(20, 20, 50), carButton);
        ButtonAction personAction = new ButtonAction(scene, personButton);
        ButtonAction removeAction = new ButtonAction(scene, removeButton);
               
        houseButton.addActionListener(houseAction);
        carButton.addActionListener(carAction);
		personButton.addActionListener(personAction);
        removeButton.addActionListener(removeAction);
        
        houseAction.setOpposite(removeAction);
        carAction.setOpposite(removeAction);
		personAction.setOpposite(removeAction);
        removeAction.setOpposite(houseAction, carAction, personAction);
        
        houseAction.setPartner(carAction, personAction);
        carAction.setPartner(houseAction, personAction);
        personAction.setPartner(carAction, houseAction);
        
        removeAction.setEnabled(false);
        removeButton.setEnabled(false);
        
        //set up the frame for the user to see
        frame.add(scene, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.NORTH);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}