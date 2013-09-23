public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(s == null || s.length() == 0)
			return 0;
        HashMap<Character, Integer> records = new HashMap<Character, Integer> ();
		records.put('I', 1);
		records.put('V', 5);
		records.put('X', 10);
		records.put('L', 50);
		records.put('C', 100);
		records.put('D', 500);
		records.put('M', 1000);
		
		int preval = Integer.MIN_VALUE;
		int valrs = 0;
		String rs = "";
		
		for(int i = s.length()-1; i>=0; i--)
		{
			Character currChar = s.charAt(i);
			
			if(records.get(currChar) > preval)
			{
				//it means a string could be put as a number
				valrs = valrs+solve(rs, records);
				rs = "";
			}
			rs = currChar+rs;
			preval = records.get(currChar);
		}
		
		valrs = valrs + solve(rs, records);
		
		return valrs;
    }
	
	public static int solve(String s, HashMap<Character, Integer> records)
	{
		if(s == null || s.length() == 0)
			return 0;
		
		int preval = Integer.MIN_VALUE;
		boolean isMinus = false;
		int rs = 0;
		for(int i = s.length()-1; i>=0; i--)
		{
			Character curr = s.charAt(i);
			if(records.get(curr) < preval)
			{
				isMinus = true;
			}
			
			if(isMinus)
			{
				rs = rs - records.get(curr);
			}	
			else
			{
				rs = rs + records.get(curr);
			}
			
			preval = records.get(curr);
		}
		return rs;
	}
}