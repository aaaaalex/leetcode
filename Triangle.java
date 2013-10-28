public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;
		
		return findmin(triangle, 0, 0);
    }
	
	public int findmin(ArrayList<ArrayList<Integer>> triangle, int level, int pre)
	{
		if(level >= triangle.size())
			return 0;
		if(level == 0)
			return findmin(triangle, 1, 0)+triangle.get(0).get(0);
		int[] poses = findPos(pre);
		return Math.min(findmin(triangle, level+1, poses[0])+triangle.get(level).get(poses[0]), findmin(triangle, level+1, poses[1])+triangle.get(level).get(poses[1]));
	}
	
	private int[] findPos(int pre)
	{
		int[] r = new int[2];
		r[0] = pre;
		r[1] = pre + 1;
		return r;
	}
}