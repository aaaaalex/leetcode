public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		int start = -1;
		int end = -1;
		int rsstart=0;
		int rsend = 0;
		int dis = Integer.MAX_VALUE;
		int c = 0;
		
		int[] prob = new int[256];
		int[] count = new int[256];
		
		for(int i = 0;i<T.length(); i++)
		{
			prob[T.charAt(i)]=1;
			count[T.charAt(i)]++;
		}
		
		for(int i = 0; i<S.length(); i++)
		{
			Character curr = new Character(S.charAt(i));
			
			//If it's not target
			if(prob[curr] == 0)
				continue;
				
			//If it is the first time come in
			if(count[curr] > 0)
			{
				if(start == -1) start = i;
				c++;
				count[curr]--;
				if(c == T.length())
				{
					end = i;
					rsstart = start;
					rsend = end;
					dis = end-start+1;
				}
				continue;
			}
			
				//If it is to replace a found char
				//Check if it is the start char
				
				if(curr == S.charAt(start))
				{
					int tmp = start+1;
					while(true)
					{
						Character currtmp = new Character(S.charAt(tmp));
						if(prob[currtmp] == 0)
						{
							tmp++;
							continue;
						}	

						int tmpcount = count[currtmp];
						if(tmpcount >= 0)
							break;
						count[currtmp]++;
						tmp++;
					}
					
					start = tmp;
					if(c == T.length())
						end = i;
					if(c == T.length() && dis > i - tmp + 1)
					{
						rsstart = tmp;
						rsend = i;
						dis = rsend - rsstart + 1;
					}
					continue;
				}
				count[curr]--;
		}
		
		
		return (c != T.length()? "" : S.substring(rsstart, rsend+1));
		//The following is a faster return statement
		//return (end==-1 ? "" : S.substring(rsstart, rsend+1));
    }
}