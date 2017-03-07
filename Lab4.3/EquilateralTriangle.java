//Alex Eiden
//2017-03-07
//EquilateralTriangle
//Creates an equilateral triangle

public class EquilateralTriangle extends Triangle {
	public static void draw(double length) {
		Turtle turtle = new Turtle(.15, .75, 0.0); //using Tutle out of laziness
													//still don't want to calculate coods lol
	    double angle = 120;
	    for (int i = 0; i < 6; i++) {
	        turtle.turnLeft(angle);
	        turtle.goForward(length);
	        turtle.show();
	    } 
	}
}
