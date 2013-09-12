//THIS IS A WRONG METHOD!!!

public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(S.length() == 0 || T.length() == 0)
			return "";
		
        HashMap<Character, Integer> record = new HashMap<Character, Integer> ();
		HashMap<Character, Integer> prec = new HashMap<Character, Integer> ();
		HashMap<Character, Integer> probcount = new HashMap<Character, Integer> ();
		HashM<Character> prob = new HashSet<Character> ();
		LinkedList<Integer> pos = new LinkedList<Integer> ();

		int c = 0;
		int dis = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		for(int i = 0; i < T.length(); i++)
		{
			prob.add(new Character(T.charAt(i)));
			int tmpc = probcount.get(new Character(T.charAt(i)));
			if(tmpc == null)
				probcount.put(new Character(T.charAt(i)), new Integer(i));
			else
				probcount.put(new Character(T.charAt(i)), tmpc+1);
		}
		
		for(int i = 0; i < S.length(); i++)
		{
			Character curr = new Character(S.charAt(i));
			if(prob.add(curr))
			{
				prob.remove(curr);
				continue;
			}
			
			if(record.get(curr) == null)
			{
				//Previouslly not found
				c++;
				pos.offer(new Integer(i));
				record.put(curr, new Integer(i));
				if(start == -1)
					start = i;
				if(c == T.length())
				{
					/* int s = pos.getFirst();
					int e = pos.getLast();
					
					if(dis > e-s+1)
					{
						start = s;
						end = e;
						dis = end - start + 1;
					} */
					end = i;
					dis = end - start + 1;
				}
			}
			else
			{
				int firstPos = pos.peek();
				Character firstChar = S.charAt(firstPos);
				if(firstChar == curr)
				{
					pos.poll();
					pos.offer(new Integer(i));
					record.remove(curr);
					record.put(curr, new Integer(i));
					
					int s = pos.getFirst();
					int e = pos.getLast();
					if(dis > e-s+1)
					{
						start = s;
						end = e;
						dis = end-start+1;
					}
				}
				else
				{
					int prepos = record.get(curr);
					int listpos = pos.indexOf(prepos);
					pos.remove(listpos);
					pos.offer(new Integer(i));
					record.remove(curr);
					record.put(curr, new Integer(i));
				}
			}
		}
		if(start == -1 || end == -1)
			return "";
		
		return S.substring(start, end+1);
    }
}