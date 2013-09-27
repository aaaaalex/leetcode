public class Solution {
    public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		r(matrix, matrix.length, 0);
	}
	public void r(int[][] matr, int n, int k){
		if(n==0 || n==1){
			return;
		}

		for(int j = 0; j < n-1; j++){
			int temp = matr[k][j+k];
			matr[k][j+k] = matr[n-j-1+k][k];
			matr[n-j-1+k][k] = matr[n-1+k][n-j-1+k];
			matr[n-1+k][n-j-1+k] = matr[j+k][n-1+k];
			matr[j+k][n-1+k] = temp;
		}
		r(matr, n-2, k+1);
	}
}