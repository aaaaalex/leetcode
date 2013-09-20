public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
		boolean isNega = false;
		if(x < 0)
			isNega = true;
		int rs = 0;
		
		x = Math.abs(x);
		while(x > 0)
		{
			int tmp = x%(10);
			rs = rs*10+tmp;
			x /= 10;
		}
		if(isNega)
			rs *= -1;
		return rs;
    }
}