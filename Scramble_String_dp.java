public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s1.length() != s2.length())
			return false;
		
		boolean[][][] records = new boolean [s1.length()+1][s1.length()][s1.length()];
		int[][][] ifTested = new int [s1.length()+1][s1.length()][s1.length()];
		
		records[0][0][0] = true;
		ifTested[0][0][0] = 1;
		
		return solve(s1, s2, records, ifTested, s1.length(), 0, 0);
	}
	
	public static boolean solve(String s1, String s2, boolean[][][] records, int[][][] ifTested, int len, int st1, int st2)
	{
		if(len == 0)
			return true;
	
		if(ifTested[len][st1][st2] > 0)
		{
			if(records[len][st1][st2])
				return true;
			return false;
		}
		
		if(len == 1)
		{
			ifTested[len][st1][st2] = 1;
			if(s1.charAt(st1) == s2.charAt(st2))
			{
				records[len][st1][st2] = true;
			}
			else
			{
				records[len][st1][st2] = false;
			}
			return records[len][st1][st2];
		}
		
		if(!check(s1, s2, len, st1, st2))
			return false;
		
		for(int i = 1; i < len; i++)
		{
		    if(solve(s1, s2, records, ifTested, i, st1, st2) && solve(s1, s2, records, ifTested, len-i, i+st1, i+st2))
				return true;
		
			if(solve(s1, s2, records, ifTested, i, st1, len-i+st2) && solve(s1, s2, records, ifTested, len-i, i+st1, st2))
				return true;
		}
		return false;
	}
	
	public static boolean check(String s1, String s2, int len, int st1, int st2)
	{
		int[] r1 = new int[26];
		int[] r2 = new int[26];
		for(int i = 0; i < len; i++)
		{
			r1[s1.charAt(st1+i)-'a']++;
			r2[s2.charAt(st2+i)-'a']++;
		}
		
		for(int i = 0; i < 26; i++)
		{
			if(r1[i] != r2[i])
				return false;
		}
		return true;
	}
}