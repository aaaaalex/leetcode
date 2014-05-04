public class Solution {
    public int numDecodings(String s) {
        int[] records = new int[s.length()+1];
        records[0] = 1;
        if(s == null || s.length() == 0) {
        	return 0;
        }


        for(int i = 0; i < s.length(); i++) {
        	char currChar = s.charAt(i);
        	int currVal = currChar - '0';
        	int sum = 0;
        	if(i == 0) {
        		if(currVal == 0) {
        			return 0;
        		}
        		sum = 1;
        	} else {
        		char preChar = s.charAt(i-1);
        		int preVal = preChar - '0';
        		if(currVal == 0) {
        			if(preVal == 0 || preVal > 2) {
        				return 0;
        			} else {
        				sum = records[i-1];
        			}
        		}else {
        				sum = records[i];
        				//Then check if it can form an encode with the previous character
        				if(preVal == 1 || (preVal == 2 && currVal <= 6)) {
        					sum += records[i-1];
        				}
        			}
        		}
        		records[i+1] = sum;
        	}
        return records[s.length()];
    }

}