public class Solution {
  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int m = 0;
    int n = 0;
    ArrayList<Integer> re = new ArrayList<Integer>();
    if(matrix.length == 0){
        return re;
    }
    else{
        m = matrix.length;
        n = matrix[0].length;
    }
    spiral(matrix, m, n, 0, re);
    return re;
}

public void spiral(int[][] matrix, int r, int c, int k, ArrayList<Integer> result){
    if(r==0 || c == 0){
        return;
    }
    if(r==1){
        for(int i = 0; i < c; i++){
            result.add(matrix[k][i+k]);
        }
        return;
    }
    if(c==1){
        for(int i = 0; i < r; i++){
            result.add(matrix[i+k][k]);
        }
        return;
    }

    for(int i = 0; i < c-1; i++){
        result.add(matrix[k][i+k]);
    }
    for(int i = 0; i < r-1; i++){
        result.add(matrix[i+k][k+c-1]);
    }
    for(int i = c-1; i > 0; i--){
        result.add(matrix[k+r-1][k+i]);
    }
    for(int i = r-1; i > 0; i--){
        result.add(matrix[i+k][k]);
    }

    spiral(matrix, r-2, c-2, k+1, result);
}
}