public class Ngon extends Shape {
	
	public void draw(){}

	public static void draw(Coord coord1, double numOfSides, double length){

		Turtle turtle = new Turtle(coord1.getX(), coord1.getY(), 0.0);
		double angle = 360.0/numOfSides;
		for (int t = 0; t < numOfSides; t++){
			turtle.turnLeft(angle);
			turtle.goForward(length);
			turtle.show();
		}
	}

	/* public double getAngle(double x, double y) {
	   double angle = (double) Math.toDegrees(Math.atan2(target.y - y, target.x - x));

	   if(angle < 0){
	   angle += 360;
	   }
	   return angle;
	   } */ 

	//Now obsolete as I am ignoring the Tutle class and drawing straight from StdDraw

}
