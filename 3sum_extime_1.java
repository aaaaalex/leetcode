import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length < 3){
            return new ArrayList<ArrayList<Integer>> ();
        }
        
        Arrays.sort(num);
    	HashSet<String> resSet = new HashSet<String> ();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
		Hashtable<Integer, Integer> values = new Hashtable<Integer, Integer> ();
		
		for(int t : num){
			if(values.get(t) == null)
				values.put(t, 1);
			else{
				int c = values.get(t);
				c++;
				values.put(t, c);
			}
		}
		
		for(int i = 0; num[i] <= 0; i++){
			int tmpi = num[i];
			int ci = values.get(tmpi);
			ci--;
			values.put(tmpi, ci);
			
			for(int j = num.length - 1; j > i; j--){
				int tmpj = num[j];
				if(tmpj < 0){
					break;
				}
				int cj = values.get(tmpj);
				cj--;
				values.put(tmpj, cj);
				
				int target = 0 - tmpi - tmpj;
				if(values.get(target) != null){
					if(values.get(target) > 0){
						/* String curr = Integer.toString(tmpi); */
						/* if(tmpj <= target){
							curr = curr + Integer.toString(tmpj) +  Integer.toString(target);
						} else {
							curr = curr + Integer.toString(target) + Integer.toString(tmpj);
						} */
						ArrayList<Integer> tmpres = new ArrayList<Integer> ();
						tmpres.add(tmpi);
						if(tmpj <= target){
							tmpres.add(tmpj);
							tmpres.add(target);
						} else {
							tmpres.add(target);
							tmpres.add(tmpj);
						}
						if(!res.contains(tmpres)){
							res.add(tmpres);
						}
					}
				}
				cj++;
				values.put(tmpj, cj);
			}
            if(i >= num.length - 1)
    			break;   
		}
		return res;
    }
}