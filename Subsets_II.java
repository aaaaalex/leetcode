public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		
		if(num.length == 0)
			return rs;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int n : num)
		{
			if(n > max)
				max = n;
			if(n < min)
				min = n;
		}
		
		int len = max - min + 1;
		int[] r = new int[len];
		
		//HashMap<Integer, Integer> records = new HashMap<Integer, Integer> ();
		for(int i = 0; i < num.length; i++)
		{
			int k = num[i] - min;
			/* if(records.contains(k))
				records.put(k, records.get(k)+1);
			else
				records.put(k, 1); */
			r[k]++;
		}
		
		return exec(0, r, min);
    }
	
	public static ArrayList<ArrayList<Integer>> exec(int p, int[] r, int min)
	{
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		for(int i = p; i < r.length; i++)
		{
			if(r[i] > 0)
			{
				r[i]--;
				ArrayList<ArrayList<Integer>> tmp = exec(i, r, min);
				for(ArrayList<Integer> t : tmp)
				{
					t.add(0,i+min);
					rs.add(t);
				}
				r[i]++;
			}
		}
		
		ArrayList<Integer> t = new ArrayList<Integer> ();
		rs.add(t);
		return rs;
	}
}