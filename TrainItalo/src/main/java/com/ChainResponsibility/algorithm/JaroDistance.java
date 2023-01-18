package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class JaroDistance extends CheckChainStandards{ 
	private double threshold;
	
	
	public JaroDistance(double threshold) {
		super();
		this.threshold = threshold;
	}

	@Override
	protected boolean compare(String input, String standard) {
		double distance = jaroDistanceAlgorithm(standard, input);
		if (distance<0.85 && distance>=0.70)
			System.out.println("Forse cercavi "+ standard+"?");
		return (distance < threshold) ? false : true;
	}
	
	static double jaroDistanceAlgorithm(String s1, String s2){
	    // If the Strings are equal
	    if (s1 == s2) return 1.0;
	    if(s1.toLowerCase().equals(s2.toLowerCase())) return 1.0;
	 
	    // Length of two Strings
	    int len1 = s1.length(),
	        len2 = s2.length();
	 
	    // Maximum distance upto which matching
	    // is allowed
	    int max_dist = (int) (Math.floor(Math.max(len1, len2) / 2) - 1);
	 
	    // Count of matches
	    int match = 0;
	 
	    // Hash for matches
	    int hash_s1[] = new int[s1.length()];
	    int hash_s2[] = new int[s2.length()];
	 
	    // Traverse through the first String
	    for (int i = 0; i < len1; i++){
	 
	        // Check if there is any matches
	        for (int j = Math.max(0, i - max_dist);j < Math.min(len2, i + max_dist + 1); j++) 
	 
	            // If there is a match
	            if (s1.charAt(i) == s2.charAt(j) && hash_s2[j] == 0)
	            {
	                hash_s1[i] = 1;
	                hash_s2[j] = 1;
	                match++;
	                break;
	            }
	        
	    }
	 
	    // If there is no match
	    if (match == 0)
	        return 0.0;
	 
	    // Number of transpositions
	    double t = 0;
	 
	    int point = 0;
	 
	    // Count number of occurrences
	    // where two characters match but
	    // there is a third matched character
	    // in between the indices
	    for (int i = 0; i < len1; i++)
	        if (hash_s1[i] == 1){
	 
	            // Find the next matched character
	            // in second String
	            while (hash_s2[point] == 0)
	                point++;
	 
	            if (s1.charAt(i) != s2.charAt(point++) )
	                t++;
	        }
	 
	    t /= 2;
	    
	 
	    // Return the Jaro Similarity
	    return (((double)match) / ((double)len1)
	            + ((double)match) / ((double)len2)
	            + ((double)match - t) / ((double)match))
	        / 3.0;
	}



}
