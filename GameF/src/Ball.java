import java.awt.Dimension;
import java.io.Serializable;

public class Ball implements Shape , Serializable{
	Dimension imageSize = new Dimension(50, 52);
	String type = "Plate";
	String imageColor;
	String uRLbLackShape = "blackball.png";
	String uRLOrangeShape = "orangeball.png";
	String uRLRedShape = "redball.png";
	String uRLBlueShape = "blueball.png";
	String uRLGreenShape = "greenball.png";
	int posX = 0;
	int posY = 0;
Dimension size= new Dimension(50,50);
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return imageSize;
	}

	@Override
	public void setColor(String color) {
		imageColor = color;

	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return imageColor;
	}

	@Override
	public String getURLBlackShape() {
		// TODO Auto-generated method stub
		return uRLbLackShape;
	}

	@Override
	public String getURLBlueShape() {
		// TODO Auto-generated method stub
		return uRLBlueShape;
	}

	@Override
	public String getURLRedShape() {
		// TODO Auto-generated method stub
		return uRLRedShape;
	}

	@Override
	public String getURLGreenShape() {
		// TODO Auto-generated method stub
		return uRLGreenShape;
	}

	@Override
	public String getURLOrangeShape() {
		// TODO Auto-generated method stub
		return uRLOrangeShape;
	}

	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public void setPosX(int pos) {
		posX = pos;

	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return posY;
	}

	@Override
	public void setPosY(int pos) {
		posY = pos;

	}
}
