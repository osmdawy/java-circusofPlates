//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Convoyer {
//
//	private String imageUrl = "conv.png";
//	LinkedList<Shape> shapes;
//	private int positionX;
//	private int positionY;
//	private int startOfShapes = 0;
//	private String direction;
//	private int length;
//
//	public Convoyer(int x, int y, int start, LinkedList<Shape> s, String direc, int l) {
//
//		this.positionX = x;
//		this.positionY = y;
//		this.startOfShapes = start;
//		this.shapes = s;
//		this.direction = direc;
//		this.length = l;
//	}
//
//	public int getLength() {
//		return length;
//	}
//
//	public void setLength(int length) {
//		this.length = length;
//	}
//
//	public void setStartOfShapes(int startOfShapes) {
//		this.startOfShapes = startOfShapes;
//	}
//
//	public int getStartOfShapes() {
//		return startOfShapes;
//	}
//
//	public int getPositionX() {
//		return positionX;
//	}
//
//	public int getPositionY() {
//		return positionY;
//	}
//
//	public String getDirection() {
//		return direction;
//	}
//
//	public LinkedList<Shape> getShapes() {
//		return shapes;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public boolean checkFalling() {
//		if (!shapes.isEmpty()) {
//			Shape sh = shapes.peekLast();
//			if (direction.equalsIgnoreCase("toLeft")) {
//			
//				if (sh.getPosX() <= positionX) {
//
//					return true;
//				}
//			} else {
//				if (sh.getPosX() >= positionX) {
//					
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//}
