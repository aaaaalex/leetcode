public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // As not indicated in question, we cannot assume it is a sorted array
		
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer> ();
		int[] rs = new int[2];
		for(int i = 0; i < numbers.length; i++)
		{
			s.put(numbers[i], i);
		}
		
		for(int i = 0; i < numbers.length; i++)
		{
			int diff = target - numbers[i];
			if(!s.containsKey(diff))
				continue;
			int p = s.get(diff);
			
			if(p == i)
				continue;
			rs[0] = i+1;
			rs[1] = p+1;
			return rs;
		}
		
		return rs;
    }
}