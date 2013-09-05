public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n == 0 || k <= 0)
			return new ArrayList<ArrayList<Integer>> ();
		
		return run(n, 1, k);
    }
	
	public ArrayList<ArrayList<Integer>> run(int n, int s, int k)
	{
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>> ();

		for(int i = s; i<=n-k+1; i++)
		{
			if(k == 1)
			{
				ArrayList<Integer> tmpr = new ArrayList<Integer> ();
				tmpr.add(i);
				r.add(tmpr);
			}
			else
			{
				ArrayList<ArrayList<Integer>> tmprs = run(n, i+1, k-1);
				for(int ii = 0; ii<tmprs.size(); ii++)
				{
					tmprs.get(ii).add(0, i);
					r.add(tmprs.get(ii));
				}
			}
		}
		return r;
	}
}