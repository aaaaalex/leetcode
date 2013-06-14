public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int alen = a.length();
		int blen = b.length();
		int rslen = (alen > blen ? alen : blen);
		rslen++;
		
		int[] rs = new int[rslen];
		int next = 0;
		for(int i = rslen - 1; i >= 0; i--){
			alen--;
			blen--;
			int ae = (alen >= 0 ? (a.charAt(alen) - '0') : 0);
			int be = (blen >= 0 ? (b.charAt(blen) - '0') : 0);
			
			int curr = ae + be + next;
			if(curr >= 2){
				next = 1;
				curr = curr - 2;
			} else
				next = 0;
			rs[i] = curr;
		}
		
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < rslen; i++){
			st.append(rs[i]);
		}
		String result = st.toString();
		if(rs[0] == 0)
			result = result.substring(1);
		return result;
    }
}