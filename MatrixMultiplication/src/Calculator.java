
public class Calculator {
	
	/**
	 * get the rowth, colth minor of the specified matrix.
	 * @param matrix 
	 * @param row 
	 * @param col 
	 * @return
	 */
	public int[][] minor(int[][] matrix, int row, int col){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		return removeRowAndCol(matrix, row, col);
	}
	
	/**
	 * recurse with n-1xn-1 matrix
	 * base case: 2 by 2 matrix
	 * @param matrix the matrix to get the determinant of
	 * @return
	 */
	public int determinant(int[][] matrix){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		if(matrix.length == 2){
			return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
		}
		
		int sign = 1;
		int total = 0;
		for(int i = 0; i < matrix[0].length; i++){
			total += sign * matrix[0][i] * determinant(removeRowAndCol(matrix, 0, i));
			sign*= -1;
		}
		
		return total;
	}
	
	/**
	 * Scalar multiplication of a matrix. Works by mutating the array that is passed in.
	 * @param matrix
	 * @param scalar
	 * @return
	 */
	public void multiply(int[][] matrix, int scalar){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				matrix[i][j]*= scalar;
			}
		}
	}
	
	/**
	 * multiplies two matrices together
	 * @param a
	 * @param b
	 * @return a multiplied by b
	 */
	public int[][] multiply(int[][] a, int[][] b){
		//preconditions
		if(a == null)throw new IllegalArgumentException("a must not be null");
		if(b == null)throw new IllegalArgumentException("b must not be null");
		for(int i = 0; i < a.length; i++){
			if(a.length != a[i].length)throw new IllegalArgumentException("a must be square!");
		}
		
		for(int i = 0; i < b.length; i++){
			if(b.length != b[i].length)throw new IllegalArgumentException("b must be square!");
		}
		
		if(a.length != b.length)throw new IllegalArgumentException("a and b must be the same size");
		
		int[][] newMatrix = new int[a.length][a.length];
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				for(int k = 0; k < a.length; k++){
					newMatrix[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		
		return newMatrix;
	}
	
	/**
	 * transposes the input matrix such that the rows become the cols and vice versa
	 * @param a
	 * @return
	 */
	public int[][] transpose(int[][] matrix){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		int[][] newMatrix = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				newMatrix[j][i] = matrix[i][j];
			}
		}
		
		return newMatrix;
	}
	
	/**
	 * calculates the adjoint of a
	 * @param a
	 * @return
	 */
	public int[][] adjoint(int[][] matrix){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		int[][] newMatrix = new int[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				newMatrix[i][j] = (int)Math.pow(-1, i+j) * determinant(minor(matrix, i, j));
			}
		}
				
		return newMatrix;
	}
	
	/**
	 * Helper method
	 * @param matrix
	 * @param row the row to remove
	 * @param col the column to remove
	 * @return
	 */
	private int[][] removeRowAndCol(int[][] matrix, int row, int col){
		//preconditions
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		if(matrix.length <= 2)throw new IllegalArgumentException("matrix must be at least 3x3");
		
		int[][] newMatrix = new int[matrix.length-1][matrix.length-1];
		for(int i = 0, ni = 0; i < matrix.length; i++){
			
			if(i != row){
				for(int j = 0, nj = 0; j < matrix.length; j++){
					if(j != col){
						newMatrix[ni][nj] = matrix[i][j];
						nj++;
					}
				}
				ni++;
			}
		}
		return newMatrix;
	}
}
