import java.awt.Dimension;
import java.io.Serializable;

public interface Shape {
	public String getType();

	public Dimension getSize();

	public void setColor(String color);

	public String getColor();

	public String getURLBlackShape();

	public String getURLOrangeShape();

	public String getURLBlueShape();

	public String getURLRedShape();

	public String getURLGreenShape();

	public int getPosX();

	public void setPosX(int pos);

	public int getPosY();

	public void setPosY(int pos);

}
