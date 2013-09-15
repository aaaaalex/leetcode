public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n == 0)
			return new ArrayList<String[]> ();
		
		ArrayList<String[]> rs = new ArrayList<String[]> ();
		return solve(n, 0, new String[n]);
    }
	
	public static ArrayList<String[]> solve(int n, int count, String[] curr)
	{
		if(count >= n-1)
		{
			ArrayList<String[]> tmprs = new ArrayList<String[]> ();
			String[] s;
			for(int i = 0; i < n; i++)
			{
				if(isAttack(curr, i, count))
					continue;
				String tmpns = createString(n, i);
				s=new String[n];
				s[count] = tmpns;
				tmprs.add(s);
			}	
			return tmprs;
		}
		
		ArrayList<String[]> rs = new ArrayList<String[]> ();
		for(int i = 0; i < n; i++)
		{
			if(isAttack(curr,i, count))
				continue;
			String currString = createString(n, i);
			curr[count] = currString;
			ArrayList<String[]> r = solve(n, count+1, curr);
			if(r.size() > 0)
			{
				for(int j = 0; j < r.size(); j++)
				{
					String[] tmp = r.get(j);
					tmp[count] = currString;
				}
				rs.addAll(r);
			}
		}
		return rs;
	}
	
	public static String createString(int n, int q)
	{
		String rs = "";
		for(int i = 0; i < n; i++)
		{
			if(i == q)
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
			String tmp = curr[i];
			int index = tmp.indexOf("Q");
			if(Math.abs(count-i) == Math.abs(index - p))
				return true;
			if(index == p)
				return true;
		}
		
		return false;
	}
}