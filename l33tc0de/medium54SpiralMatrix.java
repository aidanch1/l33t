package l33tc0de;

import java.util.*;

public class medium54SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
        int row = 0;
        int col = 0;
        int counter = 0;
        int size = matrix.length * matrix[0].length;
        o: while (ans.size() < size) {
        	while (col < matrix[row].length - counter) {
            	ans.add(matrix[row][col]);
            	col++;
            	if (ans.size() == size) {
            		break o;
            	}
            }
            col--;
            row++;
            while (row < matrix.length - counter) {
            	ans.add(matrix[row][col]);
            	row++;
            	if (ans.size() == size) {
            		break o;
            	}
            }
            row--;
            col--;
            while (col >= counter) {
            	ans.add(matrix[row][col]);
            	col--;
            	if (ans.size() == size) {
            		break o;
            	}
            }
            col++;
            row--;
            while (row > counter) {
            	ans.add(matrix[row][col]);
            	row--;
            	if (ans.size() == size) {
            		break o;
            	}
            }
            row++;
            col++;
            counter++;
        }
        return ans;
    }
}
