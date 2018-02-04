
public class part2{
	public static void main(String args[]){
	   oriC("aaggcc"); // TEST CASE 1: basic functionality
	   oriC("ATGGTGCC"); // TEST CASE 2: non-case sensitive
	   oriC("ccataca"); // handles oriC at sequence start
    } // end main
	
	public static void oriC(String input){
		int i = 0;
		int ratioMeter = 0;
		int gCount = 0;
		int cCount = 0;
		int marker =  0;
		int negativeRatio = 0;
		String potentialSites = "";
		for(i = 0; i < input.length(); i++){ // finds first highest "peak" in G/C ratio
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("g")){
				ratioMeter++;
			    gCount++;
			} // end if
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			    cCount++;
			} // end if
			if (ratioMeter > marker){
				marker = ratioMeter;
				potentialSites = Integer.toString(i + 1); 
				negativeRatio = 1; // prevents trigger of returning sequence start if peak ever exceeds 0
			} // end if
		} // end for
		
		if (cCount == 0 && gCount == 0){
			System.out.println("No cytosine or guanine bases present by which to predict oriC.");
		    return;
		} // end if

		i = 0; // resets loop
		ratioMeter = 0; // resets counter
		
		for(i = 0; i < input.length(); i++){ // finds alternative potential sites, e.g. "ties"
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("G")){
				ratioMeter++;
			} // end if
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			} // end if
			if (ratioMeter == marker && ratioMeter > 0){ // appends positive tie cases
				if(i + 1 > potentialSites.charAt(potentialSites.length()-1)){ // prevents appending with same base #
				potentialSites += Integer.toString(i + 1); 
				} // end if
			} // end if
		} // end for

		i = 0; // resets loop
		ratioMeter = 0; // resets counter
		
		if (negativeRatio == 0){
		for(i = 0; i < input.length(); i++){ // finds alternative potential sites @ zero, e.g. "ties"
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("G")){
				ratioMeter++;
			} // end if
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			} // end if
			if (ratioMeter == 0){ // appends tie cases
				if(i + 1 > potentialSites.charAt(potentialSites.length()-1)){ // prevents appending origin again
				potentialSites += Integer.toString(i + 1); 
				} // end if
			} // end if
		} // end for
		if (potentialSites.length() == 0) {
		    System.out.println("The most likely oriC site based on G/C ratio is at the origin.");
		    return;
		} // end if
		else {
			System.out.println("The most likely oriC sites based on G/C ratio at the origin");
			if(potentialSites.length() == 1){ // if one other incident of ratio equaling zero
			    System.out.println(" and " + potentialSites.charAt(0) + ".");
			    return;
			} // end if
			else{
				int j;
			    for (j = 0; j < potentialSites.length() - 1; j++){
				   System.out.print(potentialSites.charAt(j) + ", ");
			    } // end for
			    System.out.println("and " + potentialSites.charAt(potentialSites.length() - 1) + ".");   
			    return; 
			} // end else
		} // end else    
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
			    for (j = 0; j < potentialSites.length() - 1; j++){
				   System.out.print(potentialSites.charAt(j) + ", ");
			    } // end for
			    System.out.println("and " + potentialSites.charAt(potentialSites.length() - 1) + ".");   
			    return; 
			} // end else
		} // end if
	} // end oriC
} // end part2