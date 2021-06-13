package biweekly54;

public class q3 {
	public int largestMagicSquare(int[][] grid) {
        //try each location as a top left corner for ms
        int best = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                int radius = 1;
                while (i+radius<grid.length && j+radius<grid[i].length) {
                    if (radius>best && isMS(i,j,radius,grid)) {
                        best = radius;
                    }
                    radius++;
                }
            }
        }
        return best+1;
    }
    public boolean isMS(int row, int col, int r, int[][] grid) {
        int total = 0;
        for (int i=row; i<=row+r; i++) {
            total+=grid[i][col];
        }
        for (int i=row; i<=row+r; i++) {
            int rowsum = 0;
            for (int j=col; j<=col+r; j++) {
                rowsum += grid[i][j];
            }
            if (rowsum != total) {
                return false;
            }
        }
        for (int j=col; j<=col+r; j++) {
            int colsum = 0;
            for (int i=row; i<=row+r; i++) {
                colsum += grid[i][j];
            }
            if (colsum != total) {
                return false;
            }
        }
        int diagsum = 0;
        int diagsum2 = 0;
        for (int i=0; i<=r; i++) {
            diagsum += grid[row+i][col+i];
            diagsum2 += grid[row+i][col+r-i];
        }
        if (diagsum != total || diagsum2 != total) {
            return false;
        }
        return true;
    }
}
