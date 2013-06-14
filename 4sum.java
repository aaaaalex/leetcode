public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length < 4){
			return new ArrayList<ArrayList<Integer>> ();
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		
		Arrays.sort(num);
		
		HashSet<ArrayList<Integer>> resset = new HashSet<ArrayList<Integer>> ();
		
		for(int i = 0; i < num.length - 3; i++){
			for(int j = i+1; j < num.length - 2; j++){
				int k = j+1;
				int w = num.length - 1;
				while(k < w){
				int sum = num[i]+num[j]+num[k]+num[w];
				if(sum > target){
					w--;
				}
				else if(sum < target){
					k++;
				}
				else if(sum == target){
					ArrayList<Integer> rs = new ArrayList<Integer> ();
					rs.add(num[i]);
					rs.add(num[j]);
					rs.add(num[k]);
					rs.add(num[w]);
					if(resset.add(rs))
						result.add(rs);
					k++;
					w--;
				}
				}
			}
		}
		return result;
    }
}