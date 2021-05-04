package l33tc0de;

import java.util.*;

public class medium6zigzagConversion {
	public static String convert(String s, int numRows) {
		if (numRows==1) {
			return s;
		}
        char[][] t = new char[numRows][s.length()];
        char[] c = s.toCharArray();
        boolean down = true;
        int row = 0;
        int col = 0;
        for (int i=0; i<c.length; i++) {
        	if (down) {
        		t[row][col] = c[i];
        		row++;
        		if (row == numRows) {
        			down = false;
        			row-=2;
        			if (row == 0) {
        				down = true;
        			}
        			col++;
        		}
        	}
        	else {
        		t[row][col] = c[i];
        		row--;
        		col++;
        		if (row == 0) {
        			down = true;
        		}
        	}
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<t.length; i++) {
        	for (int j=0; j<t[i].length; j++) {
        		if ((int) t[i][j] != 0) {
        			ans.append(t[i][j]);
        		}
        	}
        }
        return ans.toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("ABCD",2));
	}
}
