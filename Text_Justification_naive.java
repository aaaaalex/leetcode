public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<String> rs = new ArrayList<String> ();
		
        if(words == null || words.length == 0)
			return rs;
		fill(words, rs, 0, L);
		
		return rs;
    }
	
	public void fill(String[] words, ArrayList<String> rs, int p, int L)
	{
		if(p >= words.length)
			return;
			
		int c = 0;
		int i = 0;
		int lc = 0;
		for(i = p; i < words.length; i++)
		{
			String curr = words[i];
			if(c == 0)
			{
				if(curr.length() + lc <= L)
				{
					lc = curr.length() + lc;
					c++;
				}
				else
					break;
				continue;
			}
			if(curr.length() + lc + 1 <= L)
			{
				lc = curr.length() + 1 + lc;
				c++;
			}
			else
				break;
		}
		
		int diffl = L - lc;
		//Then start to fill into empty spaces
		if(c == 0)
		{
			//In this case, no word selected which means the word cannot fit in any line which is an error
			return;
		}
		if(c == 1)
		{
			String r = "";
			r = r + words[p];
			while(diffl > 0)
			{
				r = r + " ";
				diffl--;
			}
			rs.add(r);
			fill(words, rs, i, L);
			
		}
		else
		{
			if(i < words.length)
			{
				String r = words[p];
				int intervals = c-1;
				int addint = (diffl)%intervals;
				int perint = (diffl-addint)/intervals;
				for(int ii = 1; ii < c; ii++)
				{
					r = r+ " ";
					if(addint > 0)
					{
						addint--;
						r = r+" ";
					}
					for(int j = 0; j < perint; j++)
						r = r+" ";
					r = r + words[p+ii];
				}
				rs.add(r);
				fill(words, rs, i, L);
			}
			else
			{
				String r =  words[p];
				for(int ii = 1; ii < c; ii++)
				{
					r = r + " " +words[p+ii];
				}
				for(int ii = 0; ii < diffl; ii++)
				{
					r = r+" ";
				}
				rs.add(r);
				fill(words, rs, i, L);
			}
		}
		
	}
	
}