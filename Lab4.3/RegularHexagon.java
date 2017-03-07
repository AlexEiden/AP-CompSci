public class RegularHexagon {
	public static void draw(double length) {
		Turtle turtle = new Turtle(.75, .75, 0.0);
	    double angle = 60;
	    for (int i = 0; i < 6; i++) {
	        turtle.turnLeft(angle);
	        turtle.goForward(length);
	        turtle.show();
	    } 
	}
}
