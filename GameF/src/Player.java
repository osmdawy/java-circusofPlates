import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;


public class Player implements Serializable{
	int posX;
	int dx;
	int posWidth;
	int posHeight;
	int startStackX;
	int startStackY;
	int posY;
	int score;
	String imgURL;
	Stack<Shape> shapes= new Stack<Shape>();
	public Player(){
		posX= 10;
		posY =550;
		score=0;
		 posWidth =202;
		posHeight=189;
		startStackX=posX;
		startStackY=posY+posY/4;
		imgURL = "clown.png";
	}
	public int getPosWidth() {
		return posWidth;
	}
	public void setPosWidth(int posWidth) {
		this.posWidth = posWidth;
	}
	public int getPosHeight() {
		return posHeight;
	}
	public void setPosHeight(int posHeight) {
		this.posHeight = posHeight;
	}
	public boolean checkIntersect(Shape s){
		boolean inter=false;
		
		if(shapes.isEmpty()){
			int checkX = (Math.abs(s.getPosX()-posX));
			

			int checkY =(int) (posY-(s.getPosY()));
			
			if(checkX<20&&checkY<=0){
//				System.out.println("here");
				//System.out.println(s.getPosY());
				inter=true;
		//		this.shapes.push(s);
				return inter;
			}
			inter=false;
		}else{
			int checkX = Math.abs(s.getPosX()-posX);
			int checkY =  (int) (shapes.peek().getPosY()-shapes.peek().getSize().height-(s.getPosY()));
//System.out.println(shapes.peek().getPosY());
//System.out.println("player"+s.getPosY());
			if(checkX<50&&checkY==0){
				
//				System.out.println("here");
				inter=true;
			//	this.shapes.push(s);
				
				return inter;
			}
		}
		return false;
	}
	public boolean checkScore(){
		boolean flag=false;
		Shape first = getShapes().pop();
		Shape second = getShapes().pop();
			Shape third = getShapes().pop();
			if (first.getColor().equals(second.getColor())&&first.getColor().equals(third.getColor())){
				flag = true;
			}else{
				flag =false;
			}
			shapes.push(third);
			shapes.push(second);
			shapes.push(first);
			return flag;
	}
public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Stack<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(Stack<Shape> shapes) {
		this.shapes = shapes;
	}
	public void move(){
		posX+=dx;
//		Iterator<Shape> it = shapes.iterator();
//		while(it.hasNext()){
//			Shape s = it.next();
//			s.setPosX(posX+=dx);
//		}
	}
//public static void main(String[] args) {
////	Shape s =new Plate();
//	String filename = "player.txt";
//	
//
//	FileOutputStream fos = null;
//	ObjectOutputStream out = null;
//	try {
//		fos = new FileOutputStream(filename);
//		out = new ObjectOutputStream(fos);
//		out.writeObject(s);
//		out.close();
//		System.out.println("Object Persisted");
//	} catch (IOException ex) {
//		ex.printStackTrace();
//	}
//	
//	FileInputStream fis = null;
//	ObjectInputStream in = null;
//	Shape sh = null;
//	try {
//		fis = new FileInputStream(filename);
//		in = new ObjectInputStream(fis);
//		  sh=  (Shape) in.readObject();
//		in.close();
//	} catch (IOException ex) {
//		ex.printStackTrace();
//	} catch (ClassNotFoundException ex) {
//		ex.printStackTrace();
//	}
//	// print out the size
//	System.out.println("Person Details Size: " +sh.getPosX());
//	System.out.println();
//	Queue<String> q= new  LinkedList<String>();
//	
//}
}

