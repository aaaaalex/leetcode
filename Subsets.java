public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		
		rs = exec(S, Integer.MIN_VALUE, true);
		return rs;
    }
	
	public static ArrayList<ArrayList<Integer>> exec(int[] S, int p, boolean isStart)
	{
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		for(int i = 0; i < S.length; i++)
		{
			if(isStart)
			{
				ArrayList<ArrayList<Integer>> tmp = exec(S, S[i], false);
				//rs.addAll(tmp);
				for(ArrayList<Integer> curr : tmp)
				{
					curr.add(0, S[i]);
					rs.add(curr);
				}
			}
			else if(S[i] > p)
			{
				ArrayList<ArrayList<Integer>> tmp = exec(S, S[i], false);
				//rs.addAll(tmp);
				for(ArrayList<Integer> curr : tmp)
				{
					curr.add(0, S[i]);
					rs.add(curr);
				}
			}
		}
		ArrayList<Integer> t = new ArrayList<Integer> ();
		rs.add(t);
		return rs;
	}
}