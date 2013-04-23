import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Save {
public Save(){
	
}
	public void save (ArrayList<Object> allGame,String url,String name){
		String filename = url+name;
		

		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(url+filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(allGame);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public  ArrayList<Object> Load(String url , String filename){
		FileInputStream fis = null;
		ObjectInputStream in = null;
		ArrayList<Object> req = new ArrayList<Object>();
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			  req=  (ArrayList<Object>) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return req;	
	}
	
}
