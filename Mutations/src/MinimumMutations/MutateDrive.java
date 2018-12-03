package MinimumMutations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MutateDrive {

	public static void main(String[] args) {
		
		String geneFile = "src/serializedGenes.txt/";
		MutateUtil mutate = new MutateUtil();
		System.out.println(mutate);
		System.out.println(deserialize(geneFile));
		
	}
	
	static void serialize(String geneFile, Object mutate) {
		try {
			FileOutputStream file = new FileOutputStream(geneFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(mutate);
			out.close();
			file.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserialize(String geneFile) {
		Object mutate = null;
		try {
			FileInputStream file = new FileInputStream(geneFile);
			ObjectInputStream in = new ObjectInputStream(file);
			mutate = in.readObject();
			in.close();
			file.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mutate;
	}

}
