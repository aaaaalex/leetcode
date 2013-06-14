public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, Integer> rsmap = new HashMap<String, Integer> ();
		ArrayList<String> result = new ArrayList<String> ();
		ArrayList<String> tmprs = new ArrayList<String> ();
		
		for(String str : strs){
			//ArrayList<Integer> tmp = new ArrayList<Integer> (26);
			int[] tmpar = new int[26];
			for(int i = 0; i < str.length(); i++){
				int p = str.charAt(i) - 'a';
				tmpar[p] = tmpar[p]+1;
			}
			StringBuilder st = new StringBuilder ();
			for(int i = 0; i < 26; i++){
				while(tmpar[i] > 0){
					st.append('a'+i);
					tmpar[i]--;
				}
			}
			String tmp = st.toString();
			
			if(rsmap.get(tmp) != null){
				int c = rsmap.get(tmp);
				rsmap.put(tmp, c+1);
			} else {
				rsmap.put(tmp, 1);
			}
			
			tmprs.add(tmp);
		}
		
		for(int i = 0; i < strs.length; i++){
			if(rsmap.get(tmprs.get(i)) > 1)
				result.add(strs[i]);
		}
		return result;
    }
}