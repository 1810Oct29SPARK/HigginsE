import minMutation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EvaluateMinMutations()
{
	public static void main(String [] args) {

		//Hard Coding to test the file
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        minMutation(start, end, bank);
        
        FileInputStream fis = null;
        BufferedReader reader = null;
      
        try {
            fis = new FileInputStream("C:/Documents/Revature/exercise-submissions/MinimumMutations/fileMinMutations.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }           
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferedReaderExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferedReaderExample.class.getName()).log(Level.SEVERE, null, ex);
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(BufferedReaderExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }		
}