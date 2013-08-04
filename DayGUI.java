/******************************************************************************
 * Program Name: Day GUI
 * Programmers Name: Lamburt Alcantara
 * Program Description: First GUI, displays two buttons
 ******************************************************************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.*;

public class DayGUI extends JFrame
{
    private JFrame mainFrame;
    private JButton cmdGood;
    private JButton cmdBad;
    
    public DayGUI()
    {
        mainFrame = new JFrame("Messages");
        
        // Create the button objects
        cmdGood = new JButton("Good");
        cmdBad = new JButton("Bad");
        
        // Get the content pane & specify layout manager
        Container c = mainFrame.getContentPane();
        c.setLayout(new FlowLayout());
        
        // Add the button to the ContentPane
        c.add(cmdGood);
        c.add(cmdBad);
        
        // Create accelerator keys
        cmdGood.setMnemonic('G');
        cmdBad.setMnemonic('B');
        
        mainFrame.setSize(300,100);
        
        // Define and register window event handler
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        // Create and register a single button event handler
        ButtonsHandler bhandler = new ButtonsHandler();  // Instantiate a handler
        cmdGood.addActionListener(bhandler);
        cmdBad.addActionListener(bhandler);
        
        mainFrame.show();
    }
    
    // Inner class for the button event handler
    class ButtonsHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == cmdGood)
                JOptionPane.showMessageDialog(null, "Today is a good day!",
                        "Event Handler Message", JOptionPane.INFORMATION_MESSAGE);
            else if (e.getSource() == cmdBad)
                JOptionPane.showMessageDialog(null, "I'm having a bad day today!",
                        "Event Handler Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String args[])
    {
        DayGUI app;
        app = new DayGUI();
    }
}