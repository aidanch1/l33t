package weekly246;

public class q3 {
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int[][] g1 = new int[m][n];
        fill(g1,-1);
        int id = 1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (g1[i][j] == -1 && grid1[i][j] == 1) {
                    flood(g1, grid1, i, j, id);
                    id++;
                }
            }
        }
        int[][] g2 = new int[m][n];
        fill(g2,-1);
        id = 1;
        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (g2[i][j] == -1 && grid2[i][j] == 1) {
                    Stack<Integer> st = new Stack<>();
                    st.push(i);
                    st.push(j);
                    boolean sub = true;
                    int check = g1[i][j];
                    while (!st.isEmpty()) {
                        int c = st.pop();
                        int r = st.pop();
                        g2[r][c] = id;
                        if (g1[r][c] != check || g1[r][c] == -1) {
                            sub = false;
                        }
                        if (r > 0 && grid2[r-1][c] == 1 && g2[r-1][c] == -1) {
                            st.push(r-1);
                            st.push(c);
                        }
                        if (r < grid2.length-1 && grid2[r+1][c] == 1 && g2[r+1][c] == -1) {
                            st.push(r+1);
                            st.push(c);
                        }
                        if (c > 0 && grid2[r][c-1] == 1 && g2[r][c-1] == -1) {
                            st.push(r);
                            st.push(c-1);
                        }
                        if (c < grid2[0].length-1 && grid2[r][c+1] == 1 && g2[r][c+1] == -1) {
                            st.push(r);
                            st.push(c+1);
                        }
                    }
                    if (sub) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public void flood(int[][] t, int[][] grid, int r, int c, int id) {
        t[r][c] = id;
        if (r > 0 && grid[r-1][c] == 1 && t[r-1][c] == -1) {
            flood(t, grid, r-1, c, id);
        }
        if (r < grid.length-1 && grid[r+1][c] == 1 && t[r+1][c] == -1) {
            flood(t, grid, r+1, c, id);
        }
        if (c > 0 && grid[r][c-1] == 1 && t[r][c-1] == -1) {
            flood(t, grid, r, c-1, id);
        }
        if (c < grid[0].length-1 && grid[r][c+1] == 1 && t[r][c+1] == -1) {
            flood(t, grid, r, c+1, id);
        }
    }
    public void fill(int[][] grid, int val) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                grid[i][j] = val;
            }
        }
    }
}
