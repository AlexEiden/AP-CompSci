import java.awt.Color;
public class ShapesTester {
	public static void main(String[] args){
		int length = 5;
		Turtle turtle = new Turtle(.5, .5, 0.0);
	    double angle = 360.0/length;
	    for (int t = 0; t < length; t++) {
	        turtle.turnLeft(angle);
	        turtle.goForward(.1);
	        turtle.show();
	        turtle.pause(1000);
	    } 
	}	
}	
