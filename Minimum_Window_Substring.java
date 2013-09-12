public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(S == null || S.length() == 0)
			return "";
		
		LinkedList<Integer> pos = new LinkedList<Integer> ();
		LinkedList<Character> posrec = new LinkedList<Character> ();
		int[] count = new int[256];
		HashSet<Character> prob = new HashSet<Character> ();
		int c = 0;
		int start = -1;
		int end = -1;
		int dis = Integer.MAX_VALUE;
		
		for(int i = 0; i<T.length(); i++)
		{
			prob.add(new Character(T.charAt(i)));
			count[(int)T.charAt(i)]++;
		}
		
		for(int i = 0; i < S.length(); i++)
		{
			Character curr = new Character(S.charAt(i));
			if(prob.add(curr))
			{
				//Not a target
				prob.remove(curr);
				continue;
			}
			
			//Find a target
			if(count[(int)curr] == 0)
			{
				//need to replace
				int listPos = posrec.indexOf(curr);
				//int p = pos.indexOf(listPos);
				pos.remove(listPos);
				pos.offer(i);
				posrec.remove(listPos);
				posrec.offer(curr);

				if(c < T.length())
					continue;
				
				int s = pos.getFirst();
				int e = pos.getLast();
				
				if(dis > e-s+1)
				{
					start = s;
					end = e;
					dis = e-s+1;
				}
			}
			else
			{
				//First time get a target
				pos.offer(new Integer(i));
				posrec.offer(curr);
				
				count[(int)curr]--;
				
				c++;
				
				if(start == -1)
					start = i;
				if(c == T.length())
				{
					start = pos.getFirst();
					end = i;
					dis = end - start + 1;
				}
			}
		}
		
		if(start == -1 || end == -1)
			return "";
		
		return S.substring(start, end+1);
		
    }
}