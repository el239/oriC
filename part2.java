
public class part2{
	public static void main(String args[]){
	   oriC("aaggcc"); // simple test
	   oriC("ATGGTGCC"); // non-case sensitive
	   oriC("ccataca"); // handles oriC at sequence start
    } // end main
	
	public static void oriC(String input){
		int i = 0;
		int ratioMeter = 0;
		int gCount = 0;
		int cCount = 0;
		int marker =  0;
		String potentialSites = "";
		for(i = 0; i < input.length(); i++){ // finds first highest "peak" in G/C ratio
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("g")){
				ratioMeter++;
			    gCount++;
			    System.out.println("gCount: " + gCount);
			} // end if
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			    cCount++;
			    System.out.println("cCount: " + cCount);
			} // end if
			if (ratioMeter > marker){
				marker = ratioMeter;
				potentialSites = Integer.toString(i + 1); 
			} // end if
		} // end for
		
		i = 0; // resets loop
		ratioMeter = 0; // resets counter
		
		for(i = 0; i < input.length(); i++){ // finds alternative potential sites, e.g. "ties"
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("G")){
				ratioMeter++;
			} // end if
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			} // end if
			if (ratioMeter == marker){
				System.out.println(ratioMeter);
				potentialSites += Integer.toString(i + 1); 
			} // end if
		} // end for
		
		if (cCount == 0 && gCount == 0){
			System.out.println("No cytosine or guanine bases present by which to predict oriC.");
		    return;
		} // end if
		
		if(potentialSites.length() == 1){
			System.out.println("The most likely oriC site based on G/C ratio is after base # " + potentialSites);
		    return;
		} // end if
		
		if(potentialSites.length() > 1){
			System.out.println("The most likely oriC sites based on G/C ratio are after base numbers ");
			int j;
			if(potentialSites.length() == 2){
			    System.out.println(potentialSites.charAt(0) + " and " + potentialSites.charAt(1) + ".");
			    return;
			} // end if
			else{
			    for (j = 0; j < potentialSites.length() - 1; j++)
				   System.out.print(potentialSites.charAt(j) + ", ");
			    System.out.println("and " + potentialSites.charAt(potentialSites.length() - 1) + ".");   
			    return; 
			} // end else
		} // end if
	} // end oriC
} // end part2