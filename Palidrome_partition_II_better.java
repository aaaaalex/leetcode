public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s == null || s.length() <= 1)
			return 0;

		int[] record = new int[s.length()+1];
		int[][] rc = new int[s.length()][s.length()];
		boolean[][] r = new boolean[s.length()][s.length()];
		
		for(int i = 0; i < record.length; i++)
		{
			record[i] = -1;
		}
		
		return solve(s, record, 0, rc, r);
    }
	
	public static int solve(String s, int[] record, int p, int[][] rc, boolean[][] r)
	{
		if(s == null || s.length() == 0)
			return 0;
		
		int l = s.length();
		
		if(record[p] >= 0)
			return record[p]; 
		
		int rs = Integer.MAX_VALUE;
		
		for(int i = 0; i < l; i++)
		{
			boolean t = false;
			if(p == rc.length-1)
			{
				rc[p][p+i] = 1;
				r[p][p+i] = true;
				t = true;
			}
			else if(i == 0)
			{
				t = true;
				rc[p][p] = 1;
				r[p][p] = true;
			}
			else
			{
				if(rc[p+1][p+i-1] > 0)
				{
					rc[p][p+i] = 1;
					if(r[p+1][p+i-1] && s.charAt(0) == s.charAt(i))
					{
						r[p][p+i] = true;
						t = true;
					}
					else
					{
						r[p][p+i] = false;
						t = false;
					}
				}
				else
					t = isPalin(s.substring(0, i+1), rc, r, p, p+i);
			}
			if(t)
			{
				if(record[p+i+1] == -1)
				{
					int tmp = solve(s.substring(i+1, l), record, p+i+1, rc, r);
					record[p+i+1] = tmp;
				}
				int tmp = record[p+i+1];
				if(i < l-1)
					tmp++;
				if(tmp < rs)
					rs = tmp;
			}
		}
		//if(record[p] == -1 || rs < record[p])
			record[p] = rs;
		return rs;
	}
	
	public static boolean isPalin(String s, int[][] rc, boolean[][] r, int ss, int ee)
	{
		if(s.length() == 1)
			return true;
			
		int i = 0;
		int j = s.length()-1;
		rc[ss][ee] = 1;
		r[ss][ee] = false;
		while(i <= j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		r[ss][ee] = true;
		return true;
	}
}