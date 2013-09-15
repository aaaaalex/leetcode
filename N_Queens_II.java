//This method exceed the large case time limitation

public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		return solve(new String[n], 0, n);
    }
	
	public static int solve(String[] curr, int count, int n)
	{
		if(count > n-1)
		{
			return 1;
		}
		
		int tmprs = 0;
		
		for(int i = 0; i < n; i++)
		{
			if(isAttack(curr, i, count))
				continue;
			curr[count] = createString(n, i);
			tmprs += solve(curr, count+1, n);
		}
		return tmprs;
	}
	
	public static String createString(int n, int p)
	{
		String rs = "";
		for(int i = 0; i < n; i++)
		{
			if(i == p)
				rs = rs+"Q";
			else
				rs = rs+".";
		}
		return rs;
	}
	
	public static boolean isAttack(String[] curr, int p, int count)
	{
		for(int i = 0; i < count; i++)
		{
			int index = curr[i].indexOf("Q");
			if(Math.abs(count-i) == Math.abs(index-p))
				return true;
			if(index == p)
				return true;
		}
		return false;
	}
}