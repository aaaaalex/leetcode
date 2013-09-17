public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0)
			return false;
		
		if(x == 0)
			return true;
		
		int d = 1;
		
		while(x/10 >= d)
			d *= 10;
		
		while(x > 9)
		{
			int right = x%10;
			int left = x/d;
			
			if(right != left)
				return false;
			
			x = (x%d)/10;
			d /= 100;
		}
		
		return true;
    }
}