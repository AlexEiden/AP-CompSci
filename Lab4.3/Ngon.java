public class Ngon extends Shape {
	public void draw(){}
	
	public double getAngle() {
		double angle = (double) Math.toDegrees(Math.atan2(target.y - y, target.x - x));
	
    	if(angle < 0){
			 angle += 360;
    	}
   		 return angle;
	}

}
