public class Ngon {
	public void draw(){}
	
	public int whichShape(int numOfSides) {
		switch(numOfSides) {
			case 3:
				return Triangle;
				break;
			case 4:
				return Parallelogram();
				break;
			case 6:
				return Hexagon();
				break;
		}
	}
}
