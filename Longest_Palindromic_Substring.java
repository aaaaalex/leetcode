public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s == null || s.length() == 0)
			return "";
		
		if(s.length() == 0)
			return s;
		
		int recordstart = 0;
		int recordend = 0;
		int max = 0;
		
		for(int i = 0; i<s.length()- 1; i++)
		{
		//System.out.println("[ROUND COUNT] => "+i);
			char curr = s.charAt(i);
			int curri = i;
			boolean allthesame = false;
			//First look at center at the middle of two chars
			if(s.charAt(i+1) == curr)
			{
				//recordstart = i;
				//recordend = i+1;
				int j = 0;
				allthesame = true;
				while(j <= i)
				{
					//System.out.println("Currently checking middle => "+i+j);
					if(i+j+1 >= s.length())
					{
						//System.out.println("break when i = "+i+ " and j = "+ j);
						break;
					}
					if(s.charAt(i+j+1) != s.charAt(i-j))
						break;
					if(i+j+1 < s.length())
					{
						if(s.charAt(i+j) != s.charAt(i+j+1))
							allthesame = false;
					}
					j++;
				}
				j--;
				i = i+j;
				if(2*j + 2> max)
				{
					recordstart = curri - j;
					recordend = curri+j+1;
					max = 2*j+2;
				}
			}
			
			int tmp = i;
			
			if(allthesame)
			{
				while(i <= s.length() - 1)
				{
					//System.out.println("Currently checking allthesame => "+i);
					if(s.charAt(i) != s.charAt(curri))
						break;
					i++;
				}
				i--;
				if(max < i-curri + 1)
				{
					recordstart = curri;
					recordend = i;
					max = i - curri + 1;
				}
				
				int j = 0;
				while(true)
				{
					if(curri - j < 0 ||i+j >= s.length())
					{
						break;
					}
					if(s.charAt(i+j) != s.charAt(curri - j))
					{
						break;
					}
					j++;
				}
				j--;
				if(max < i+j - (curri - j) + 1)
				{
					recordstart = curri - j;
					recordend = i + j;
					max = i+j - (curri - j) + 1;
				}
				
				continue;
			}
			
			allthesame = true;
			
			if(tmp == 0 || tmp >= s.length() - 1)
				continue;
			
			if(s.charAt(tmp-1) == s.charAt(tmp+1))
			{
				int j = 0;
				while(j <= i)
				{
					//System.out.println("Currently checking element => "+i+j);
					if(i+j+1 > s.length())
						break;
					if(s.charAt(i - j) != s.charAt(i + j))
					{
						//System.out.println("Currently char 1 => "+s.charAt(i-j)+" AND char 2 => "+s.charAt(i+j));
						break;
					}
					if(i+j+1 < s.length())
					{
						if(s.charAt(i+j) != s.charAt(i+j+1))
							allthesame = false;
					}
					j++;
				}
				j--;
				
				//System.out.println("tmp => "+tmp);
				//System.out.println("j => "+j);
				
				if(2*j+1 > max)
				{
					recordstart = tmp-j;
					recordend = tmp+j;
					max = 2*j+1;
				}
			}
		}
		
		return s.substring(recordstart, recordend + 1);
    }
}