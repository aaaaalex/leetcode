import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(num == null || num.length < 3)
			return new ArrayList<ArrayList<Integer>> ();
		
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
		Arrays.sort(num);
		
		for(int i = 0; i < num.length - 2; i++){
			int j = i+1;
			int k = num.length - 1;
			while(j < k){
				if(num[i]+num[j]+num[k] == 0){
					ArrayList<Integer> tmp = new ArrayList<Integer> ();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);
					res.add(tmp);
					while(j < k && num[j] == num[j+1])
						j++;
					j++;
					while(k > i && num[k] == num[k-1])
						k--;
					k--;
				}
				else{
					if(num[i]+num[j]+num[k] > 0)
						k--;
					else
						j++;
				}
				
			}
			while(i < num.length - 2 && num[i] == num[i+1])
                i++;
		}
		return res;
}
}