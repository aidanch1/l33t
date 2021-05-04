package biweekly18;

import java.util.*;

public class q3 {
	public int[][] diagonalSort(int[][] mat) {
        for (int i=0; i<mat.length; i++) {
        	int[] t = new int[Math.min(i+1,mat[0].length)];
        	for (int j=0; j<i+1; j++) {
        		if (j == mat[0].length) {
        			break;
        		}
        		t[j] = mat[mat.length-1-i+j][j];
        	}
        	Arrays.sort(t);
        	for (int j=0; j<i+1; j++) {
        		if (j == mat[0].length) {
        			break;
        		}
        		mat[mat.length-1-i+j][j] = t[j];
        	}
        }
        for (int i=0; i<mat[0].length; i++) {
        	int[] t = new int[Math.min(i+1, mat.length)];
        	for (int j=0; j<i+1; j++) {
        		if (j == mat.length) {
        			break;
        		}
        		t[j] = mat[j][mat[0].length-1-i+j];
        	}
        	Arrays.sort(t);
        	for (int j=0; j<i+1; j++) {
        		if (j == mat.length) {
        			break;
        		}
        		mat[j][mat[0].length-1-i+j] = t[j];
        	}
        }
        return mat;
    }
}
