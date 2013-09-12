/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
   public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Interval> rs = new ArrayList<Interval> ();
		for(Interval curr : intervals)
		{
			int i = rs.size()-1;
			if(i < 0)
			{
				rs.add(curr);
				continue;
			}
			
			while(true)
			{
				if(i < 0)
					break;
				Interval tmp = rs.get(i);
				if(tmp.end <= curr.end)
				{
					break;
				}
				i--;
			}
			int j = i;
			while(true)
			{
				if(j < 0)
					break;
				Interval tmp = rs.get(j);
				if(tmp.start <= curr.start)
					break;
				j--;
			}
			if(i < 0)
			{
				Interval tmp = rs.get(0);
				if(tmp.start > curr.end)
				{
					rs.add(0, curr);
					continue;
				}
				int s = Math.min(curr.start, tmp.start);
				int e = Math.max(curr.end, tmp.end);
				rs.set(0, new Interval(s, e));
				continue;
			}
			if(j < 0)
			{
				Interval tmp1 = rs.get(i);
				Interval tmp2 = rs.get(0);
				
				int s = Math.min(curr.start, tmp1.start);
				int e = Integer.MIN_VALUE;
				if(i+1 < rs.size())
				{
					Interval tmp3 = rs.get(i+1);
					if(tmp3.start <= curr.end)
					{
						e = tmp3.end;
						i = i+1;
					}
				}
				e = Math.max(curr.end, Math.max(e, tmp2.end));
				rs.subList(0, i+1).clear();
				rs.add(0, new Interval(s, e));
				continue;
			}
			Interval tmp1 = rs.get(i);
			Interval tmp2 = rs.get(j);
			
			int s = curr.start;
			int e = curr.end;
			
			if(i+1 < rs.size())
			{
				Interval tmp3 = rs.get(i+1);
				if(tmp3.start <= curr.end)
				{
					e = tmp3.end;
					i++;
				}
			}
			
			if(tmp2.end < curr.start)
			{
				s = curr.start;
				if(j+1 <= i && j+1 < rs.size())
				{
					s = Math.min(s, rs.get(j+1).start);
				}
				j++;
			}
			else
			{
				s = tmp2.start;
			}
			
			if(i < j)
			{
				rs.add(j, new Interval(s, e));
				continue;
			}
			
			rs.subList(j, i+1).clear();
			/* if(j==0)
				rs.add(new Interval(s, e));
			else */
				rs.add(j, new Interval(s, e));
		}
		
		return rs;
    }
}