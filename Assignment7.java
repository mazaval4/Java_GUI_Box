// Assignment #: 7
//         Name: Miguel Zavala
//    StudentID: 1204402766
//      Lecture: MWF 1030AM
//  Description: this program lets the user resize and change the color of a rectangle.
//  The user can either have the box empty or have it filled white,red,blue,green or orange.




import javax.swing.*;

public class Assignment7 extends JApplet
{


public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}




