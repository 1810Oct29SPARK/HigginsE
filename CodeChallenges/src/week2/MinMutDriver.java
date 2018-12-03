package week2;
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
*/
public class MinMutDriver extends Methods {
	
	public static void main(String[] args) {
		
		findMinMutations("ACGTTGCA", "ACGGTGCA", {"ACCGGTCA", "ACGTACGT", "ACGGTGCA"});
		
		
		/*
		String filename = "src/MinMutStrings";
		System.out.println(deserializeFromFile(filename));
		*/
	}
	
	/*
	
	static void serializeToFile(String filename, Object o) {
		try {
			// use a FileOutputStream to write serialized object to file
			FileOutputStream fileOut = new FileOutputStream(filename);
			// use ObjectOutputStream to serialize the object
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o); //what actually does the serialization
			// close resources
			out.close();
			fileOut.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializeFromFile(String filename) {
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch(FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
}
*/
}
