public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(num.length <= 1)
			return;
		
		for(int i = num.length-1; i >= 0; i--)
		{
			if(i >= 1 && num[i] > num[i-1])
			{
				int tmp = num[i-1];
				Arrays.sort(num, i, num.length);
				int j;
				for(j = i; j<num.length; j++)
				{
					if(num[j] > tmp)
						break;
				}
				num[i-1] = num[j];
				num[j] = tmp;
				break;
			}
			
			if(i == 0)
			{
				Arrays.sort(num);
			}
		}
    }
}