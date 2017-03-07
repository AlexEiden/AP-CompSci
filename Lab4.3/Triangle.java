//Alex Eiden
//2017-03-07
//Triangle
//Creates a triangle

public class Triangle extends Ngon {
	public static void draw(Coord one, Coord two, Coord three){
		//build checker
		double x1 = one.getX(), x2 = two.getX(), x3 = three.getX(); //setting variables for ease of use
		double y1 = one.getY(), y2 = two.getY(), y3 = three.getY(); //setting variables for ease of use
		
		// It would be possible to create a tester here to make sure the shape drawn is a triangle
		/*if (x1 != x4 || x2 != x3 || y1 != y2 || y3 != y4) { //This does not apply for all cases,
															  //can be modified at a later date
		System.out.println("You done goofed");
		throw new IllegalArgumentException("Points are not connected");
		}*/

		StdDraw.line(x1, y1, x2, y2); //drawing the triangle
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);
	}
}
