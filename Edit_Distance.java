public class Solution {
    public int minDistance(String word1, String word2) {
    	int[][] records = new int[word1.length()+1][word2.length()+1];
    	for(int i = 0; i <= word1.length(); i++) {
    		for(int j = 0; j <=word2.length(); j++) {
    			records[i][j] = -1;
    		}
    	}
    	return process(word1, word2, 0, 0, records);
    }

    public int process(String word1, String word2, int s1, int s2, int[][] records) {
    	if(records[s1][s2] >= 0) {
    		return records[s1][s2];
    	}
    	if(s1 == word1.length() || s2 == word2.length()) {
    		records[s1][s2] = (word1.length() - s1) + (word2.length() - s2);
    		return records[s1][s2];
    	}

 		//Three possible action
 		//1. delete
 		//2. insert
 		//3. replace
 		if(word1.charAt(s1) == word2.charAt(s2)) {
 			int sum = process(word1, word2, s1+1, s2+1, records);
 			records[s1][s2] = sum;
 			return records[s1][s2];
 		}

/*
 		//delete
 		int dela = process(word1, word2, s1+1, s2, records) + 1;
 		int delb = process(word1, word2, s1, s2+1, records) + 1;

 		//insert
 		int insa = process(word1, word2, s1, s2+1, records) + 1;
 		int insb = process(word1, word2, s1+1, s2, records) + 1;

 		//replace
 		int rep = process(word1, word2, s1+1, s2+1, records) + 1;

*/
 		int v1 = process(word1, word2, s1+1, s2, records) + 1;
 		int v2 = process(word1, word2, s1, s2+1, records) + 1;
 		int v3 = process(word1, word2, s1+1, s2+1, records) + 1;

 		int v = Math.min(Math.min(v1, v2), v3);
 		records[s1][s2] = v;
 		return records[s1][s2];
    }
}