/* AP Computer Science A
 * Demonstrative Code for how the classes should 
 * interact and run.
 * 
 * This shows a multi-colored octagon.
 * 
 * 
 */
import java.awt.Color;
public class ShapesTester {
	public static void main(String[] args){
		Color[] colors = {Color.PINK, Color.BLUE, Color.GREEN,
	        		 	  Color.RED, Color.CYAN, Color.MAGENTA,
	        		 	  Color.GRAY, Color.ORANGE};
		Turtle turtle = new Turtle(.5, .5, 0.0);
	    double angle = 360.0/colors.length;
	    for (int t = 0; t < colors.length; t++) {
	    	turtle.setPenColor(colors[(int) (Math.random() * colors.length)]);
	    	turtle.setPenRadius(Math.random()/100);
	        turtle.turnLeft(angle);
	        turtle.goForward(.1);
	        turtle.show();
	        turtle.pause(1000);
	    } 
	}	
}	
