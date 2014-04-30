public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        for(int i = n; i >= 1; i--) {
            if(k == 1) {
                ArrayList<Integer> tmpList = new ArrayList<Integer> ();
                tmpList.add(i);
                res.add(tmpList);
            } else {
                ArrayList<ArrayList<Integer>> tmprs = combine(i-1, k-1);
                if(tmprs.size() > 0) {
                    for(ArrayList<Integer> rs : tmprs) {
                        rs.add(i);
                        res.add(rs);
                    }
                }
            }
        }
        
        return res;
    }
}