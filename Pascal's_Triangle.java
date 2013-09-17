public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		
		for(int i = 0; i < numRows; i++)
		{
			ArrayList<Integer> t = new ArrayList<Integer> ();	
			if(i >= 1)
			{
				t.add(1);
				int c = 0;
				ArrayList<Integer> tmp = rs.get(i-1);
				for(int j = 0; j < i-1; j++)
				{
					int curr = tmp.get(c)+tmp.get(c+1);
					t.add(curr);
					c++;
				}
			}
			t.add(1);
			rs.add(t);
		}
		return rs;
    }
	
}