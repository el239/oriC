
public class part2{
	public static void main(String args[]){
	   oriC("aaggggcccc");
//	   oriC(testCase1.toCharArray());
//	   String testCase1 = ("aagggggccccc");
//	   System.out.println(oriC(testCase1));
    } // end main
	
	public static void oriC(String input){
		int i, ratioMeter, marker, gCount, cCount = 0;
		char[] potentialSites;
		for(i = 0; i < input.length(); i++){ // finds first highest "peak" in G/C ratio
			if (String.valueOf(input.charAt(i)) == ("G") || String.valueOf(input.charAt(i)) == ("G")){
				ratioMeter++;
			    gCount++;
			} // end if
			if (String.valueOf(input.charAt(i)) == ("C") || String.valueOf(input.charAt(i)) == ("c")){
				ratioMeter--;
			    cCount++;
			} // end if
			if (ratioMeter > marker){
				marker = ratioMeter;
				potentialSites = (i + 1); 
			} // end if
		} // end for
		
		i = 0; // resets loop
		
		for(i = 0; i < input.length(); i++){ // finds alternative potential sites, e.g. "ties"
			if (input[i].equalsIgnoreCase("G"))
				ratioMeter++;
			if (i.equalsIgnoreCase("C"))
				ratioMeter--;
			if (ratioMeter == marker){
				potentialSites += (i + 1); 
			} // end if
		} // end for
		
		if (cCount == 0 && gCount == 0)
			System.println("No cytosine or guanine bases present by which to predict oriC.");
		    return;
		if(potentialSites.length() == 1)
			System.println("The most likely oriC site based on G/C ratio is at base # " + potentialSites);
		    return;
		if(potentialSites.length() > 1){
			System.out.println("The most likely oriC sites based on G/C ratio are at base numbers ")
			int i = 0;
			if(potentialSites.length() == 2){
			    System.out.println(potentialSites[0] + " and " potentialSites[1] ".");
			    return;
			} // end if
			else{
			    for (i; i < potentialSites.length() - 1; i++)
				   System.out.print(potentialSites[i] + ", ");
			    System.out.println("and " + potentialSites[-1] + ".");   
			    return; 
			} // end else
		} // end if
	} // end oriC
} // end part2