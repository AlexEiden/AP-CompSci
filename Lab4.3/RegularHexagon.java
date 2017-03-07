//Alex Eiden
//2017-03-07
//RegularHexagon
//Creates Regular Hexagon

public class RegularHexagon extends Ngon {
	public static void draw(double length) {
		//Could have inherited from Ngon class, but now either one will work
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
