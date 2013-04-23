import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicLoading {

	public Shape LoadShape(String className) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String url = "D://";
		File file = new File(url);
		try {
			// Convert File to a URL
			@SuppressWarnings("deprecation")
			URL[] urls = new URL[] { file.toURL() };
			// Create a new class loader with the directory
			ClassLoader loader = new URLClassLoader(urls);

			// Load in the class; Class.childclass should be located in
			// the directory file:/c:/class/user/information
			@SuppressWarnings("unchecked")
			Class<Shape> cls = (Class<Shape>) loader.loadClass(className);
			Shape instance = cls.getConstructor(new Class[] {}).newInstance();
			return instance;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Shape sh = new DynamicLoading().LoadShape("Plate");

	}
	//
	// public Class<Shape> LoadShape(String url,String className) {
	// File file = new File(url);
	// try {
	// // Convert File to a URL
	// @SuppressWarnings("deprecation")
	// URL[] urls = new URL[] { file.toURL() };
	// // Create a new class loader with the directory
	// ClassLoader loader = new URLClassLoader(urls);
	//
	// // Load in the class; Class.childclass should be located in
	// // the directory file:/c:/class/user/information
	// @SuppressWarnings("unchecked")
	// Class<Shape> cls = (Class<Shape>) loader.loadClass(className);
	//
	// return cls;
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SecurityException e) {
	// e.printStackTrace();
	// } catch (IllegalArgumentException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}