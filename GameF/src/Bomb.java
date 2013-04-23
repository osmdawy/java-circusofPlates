import java.awt.Dimension;
import java.io.Serializable;


public class Bomb implements Shape ,Serializable{
String ImgURL = "bomb.png";
int posX1 =0;
int posY1 =0;
Dimension size = new Dimension(50,50);

@Override
public String getColor() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int getPosX() {
	// TODO Auto-generated method stub
	return posX1;
}
@Override
public int getPosY() {
	// TODO Auto-generated method stub
	return posY1;
}
@Override
public Dimension getSize() {
	// TODO Auto-generated method stub
	return size;
}
@Override
public String getType() {
	// TODO Auto-generated method stub
	return "bomb";
}
@Override
public String getURLBlackShape() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getURLBlueShape() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getURLGreenShape() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getURLOrangeShape() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getURLRedShape() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void setColor(String color) {
	// TODO Auto-generated method stub
	
}
@Override
public void setPosX(int pos) {
	// TODO Auto-generated method stub
	
}
@Override
public void setPosY(int pos) {
	// TODO Auto-generated method stub
	
}}
