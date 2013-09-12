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
		
		if(intervals == null || intervals.isEmpty())
			return rs;
		Comparator<Interval> comparator = new Comparator<Interval> ()
		{
			@Override
			public int compare(Interval i1, Interval i2)
			{
				if(i1.start < i2.start)
					return -1;
				if(i1.start > i2.start)
					return 1;
				if(i1.end < i2.end)
					return -1;
				if(i1.end > i2.end)
					return 1;
				return 0;
			}
		};
		
		Collections.sort(intervals, comparator);
		
		for(Interval curr : intervals)
		{
			int i = rs.size();
			if(i == 0)
			{
				rs.add(curr);
				continue;
			}
			Interval tmp = rs.get(i-1);
			if(tmp.end < curr.start)
			{
				rs.add(curr);
				continue;
			}
			int s = Math.min(tmp.start, curr.start);
			int e = Math.max(tmp.end, curr.end);
			rs.set(rs.size()-1, new Interval(s, e));	
		}
		
		return rs;
	}
}