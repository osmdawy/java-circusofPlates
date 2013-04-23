import java.util.Stack;


public class ReadOnlyPlayer  {
Player p;

public  ReadOnlyPlayer(Player player) {
	p=player;
}
	public String getPlayerImage() {
		// TODO Auto-generated method stub
		return p.getImgURL();
	}
	public Stack<Shape> getPlayerStack(){
		return p.getShapes();
	}public int getPosX(){
		return p.getPosX();
	}
	public int getPosY(){
		return p.getPosY();
	}
	public int getWidth(){
		return p.getPosWidth();
	}
	public int getHeight(){
		return p.getPosHeight();
	}
	public Stack<Shape> getStack(){
		return p.getShapes();
	}
	public int getScore(){
		return p.score;
	}
}
