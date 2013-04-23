import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

public class ShapePool {

	int maxLength=100;
	static int currentSize = 0;
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	private static ShapePool pool = null;

	private ShapePool() {
		// TODO Auto-generated constructor stub
	}

	public static ShapePool getInstance() {
		if (pool == null) {
			pool = new ShapePool();
		}
		return pool;
	}

	public Shape acquireShape(String type) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Iterator<Shape> it = shapes.iterator();
		Shape s = null;
		while (it.hasNext()) {
			s = it.next();
			if (s.getType().equals(type))
				return s;
		}
		if (currentSize < maxLength) {
			ShapesFactory fac = new ShapesFactory();
			currentSize++;
			return fac.createShape(type);
		}
		return s;
	}

	public void releaseShape(Shape shape) {
		shapes.add(shape);
	}
}
