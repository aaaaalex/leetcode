public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
		return sumup2(num, 0, target);
		
    }
	
	public ArrayList<ArrayList<Integer>> sumup2(int[] num, int start, int target)
	{
		//if(target < 0)
	
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>> ();
		for(int i = start; i<num.length; i++)
		{
			if(num[i] > target)
				break;
			
			if(num[i] == target)
			{
				ArrayList<Integer> tmpr = new ArrayList<Integer> ();
				tmpr.add(num[i]);
				r.add(tmpr);
				break;
			}
			
			ArrayList<ArrayList<Integer>> tmprs = sumup2(num, i+1, target - num[i]);
			
			for(int ii = 0; ii<tmprs.size(); ii++)
			{
				tmprs.get(ii).add(0, num[i]);
				r.add(tmprs.get(ii));
			}
			
			while(i < num.length - 1)
			{
				if(num[i] != num[i+1])
					break;
				i++;
			}
		}
		
		return r;
	}
}