public class RightTriangle extends Triangle {
	public static void draw(Coord one, double lengthX, double lengthY) {
	//using StdDraw's line method
			StdDraw.line(one.getX(), one.getY(), (one.getX()+lengthX), one.getY());		
			StdDraw.line((one.getX()+lengthX), one.getY(), one.getX(), (one.getY()+lengthY));
			StdDraw.line(one.getX(), one.getY(), one.getX(), (one.getY())+lengthY);


	//using Turtle (these two shapes overlap)
		//ended up not using turtle for sake of elegance. Would need to calculate angles and the hypotenuse	
	}

/*	public double Hypotenuse(Coord one, double lengthX, double lengthY) {
    	return (Math.sqrt(Math.pow((one.getX()-(one.getX()+lengthX)), 2) + Math.pow((one.getY()-(one.getY()+lengthY)), 2)));
	}
*/ //ignoring for now
}
