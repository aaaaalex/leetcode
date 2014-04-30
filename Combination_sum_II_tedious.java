public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return sumUp(num, target, 0);
    }
    
    public ArrayList<ArrayList<Integer>> sumUp(int[] num, int target, int p) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if(target < 0) {
            return res;
        }
        
        for(int i = p; i < num.length; i++) {
            if(target < num[i]) {
                break;
            }
            
            if(target == num[i]) {
                ArrayList<Integer> tmp = new ArrayList<Integer> ();
                tmp.add(num[i]);
                res.add(tmp);
                break;
            }
            
            int newP = i+1;
            while(newP < num.length){
                if(num[newP] != num[i]) {
                    break;
                }
                newP++;
            }
            int startPos = i;
            while(startPos <= (newP-1)) {
                if(target == (num[i]*(startPos-i+1))) {
                    ArrayList<Integer> tmp = new ArrayList<Integer> ();
                    for(int ii = 0; ii < (startPos-i+1); ii++) {
                        tmp.add(num[i]);   
                    }
                    res.add(tmp);
                    break;
                }
                
                ArrayList<ArrayList<Integer>> tmprs = sumUp(num, (target - num[i]*(startPos-i+1)), newP);
                for(int j = 0; j < tmprs.size(); j++) {
                    ArrayList<Integer> tmpList = tmprs.get(j);
                    for(int ii = 0; ii < (startPos-i+1); ii++) {
                        tmpList.add(0, num[i]);
                    }
                    res.add(tmpList);
                }
                startPos++;
            }
            i = newP-1;
        }
        
        return res;
    }
}