public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s == null || s.length() <= 1)
			return 0;

		int[] record = new int[s.length()+1];
		
		for(int i = 0; i < record.length; i++)
		{
			record[i] = -1;
		}
		
		return solve(s, record, 0);
    }
	
	public static int solve(String s, int[] record, int p)
	{
		if(s == null || s.length() == 0)
			return 0;
		
		int l = s.length();
		
		if(record[p] >= 0)
			return record[p]; 
		
		int rs = Integer.MAX_VALUE;
		
		for(int i = 0; i < l; i++)
		{
			if(isPalin(s.substring(0, i+1)))
			{
				if(record[p+i+1] == -1)
				{
					int tmp = solve(s.substring(i+1, l), record, p+i+1);
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
	
	public static boolean isPalin(String s)
	{
		if(s.length() == 1)
			return true;
			
		int i = 0;
		int j = s.length()-1;
		
		while(i <= j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}
}