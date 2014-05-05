public class Solution {
    public int longestValidParentheses(String s) {
 		if(s == null || s.length() == 0) {
 			return 0;
 		}

 		int strLen = s.length();
 		int[] records = new int[s.length()];

 		int currLen = 0;
 		int max = 0;
 		int currStart = 0;

 		for(int i = 0; i < s.length(); i++) {
 			if(s.charAt(i) == ')') {
 				records[currStart]--;
 			} else {
 				records[currStart]++;
 			}

 			if(records[currStart] < 0) {
 				if(i - currStart > max) {
 					max = i - currStart;
 				}
 				currStart = i + 1;
 				continue;
 			}
 			if(records[currStart] == 0 && (i - currStart + 1 > max))
 			    max = i - currStart + 1;
 		}

 		int[] revRecords = new int[s.length()];

 		currStart = s.length() - 1;
 		for(int i = s.length() - 1 ; i >= 0; i--) {
 			if(s.charAt(i) == ')') {
 				revRecords[currStart]++;
 			} else {
 				revRecords[currStart]--;
 			}

 			if(revRecords[currStart] < 0) {
 				if(currStart - i > max) {
 					max = currStart - i;
 				}
 				currStart = i - 1;
 				continue;
 			}
 			if(revRecords[currStart] == 0 && (currStart - i + 1 > max))
 			    max = currStart - i + 1;
 		}

 		return max;
    }
}