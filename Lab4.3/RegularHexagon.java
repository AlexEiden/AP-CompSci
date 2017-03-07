public class RegularHexagon {
	public static void draw(Coord one, double length) {
		Turtle turtle = new Turtle(.75, .75, 0.0);
	    double angle = 120;
	    for (int i = 0; i < 6; i++) {
	        turtle.turnLeft(angle);
	        turtle.goForward(length);
	        turtle.show();
	    } 
	}
}
