// Assignment #: 7
//         Name: Mguel Zavala
//    StudentID: 1204402766
//      Lecture: MWF 1030AM
//  Description: This is the GUI of the box program

//import nesessary libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//start of the the wholepanel class
public class WholePanel extends JPanel
{
	
	//instantiate the variables
   private Color currentColor;
   private int currentWidth, currentHeight;
   private CanvasPanel canvas;
   private JPanel menuPanel;
   private JCheckBox fillCheck;
   private JRadioButton white,red,blue,green,orange;
   private int x1, y1;
   private ButtonGroup group;

   public WholePanel()
   {
     
     
     //white is the default color
     currentColor = Color.WHITE;
     group = new ButtonGroup();
     menuPanel = new JPanel();
     
     //default x-y coordinate, width, and height of a rectangle
     currentWidth = currentHeight = 100;
     x1 = 100; y1 = 100;
     
     //setting the layout of the check box and radio buttons
     menuPanel.setLayout(new GridLayout(1,6));
     
     //initializing the components
     fillCheck = new JCheckBox("Filled");
     white = new JRadioButton ("White");
     red = new JRadioButton ("Red");
     blue = new JRadioButton ("Blue");
     green = new JRadioButton ("Green");
     orange = new JRadioButton ("Orange");
     
     //Initialize listeners
     ColorListener colorListener = new ColorListener();
     FillListener fill = new FillListener();
     
     //add listeners to the components
     white.addActionListener(colorListener);
     red.addActionListener(colorListener);
     blue.addActionListener(colorListener);
     green.addActionListener(colorListener);
     orange.addActionListener(colorListener);
     fillCheck.addItemListener(fill);
     
     
     //add the components to the JPanel
     menuPanel = new JPanel();
     group.add(white);
     group.add(red);
     group.add(blue);
     group.add(green);
     group.add(orange);
     menuPanel.add(fillCheck);
     menuPanel.add(white);
     menuPanel.add(red);
     menuPanel.add(blue);
     menuPanel.add(green);
     menuPanel.add(orange);
           

     canvas = new CanvasPanel();

     JSplitPane sPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuPanel, canvas);

     setLayout(new BorderLayout());
     add(sPane, BorderLayout.CENTER);


    

    }

private class ColorListener implements ActionListener
  {
    @Override
    public void actionPerformed (ActionEvent event)
    {
    
     Object color = event.getSource();
     
     if(color == white)
     {
         currentColor = Color.white;
     
     }
     
     if(color == red)
     {  
         currentColor = Color.red;
       
     }
         
     else if (color == blue)
     {
         currentColor = Color.blue;
     
     }
     
     
     else if (color == green)
     {
         currentColor= Color.green;
     
     }
     
     else if(color == orange)
     {
     
         currentColor = Color.orange;
     
     }
     
     repaint();
     
    }
            



}

private class FillListener implements ItemListener
{

    
    public void itemStateChanged(ItemEvent event)
    {
        
      repaint();
        
    
    }


}


 //CanvasPanel is the panel where pressed keys will be drawn
 private class CanvasPanel extends JPanel
  {
     //Constructor to initialize the canvas panel
     public CanvasPanel( )
      {
        // make this canvas panel listen to keys
        addKeyListener (new DirectionListener());
        // make this canvas panel listen to mouse
        addMouseListener(new PointListener());
        addMouseMotionListener(new PointListener());

        setBackground(Color.BLACK);

        //This method needs to be called for this panel to listen to keys
        //When panel listens to other things, and go back to listen
        //to keys, this method needs to be called again.
        requestFocus();

      }


     //this method draws all characters pressed by a user so far
     @Override
     public void paintComponent(Graphics page)
      {
       super.paintComponent(page);

       //set color, then draw a rectangle
       page.setColor(currentColor);
       
       if(fillCheck.isSelected())
        {
            
           page.fillRect(x1, y1, currentWidth, currentHeight);
        }
       
       else 
        {
            page.drawRect(x1, y1, currentWidth, currentHeight);
        
        }
      }

     /** This method is overridden to enable keyboard focus */
     @Override
     public boolean isFocusable()
      {
        return true;
      }

     // listener class to listen to keyboard keys
     private class DirectionListener implements KeyListener
       {
         @Override
      public void keyReleased(KeyEvent e) {}

         @Override
      public void keyTyped(KeyEvent e) {}

      // in case that a key is pressed, the following will be executed.
         @Override
      public void keyPressed(KeyEvent e)
        {
            
        
         switch(e.getKeyCode())
         {
             case KeyEvent.VK_UP:
                 y1-=5;
                 break;
             case KeyEvent.VK_DOWN:
                 y1+=5;
                 break;
             case KeyEvent.VK_RIGHT:
                 x1+=5;
                 break;
             case KeyEvent.VK_LEFT:
                 x1-=5;
                 break;
         
         }
         
         repaint();
         
        }
       } // end of DirectionListener


    // listener class that listens to the mouse
    public class PointListener implements MouseListener, MouseMotionListener
         {
         //in case that a user presses using a mouse,
         //record the point where it was pressed.
        @Override
         public void mousePressed (MouseEvent event)
          {
            canvas.requestFocus();
          }

        @Override
         public void mouseClicked (MouseEvent event) {}
        @Override
         public void mouseReleased (MouseEvent event) {}
        @Override
         public void mouseEntered (MouseEvent event) {}
        @Override
         public void mouseExited (MouseEvent event) {}
        @Override
         public void mouseMoved(MouseEvent event) {}
        @Override
         public void mouseDragged(MouseEvent event)
          {
              int x  = event.getX();
              int y = event.getY();
           
           //left
           if( x>=95  && x<=105  && y >95 && y<205 )
           {
               x1-=5;
               currentWidth+=5;
           repaint();
           }
           
           //top
           if( x>=95  && x<=205  && y >95 && y<105 )
           {
               y1-=5;
               currentHeight-=5;
           repaint();
           }
           
           //right
           if( x>=195  && x<=205  && y >95 && y<205 )
           {
               x1+=5;
               currentWidth+=5;
           repaint();
           }
           
           //bottom
           if( x>=95  && x<=205  && y >195 && y<205 )
           {
               x1+=5;
               currentHeight+=5;
           repaint();
           }
          }

    } // end of PointListener

  } // end of Canvas Panel Class

} // end of Whole Panel Class