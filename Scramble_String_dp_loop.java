public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		//Has not figure it out, do it latter!!
		
		if(s1.length() != s2.length())
			return false;
		
		int len = s1.length();
		
		boolean[][][] records = new boolean[s1.length()+1][s1.length()][s1.length()];
		boolean[][][] ifTested = new boolean[s1.length()+1][s1.length()][s1.length()];
		
		for(int l = 1; l <= len; l++)
		{
			int currsize = len-l+1;
			for(int st1 = 0; st1 < currsize; st1++)
			{
				for(int st2 = 0; st2 < currsize; st2++)
				{
					if(l == 1)
					{
						records[1][st1][st2] = false;
						if(s1.charAt(st1) == s2.charAt(st2))
							records[1][st1][st2] = true;
					}
					else
					{
						records[l][st1][st2] = false;
						for(int l2 = 1; l2 < l; l2++)
						{
							int sl1 = l2;
							int sl2 = l - l2;
							if(records[sl1][st1][st2] && records[sl2][l2+st1][l2+st2])
							{
								records[l][st1][st2] = true;
								break;
							}
							if(records[sl1][st1][st2+l-l2] && records[sl2][st1+l2][st2])
							{
								records[l][st1][st2] = true;
								break;
							}
						}
					}
				}
			}
		}
		
		return records[len][0][0];
	}
}