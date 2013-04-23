import java.lang.reflect.InvocationTargetException;

public class ShapesFactory {

	public ShapesFactory() {
		// TODO Auto-generated constructor stub
	}

	public Shape createShape(String type) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		DynamicLoading load = new DynamicLoading();
		Shape sh =  load.LoadShape(type);
		return sh;

	}
public static void main(String[] args) {
	
}
}
