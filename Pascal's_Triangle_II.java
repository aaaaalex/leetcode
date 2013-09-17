public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> rs = new ArrayList<Integer> ();
		
		for(int i = 0; i <= rowIndex; i++)
		{
			if(i == 0)
				rs.add(1);
			else
			{
				ArrayList<Integer> tmp = new ArrayList<Integer> ();
				tmp.add(1);
				int c = 0;
				for(int j = 0; j < i-1; j++)
				{
					tmp.add(rs.get(c) + rs.get(c+1));
					c++;
				}
				tmp.add(1);
				rs = tmp;
			}
		}
		return rs;
    }
}