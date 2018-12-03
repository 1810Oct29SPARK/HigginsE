package javaQuestions;

public class JavaQuestionClass {

	public static void main(String[] args) {
		//Without using the StringBuilder or StringBuffer class, write a method that reverses a String.
		String wordToBeReversed="cactus";
		stringReverse(wordToBeReversed);
		//Convert a phrase to its acronym.
		String wordsToTurnIntoAcronym="laughing out Loud";
		acronymCreator(wordsToTurnIntoAcronym);
		//Determine if a triangle is equilateral, isosceles, or scalene.
		
		//Given a phrase, count the occurrences of each word in that phrase.
		String phraseToBeCounted="I just really like apples ok? apples are my favorite, I can't get enough of them apples";
		String wordToFind="apples";
		phraseCounter(phraseToBeCounted,wordToFind);
		

	}




	public static String stringReverse(String insertedString)
	{
		char[] arrayToBeReversed=insertedString.toCharArray();
		for(int i=0;i<arrayToBeReversed.length/2; i++)
		{	

			char heldValue=arrayToBeReversed[i];
			arrayToBeReversed[i]=arrayToBeReversed[arrayToBeReversed.length-1-i];
			arrayToBeReversed[arrayToBeReversed.length-1-i]=heldValue;

		}
		String stringResult=new String(arrayToBeReversed);
		System.out.println(stringResult);
		return stringResult;
	}
	
	public static String acronymCreator(String stringToBeShortened)
	{
        	String stringUpped=stringToBeShortened.toUpperCase();
        	String[] arrayOfShortenedString = stringUpped.split(" ");
            char[] acronymArray=new char[arrayOfShortenedString.length];
     
            	
            	for(int i=0;i<arrayOfShortenedString.length;i++)
            	{
            		acronymArray[i]=arrayOfShortenedString[i].charAt(0);
            	}
       
            	String acronymResult=new String(acronymArray);
            	System.out.println(acronymResult);
            	return acronymResult;
	}
	
	public static void triangleChecker(int angle1,int angle2,int angle3)
	{

	}
	
	public static void phraseCounter(String phraseToCount,String wordToFind)
	{
		String[] arrayOfShortenedString = phraseToCount.split(wordToFind);
		System.out.println(arrayOfShortenedString);
	}
}
