public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		
		// boolean[][] isVis = new boolean[s.length()][s.length()];
		int[][] f = new int[s.length()][s.length()];
		
		return check(s, dict, 0, s.length()-1, f);
    }
	
	public boolean check(String s, Set<String> dict, int i, int j, int[][] f)
	{
		if(f[i][j] == 1) return true;
		if(f[i][j] == -1) return false;
		String s0 = s.substring(i, j+1);
		if(dict.contains(s0))
		{
			f[i][j] = 1;
			return true;
		}
		for(int k = i+1; k <= j; k++)
		{
			if(check(s, dict, i, k-1, f)&&check(s, dict, k, j, f))
			{
				f[i][j] = 1;
				return true;
			}
		}
		
		f[i][j] = -1;
		return false;
	}
}