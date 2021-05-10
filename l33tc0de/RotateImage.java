package l33tc0de2;

public class RotateImage {
	public void rotate(int[][] matrix) {
		//n * n matrix
		int n = matrix.length;
		for (int i=0; i<n/2; i++) {
			//rotate ith layer
			rotateLayer(matrix, i);
		}
    }
	public void rotateLayer(int[][] matrix, int layer) {
		int len = matrix.length-layer*2;
		//boundaries of a layer = layer -> matrix.length - layer
		for (int i=0; i<len-1; i++) {
			int r = layer;
			int c = i + layer;
			int nextr = i + layer;
			int nextc = len-1 + layer;
			int nextnextr = len-1 + layer;
			int nextnextc = len-1-i + layer;
			int nextnextnextr = len-1-i + layer;
			int nextnextnextc = layer;
			int s0 = matrix[r][c];
			int s1 = matrix[nextr][nextc];
			int s2 = matrix[nextnextr][nextnextc];
			int s3 = matrix[nextnextnextr][nextnextnextc];
			matrix[nextr][nextc] = s0;
			matrix[nextnextr][nextnextc] = s1;
			matrix[nextnextnextr][nextnextnextc] = s2;
			matrix[r][c] = s3;
		}
	}
}
