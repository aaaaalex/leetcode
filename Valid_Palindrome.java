public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(s == null || s.length() == 0)
			return true;
		StringBuilder t = new StringBuilder();
		
		for(int i = 0; i<s.length(); i++)
		{
			char curr = s.charAt(i);
			if(Character.isLetter(curr) || Character.isDigit(curr))
			{
				if(Character.isLetter(curr))
				{
					curr = Character.toUpperCase(curr);
				}
				t.append(curr);
			}
		}
		
		String newString = t.toString();
		
		int l = newString.length();
		int i = 0, j = l-1;
		while(i<j)
		{
			if(newString.charAt(i) != newString.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
    }
}