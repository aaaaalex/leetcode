public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(s == null)
			return true;
		int[] r = new int[3]; 
		return check(s);
    }
	
	boolean check(String s)
	{
		if(s.length() == 0)
			return true;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '{')
			{
				int p = find(i+1, '}', s);

				if(p < 0)
					return false;

				if(i+1 == p || check(s.substring(i+1, p)))
					i = p;
				else
					return false;
			}
			else if(s.charAt(i) == '[')
			{
				int p = find(i+1, ']', s);
				
				if(p < 0)
					return false;
				
				if(i+1 == p || check(s.substring(i+1, p)))
					i = p;
				else
					return false;
			}
			else if(s.charAt(i) == '(')
			{
				int p = find(i+1, ')', s);
				
				if(p < 0)
					return false;
				
				if(i+1 == p || check(s.substring(i+1, p)))
					i = p;
				else
					return false;
			}
			else if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
				return false;
		}

		return true;
	}
	
	private int find(int n, char target, String s)
	{
		if(target == '}')
		{
			int tmp = 0;
			for(int i = n; i<s.length(); i++)
			{
				if(s.charAt(i) == '{')
					tmp++;
				else if(s.charAt(i) == '}')
				{	tmp--;
					if(tmp == -1)
						return i;
				}
			}
			return -1;
		}
		else if(target == ']')
		{
			int tmp = 0;
			for(int i = n; i<s.length(); i++)
			{
				if(s.charAt(i) == '[')
					tmp++;
				else if(s.charAt(i) == ']')
				{	tmp--;
					if(tmp == -1)
						return i;
				}
			}
			return -1;
		}
		else
		{
			int tmp = 0;
			for(int i = n; i<s.length(); i++)
			{
				if(s.charAt(i) == '(')
					tmp++;
				else if(s.charAt(i) == ')')
				{	tmp--;
					if(tmp == -1)
						return i;
				}
			}
			return -1;
		}
		
	}
}