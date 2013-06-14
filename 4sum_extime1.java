public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length < 4){
			return new ArrayList<ArrayList<Integer>> ();
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		
		Arrays.sort(num);
		
		for(int i = 0; i < num.length - 3; i++){
			for(int j = i+1; j < num.length - 2; j++){
				int k = j+1;
				int w = num.length - 1;
				while(w > k){
					int tmp_sum = num[i] + num[j] + num[k] + num[w];
					if(tmp_sum > target){
						while(w > k && num[w] == num[w-1])
							w--;
						w--;
					} else if(tmp_sum < target){
						while(k < w && num[k] == num[k+1])
							k++;
						k++;
					} else if(tmp_sum == target){
						ArrayList<Integer> one_rs = new ArrayList<Integer> ();
						one_rs.add(num[i]);
						one_rs.add(num[j]);
						one_rs.add(num[k]);
						one_rs.add(num[w]);
						result.add(one_rs);
						while(k < w && num[k] == num[k+1])
							k++;
						k++;
						while(k < w && num[w] == num[w-1])
							w--;
						w--;
					}
				}
				while(j < num.length - 2 && num[j] == num[j+1])
					j++;
			}
			while(i < num.length - 3 && num[i] == num[i+1])
				i++;
		}
		return result;
    }
}