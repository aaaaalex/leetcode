public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int t = n;
		ArrayList<String> rs = process(n, 0);
		return rs;
    }
	
	public static ArrayList<String> process(int n, int c)
	{
		if(n == 0)
		{
			String t = ")";
			ArrayList<String> a = new ArrayList<String> ();
			a.add(t);
			return a;
		}
		
		ArrayList<String> rs = new ArrayList<String> ();
		
		if(c > 0)
		{
			ArrayList<String> tmp = process(n-1, c-1);
			for(String t : tmp)
			{
				t = ")" + t;
				rs.add(t);
			}
		}
		
		ArrayList<String> tmp2 = process(n-1, c+1);
		for(String t : tmp2)
		{
			t = "(" + t;
			rs.add(t);
		}
		
		return rs;
	}
}