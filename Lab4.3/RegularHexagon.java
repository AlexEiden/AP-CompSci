public class RegularHexagon {
	public static void draw(double length) {
		Turtle turtle = new Turtle(.75, .75, 0.0); //using Tutle out of laziness
													//don't want to calculate coords :(
	    double angle = 60;
	    for (int i = 0; i < 6; i++) {
	        turtle.turnLeft(angle);
	        turtle.goForward(length);
	        turtle.show();
	    } 
	}
}
