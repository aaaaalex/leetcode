public class Solution {
    public	class MyInt
	{
		private int val;
		public int getValue()
		{
			return val;
		}
		
		public void setValue(int v)
		{
			this.val = v;
		}
		
		public MyInt(int v)
		{
			this.val = v;
		}
	
	}

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 0)
			return 0;
		MyInt ways = new MyInt(0);
		
		getWays(n, ways);
		return ways.getValue();
    }
	
	public void getWays(int n, MyInt ways)
	{
		if(n < 0)
			return;
		
		if(n == 0)
		{
			ways.setValue(ways.getValue()+1);
			return;
		}
		
		getWays(n - 1, ways);
		getWays(n - 2, ways);
	}
}