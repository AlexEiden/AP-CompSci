public class Parallelogram extends Ngon {
	public static void draw(Coord one, Coord two, Coord three, Coord four){
		//build checker
		StdDraw.line(one.getX(), one.getY(), two.getX(), two.getY());		
		StdDraw.line(two.getX(), two.getY(), three.getX(), three.getY());
		StdDraw.line(three.getX(), three.getY(), four.getX(), four.getY());
		StdDraw.line(four.getX(), four.getY(), one.getX(), one.getY());

	}
}
