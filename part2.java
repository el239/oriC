
public class part2{
	public static void main(String args[]){
	   oriC("aagcc"); // TEST CASE 1: basic functionality
	   oriC("GGCCATGGTCC"); // TEST CASE 2: non-case sensitive, handles ties
	   oriC("ccataca"); // TEST CASE 3: handles oriC at sequence start
	   oriC("ataaata"); // TEST CASE 4: handles lack of g/c bases
	   oriC("ccaggccgga"); // TEST CASE 5: handles 3 way ties and ties with origin
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
			System.out.print("\nNo cytosine or guanine bases by which to predict oriC location.");
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
			if (ratioMeter == marker && ratioMeter > 0 && // conditional prevents A and T indexes from being appended
			(String.valueOf(input.charAt(i)).equals("G") || 
			String.valueOf(input.charAt(i)).equals("g"))) { // appends positive tie cases
				if (i > potentialSites.length()) { // prevents appending with same base #
				potentialSites += Integer.toString(i + 1); 
				} // end if
			} // end if
		} // end for

		i = 0; // resets loop
		ratioMeter = 0; // resets counter
		
		if (negativeRatio == 0){
		for(i = 0; i < input.length(); i++){ // finds alternative potential sites @ zero, e.g. "ties"
			
			if (String.valueOf(input.charAt(i)).equals("G") || String.valueOf(input.charAt(i)).equals("g")){
				ratioMeter++;
			} // end if
			
			if (String.valueOf(input.charAt(i)).equals("C") || String.valueOf(input.charAt(i)).equals("c")){
				ratioMeter--;
			} // end if
			
			if (ratioMeter == 0 && (String.valueOf(input.charAt(i)).equals("G") || // prevents A and T from being appended
			String.valueOf(input.charAt(i)).equals("g"))) { // appends tie cases
				if(i > potentialSites.length()){ // prevents appending origin again
				potentialSites += Integer.toString(i + 1); 
				} // end if
			} // end if
		} // end for
		
		if (potentialSites.length() == 0) {
		    System.out.print("\nThe most likely oriC site based on G/C ratio is at the sequence start.");
		    return;
		} // end if
		else {
			System.out.print("\nThe most likely oriC sites based on G/C ratio are at the sequence start");
			if(potentialSites.length() == 1){ // if one other incident of ratio equaling zero
			    System.out.print(" and base # " + potentialSites.charAt(0) + ".");
			    return;
			} // end if
			else{
				int j;
				System.out.print(" and base numbers ");
			    for (j = 0; j < potentialSites.length() - 1; j++){
				   System.out.print(potentialSites.charAt(j) + ", ");
			    } // end for
			    System.out.print("and " + potentialSites.charAt(potentialSites.length() - 1) + ".");   
			    return; 
			} // end else
		} // end else    
		} // end if
		
		if(potentialSites.length() == 1){
			System.out.print("\nThe most likely oriC site based on G/C ratio is after base # " + potentialSites + ".");
		    return;
		} // end if
		
		if(potentialSites.length() > 1){
			System.out.print("\nThe most likely oriC sites based on G/C ratio are after base numbers ");
			int j;
			if(potentialSites.length() == 2){
			    System.out.print(potentialSites.charAt(0) + " and " + potentialSites.charAt(1) + ".");
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