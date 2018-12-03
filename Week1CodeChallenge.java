import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Week1CodeChallenge 
{
	public int minNumMutations(String start, String end, String[] bank)
	{
		String beginStr = start;
		String endStr = end;
		String[] storBank = bank;
		int mov = 0;
		char[] listOfLetters = {'A', 'C', 'G', 'T'};
		Set<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		
		if( beginStr.length() != endStr.length() || storBank == null || storBank.length == 0)
		{
			mov = -1;
			return mov;
		}
		
		queue.offer(beginStr);
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
		
			for(int b = 0; b < size; b++)
			{
				String up = queue.poll();
				
				if(up.equals(endStr))
				{
					return mov;
				}
				
				for(int i = 0; i <= beginStr.length(); i++)
				{
					for(int z = 0; z < 4; z++)
					{
						if(up.charAt(i) != listOfLetters[z])
						{
							String str3 = beginStr.substring(0, i) + listOfLetters[z] + beginStr.substring(i + 1);
							if(set.contains(str3))
							{
								queue.offer(str3);
								set.remove(str3);
							}
						}
					}
				}
			}
		}
		
		mov++;
		return mov;
	}
	
	
	public void writeFile(String a, String b, int c) throws IOException
	{
		FileInputStream inFile = new FileInputStream("Week1CodeChallenge.java");
		ObjectInputStream bringIn = new ObjectInputStream(inFile);
		
		
	
	    
	}
}
