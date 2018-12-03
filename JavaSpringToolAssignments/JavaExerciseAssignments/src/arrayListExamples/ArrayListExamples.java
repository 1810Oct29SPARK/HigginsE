package arrayListExamples;
import java.io.*; 
import java.util.*; 



//General Description:
/*
 *  ArrayLists are similar to arrays with the major difference that the number of indexes an ArrayList
 *  can have is variable. However, ArrayLists cannot use primitive types and require Wrapper Classes if 
 *  they need to do so. ArrayLists can also call a random an index at random if necessary(such as a 6
 *  sided die)./ 
 */


//Ordered/Indexed?
/*
 * ArrayLists are both ordered and indexed. Each value in a list has an index associated with it and have a specific
 * order.
 */

//Synchronized?
/*
 * ArrayLists are not inherently Threadsafe.
 */

//Duplicates/Nulls?
/*
 *  ArrayLists allow both Nulls and Duplicate values.
 */
public class ArrayListExamples {

	public static void main(String[] args) {
		ArrayList<Integer> exampleList=new ArrayList<Integer>();
		exampleList.add(6);
		exampleList.add(15);
		exampleList.add(49);
		exampleList.add(61);
		exampleList.add(72);
		exampleList.add(90);
		System.out.println(exampleList);
		//forEach method does whatever anonymous function you create to each index in the ArrayList in order.
		System.out.println("here is every number in exampleList with 3 added to it");
		 exampleList.forEach((n) -> System.out.println(n+3));
		 //contains method is a boolean that checks if the inserted argument is located at one of the indexes
		 //of the ArrayList or not. If the argument is found, it returns True. if it is not found,
		 //it returns False.
		 if(exampleList.contains(6))
		 {
			 System.out.println("six is in this ArrayList");
		 }
		 
		 if(!exampleList.contains(63))
		 {
			 System.out.println("sixty three is not in this ArrayList");
		 }
		 //set replaces the value of the specified index with the the specified value
		 exampleList.set(1,200);
		 System.out.println(exampleList.get(1));
		 //remove removes the specified index from the list; this can be pretty disruptive as it means all higher
		 //indexes have their index changed
		 System.out.println(exampleList.get(4));
		 exampleList.remove(3);
		 System.out.println(exampleList);
		 System.out.println(exampleList.get(4));
		 
		 
		 
	}

}
