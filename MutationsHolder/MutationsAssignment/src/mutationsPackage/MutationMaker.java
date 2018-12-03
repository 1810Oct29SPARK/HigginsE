package mutationsPackage;

import java.util.ArrayList;

public class MutationMaker {
	public MutationMaker(String startGene, String endGene, String[] geneBank) {
		super();
		this.startGene = startGene;
		this.endGene = endGene;
		this.geneBank = geneBank;
	}
	String startGene;
	String endGene;
	String[] geneBank;
	private boolean mutationsFound;
	
	public int mutationCheck()
	{
		String geneBeingLookedAt=startGene;
		int mutationsNeeded=0;
		boolean mutationFound=false;
		 ArrayList<Integer> charLocations = new ArrayList<Integer>(); 
		 ArrayList<String> geneHolder= new ArrayList<String>();
		String testGene = startGene;
		if(startGene==endGene)
		{
			System.out.println("these genes are the same, no mutation needed");
			return 0;
		}
		
		
		for(int currentLetter=0;currentLetter<startGene.length();currentLetter++)
		{
			if(testGene.charAt(currentLetter)!=endGene.charAt(currentLetter))
			{
				charLocations.add(currentLetter);
			}
		}

while(testGene.equals(endGene)==false)
{
	for(int currentLetter=0;currentLetter<startGene.length();currentLetter++)
	{
		
		if(testGene.charAt(currentLetter)!=endGene.charAt(currentLetter))
		{
			charLocations.add(currentLetter);
		}
	}
	
	for(int i=0;i<charLocations.size();i++)
	{
		StringBuilder testGeneBuilder = new StringBuilder(testGene);
		testGeneBuilder.setCharAt(charLocations.get(i), endGene.charAt(charLocations.get(i)));
		String testGeneToAdd=testGeneBuilder.toString();
		geneHolder.add(testGeneToAdd);
	}
			for(int i=0;i<geneHolder.size();i++)
			{
				for(int j=0; j<geneBank.length;j++)
				{
					if(geneHolder.get(i).equals(geneBank[j]))
							{
							System.out.println(geneHolder.get(i)+" "+geneBank[j]);
							System.out.println("genes match!");
							testGene=geneBank[j];
							mutationsNeeded++;
							mutationFound=true;
							geneHolder.clear();
							if(testGene==endGene)
							{
								System.out.println("needed this many muations:"+mutationsNeeded);
								return mutationsNeeded;
							}
							else
							{
								break;
							}
							}
					else
					{
						System.out.println(geneHolder.get(i)+" "+geneBank[j]);
						System.out.println("genes don't match");
					}
				}
			}
			if(mutationFound==false)
			{
				return-1;
			}
			mutationFound=false;
	}
return -1;
	}
}
				
	


