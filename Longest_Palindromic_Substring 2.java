public class Solution {
    public String longestPalindrome(String s) {
		 
    }

    private String dpWay(String s) {
    	boolean[][] records = new boolean[s.length()][s.length()];
    	int max = 0;

    	for(int i = 0; i < s.length(); i++) {
    		for(int j = 0; j < i; j++) {
    			if(s.charAt(i) == s.charAt(j)) {
    				if(i == j + 1) {
    					records[j][i] = true;
    					if(max < 2) {
    						max = 2;
    					}
    				} else {
    					if(records[j+1][i-1]) {
    						records[j][i] = true;
    						if(max < i - j + 1) {
    							
    						}
    					}
    				}
    			}
    		}
    	}
    }

}