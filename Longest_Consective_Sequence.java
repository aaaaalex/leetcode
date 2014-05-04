public class Solution {
    public int longestConsecutive(int[] num) {
        	Set<Integer> records = new HashSet<Integer> ();
        	Set<Integer> stamps = new HashSet<Integer> ();
        	for(int v : num) {
        		records.add(new Integer(v));
        		stamps.add(new Integer(v));
        	}

        	int len = 0;
        	int currLen = 1;
        	for(Integer v : stamps) {
        		if(!records.contains(v)) {
        			continue;
        		}
        		int nextV = v+1;
        		currLen = 1;
        		while(records.contains(nextV)) {
        			records.remove(nextV);
        			nextV++;
        			currLen++;
        		}
        		int preV = v-1;
        		while(records.contains(preV)) {
        			records.remove(preV);
        			preV--;
        			currLen++;
        		}

        		if(currLen > len) {
        			len = currLen;
        		}
        	}

        	return len;
    }
}