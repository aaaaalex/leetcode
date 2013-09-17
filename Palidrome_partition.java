public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<String>> rs = new ArrayList<ArrayList<String>> ();
		
		return solve(s);
	}
	
	public static ArrayList<ArrayList<String>> solve(String s)
	{
		if(s == null || s.length() == 0)
			return new ArrayList<ArrayList<String>> ();
		ArrayList<ArrayList<String>> curr = new ArrayList<ArrayList<String>> ();
		for(int i = 0; i<s.length(); i++)
		{
			if(isPalin(s.substring(0, i+1)))
			{
				ArrayList<ArrayList<String>> tmp = solve(s.substring(i+1, s.length()));
				if(tmp == null || tmp.size() == 0)
				{
					ArrayList<String> t = new ArrayList<String> ();
					t.add(s.substring(0, i+1));
					curr.add(t);
				}
				else
				{
					for(ArrayList<String> a : tmp)
						a.add(0, s.substring(0, i+1));
					curr.addAll(tmp);
				}
			}
		}
		return curr;
	}
	
	public static boolean isPalin(String s)
	{
		if(s.length() == 1)
			return true;
		int i = 0;
		int j = s.length()-1;
		
		while(i<=j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}