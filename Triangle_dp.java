public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;
		
		int[] tmpstore = new int[triangle.size()];
		
		return find(triangle, 0, 0, tmpstore);
    }
	
	public int find(ArrayList<ArrayList<Integer>> triangle, int level, int curr, int[] tmpstore)
	{
		if(level >= triangle.size())
			return 0;
		/* if(level == 0)
			return  triangle.get(0).get(0)+find(triangle, 1, 0, tmpstore); */
		int pos[] = findPos(curr);
		int r, l;
		if(pos[0] == 0)
		{
			l = find(triangle, level+1, pos[0], tmpstore);
		}
		else
		{
			l = tmpstore[level];
		}
		
		r = find(triangle, level+1, pos[1], tmpstore);
		
		tmpstore[level] = r;
		int currval = triangle.get(level).get(curr);
		return Math.min(r, l)+currval;
	}
	
	private int[] findPos(int curr)
	{
		int[] r = new int[2];
		r[0] = curr;
		r[1] = curr + 1;
		return r;
	}
	
}