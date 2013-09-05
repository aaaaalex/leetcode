public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s3.length()!= s1.length() + s2.length())
			return false;
			
		if(s1.length() == 0 && s2.length() == 0)
			return true;
		
		boolean[][] record = new boolean[s1.length()+1][s2.length()+1];
		
		record[0][0] = true;
		
		int curr = 0;
		
		for(int i = 0; i <= s1.length(); i++)
		{
			for(int j = 0; j <= s2.length(); j++)
			{
				char cs1;
				char cs2;
				
				if(i == 0 && j == 0)
					continue;
				
				char cs3 = s3.charAt(i+j - 1);
				if(i == 0)
				{
					cs2 = s2.charAt(j - 1);
					if(cs2 == cs3)
						record[i][j] = record[i][j-1];
					else
						record[i][j] = false;
					continue;
				}
				
				if(j == 0)
				{
					cs1 = s1.charAt(i-1);
					if(cs1 == cs3)
						record[i][j] = record[i-1][j];
					else
						record[i][j] = false;
					continue;
				}
				
				cs1 = s1.charAt(i-1);
				cs2 = s2.charAt(j-1);
				
				if(cs1 == cs2)
				{
					if(cs1 == cs3)
					{
						record[i][j] = record[i-1][j] || record[i][j-1]; 
					}
					else
					{
						record[i][j] = false;
					}
					continue;
				}
				
				if(cs1 == cs3)
				{
					record[i][j] = record[i-1][j];
					continue;
				}
				
				if(cs2 == cs3)
				{
					record[i][j] = record[i][j-1];
					continue;
				}
				
				record[i][j] = false;
			}
		}
		
		return record[s1.length()][s2.length()];
    }
}