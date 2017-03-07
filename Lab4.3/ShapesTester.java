import java.awt.Color;
public class ShapesTester {
	public static void main(String[] args){
		//testing Parallelogram
		Coord coord1 = new Coord(1,1);
		Coord coord2 = new Coord(1,2);
		Coord coord3 = new Coord(2,2);
		Coord coord4 = new Coord(2,1);
		Parallelogram.draw(coord1, coord2, coord3, coord4);
	}	
}	
