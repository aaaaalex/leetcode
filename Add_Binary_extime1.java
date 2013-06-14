public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int alen = a.length();
		int blen = b.length();
        int rslen = alen;
		if(blen > rslen)
			rslen = blen;
		rslen++;
		int[] rs = new int[rslen];
		for(int i = 0; i < rslen; i++){
			rs[i] = 0;
		}
		int next = 0;
		String result;
		for(int i = rslen-1; i >= 0; i--){
			alen--;
			blen--;
			int ae = 0;
			int be = 0;
			
			if(alen >= 0)
				ae = (a.charAt(alen) - '0');
			
			if(blen >= 0)
				be = (b.charAt(blen) - '0');
			
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
		result = st.toString();
		if(rs[0] == 0){
			result = result.substring(1);
		}
		
		return result;
		
    }
}