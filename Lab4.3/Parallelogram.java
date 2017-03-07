public class Parallelogram extends Ngon {
	public static void draw(Coord one, Coord two, Coord three, Coord four){
		//build checker
		double x1 = one.getX(), x2 = two.getX(), x3 = three.getX(), x4 = four.getX();
		double y1 = one.getY(), y2 = two.getY(), y3 = three.getY(), y4 = four.getY();
		StdDraw.line(x1, y1, x2, y2);		
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x4, y4);
		StdDraw.line(x4, y4, x1, y1);

	}
}
