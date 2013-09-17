public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> nums = new ArrayList<Integer> ();
		for(int i = 1; i <= n; i++)
		{
			nums.add(i);
		}
		String rs = "";
		for(int i = 1; i <= n; i++)
		{
			/* if(nums.size() == 1)
			{
				rs = rs+nums.get(0);
				break;
			} */
			int currdigitPos = currDigit(nums, k);
			int currdigit = nums.get(currdigitPos);
			int count = peruNum(nums.size()-1);
			rs = rs + currdigit;
			nums.remove(currdigitPos);
			k = k - currdigitPos*count;
		}
		
		return rs;
    }
	
	public static int currDigit(ArrayList<Integer> nums, int k)
	{
		int count = peruNum(nums.size()-1);
		//int d = k%count;
		int c = (k-1)/count;
		return c;
	}
	
	public static int peruNum(int n)
	{
		int rs = 1;
		for(int i = 1; i <= n; i++)
		{
			rs *= i;
		}
		return rs;
	}
}