public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer> ();
		for(int i = 0; i < num.length; i++)
		{ 
			if(record.get(num[i]) == null)
				record.put(num[i], 1);
			else
				record.put(num[i], record.get(num[i])+1);
		}
		
		return solve(record);
    }
	
	public static ArrayList<ArrayList<Integer>> solve(HashMap<Integer, Integer> record)
	{
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		Set<Integer> keys = record.keySet();
		
		for(Integer i : keys)
		{
			if(record.get(i) > 0)
			{
				int curr = i;
				record.put(curr, record.get(curr)-1);
				ArrayList<ArrayList<Integer>> tmp = solve(record);
				if(tmp.size() == 0)
				{
					ArrayList<Integer> t = new ArrayList<Integer> ();
					tmp.add(t);
				}
				for(ArrayList<Integer> t : tmp)
				{
					t.add(0, curr);
				}
				rs.addAll(tmp);
				record.put(curr, record.get(curr)+1);
			}
		}
		return rs;
	}
}