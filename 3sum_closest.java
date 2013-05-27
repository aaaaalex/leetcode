public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //First sort the given list
		int c = 0;
		int max = 0;
		for(int a : num){
			if(c == 0){
				max = a;
				c++;
			} else {
				if(max < a)
					max = a;
			}
		}
		//Now res is the sorted array
		Arrays.sort(num);
		int[] res = num;
		int minSub = Integer.MAX_VALUE;
		int min = 0;
		for(int i = 0; i < res.length - 2; i++){
			int j = i+1;
			int k = res.length - 1;
			
			while(j < k){
				int sub = Math.abs(target - res[i] - res[j] - res[k]);
				if(sub == 0)
					return res[i]+res[j]+res[k];
				if(sub < minSub){
					minSub = sub;
					min = res[i] + res[j] + res[k];
				} 
				if(res[i]+res[j]+res[k] > target)
					k--;
				else 
					j++;
			}
		}
		return min;

    }
	
	
}