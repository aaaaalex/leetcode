public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Arrays.sort(candidates);
        return SumUp(candidates, target);
    }
	
	public ArrayList<ArrayList<Integer>> SumUp(int[] candidates, int target)
	{
		if(target < 0)
		{
			return new ArrayList<ArrayList<Integer>> ();
		}
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>> ();
		for(int i = 0; i < candidates.length; i++)
		{
			if(target == candidates[i])
			{
				ArrayList<Integer> tmprs = new ArrayList<Integer> ();
				//ArrayList<ArrayList<Integer>> tmprss = new ArrayList<ArrayList<Integer>> ();
				tmprs.add(candidates[i]);
				r.add(tmprs);
				break;
			}
			
			if(candidates[i] > target)
			{
				break;
			}
			
			ArrayList<ArrayList<Integer>> tmps = SumUp(Arrays.copyOfRange(candidates, i, candidates.length), target - candidates[i]);
			if(tmps != null)
			{
				for(int ii = 0; ii < tmps.size(); ii++)
				{
					ArrayList<Integer> tmp = tmps.get(ii);
					tmp.add(0, candidates[i]);
					r.add(tmp);
				}
			}
		}
		
		return r;
	}
	
}