package biweekly52;

public class q3 {
	// '#' = rock, '*' = obstacle, '.' = air
	public char[][] rotateTheBox(char[][] box) {
		int h = box.length;
		int w = box[0].length;
        char[][] res = new char[w][h];
        for (int i=0; i<box.length; i++) {
        	for (int j=0; j<box[i].length; j++) {
        		res[j][h-i-1] = box[i][j];
        	}
        }
        for (int i=0; i<res[0].length; i++) {
        	for (int j=res.length-1; j>=0; j--) {
        		if (res[j][i] == '#') {
        			int r = j+1;
        			while (r < res.length && res[r][i] == '.') {
        				res[r][i] = res[r-1][i];
        				res[r-1][i] = '.';
        				r++;
        			}
        		}
        	}
        }
        return res;
    }
}
