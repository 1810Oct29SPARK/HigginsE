

public class MinMutations {

	public MinMutations() {
	}
	
	public int minMutation(String start, String end, String[] bank) {
        int count = 0;
		
		if(start.length() != end.length()) return -1;


		
		Queue<String> q = new LinkedList<String>();		
		q.add(start);
		while(!q.isEmpty()){
			
			Queue<String> temp = new LinkedList<String>();
			while(!q.isEmpty()){
                
                // retrieves and remove the head of this queue,
                // or returns null if this queue is empty.
				String tmp = q.poll();
                if(tmp.equals(end)) { 
                return count;
            }
				for(String s:bank){
					if(mutation(tmp,s) == 1){
						temp.add(s);
					}
				}
			}
			q = temp;
			count++;
		}
		
		return -1;
    }

    // checks to see how many characters are different between two strings
    public int mutation(String tmp,String s){
		int count = 0;
		for(int i = 0; i < tmp.length();i++){
			if(tmp.charAt(i) != s.charAt(i)){
				count++;
			}
		}
		return count;
	}
}