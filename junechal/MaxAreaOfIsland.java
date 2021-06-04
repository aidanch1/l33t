package junechal;

import java.util.*;

public class MaxAreaOfIsland {
	Set<point> visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new HashSet<point>();
        int max = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                point cur = new point(i, j);
                if (!visited.contains(cur) && grid[i][j] == 1) {
                    int size = 0;
                    Stack<point> tovisit = new Stack<>();
                    tovisit.push(cur);
                    visited.add(cur);
                    while (!tovisit.isEmpty()) {
                        point v = tovisit.pop();
                        size++;
                        if (v.row > 0 && grid[v.row-1][v.col] == 1 && 
                           !visited.contains(new point(v.row-1,v.col))) {
                            point t = new point(v.row-1,v.col);
                            tovisit.push(t);
                            visited.add(t);
                        }
                        if (v.row < grid.length-1 && grid[v.row+1][v.col] == 1 && 
                            !visited.contains(new point(v.row+1,v.col))) {
                            point t = new point(v.row+1,v.col);
                            tovisit.push(t);
                            visited.add(t);
                        }
                        if (v.col > 0 && grid[v.row][v.col-1] == 1 && 
                            !visited.contains(new point(v.row,v.col-1))) {
                            point t = new point(v.row,v.col-1);
                            tovisit.push(t);
                            visited.add(t);
                        }
                        if (v.col < grid[0].length-1 && grid[v.row][v.col+1] == 1 &&
                           !visited.contains(new point(v.row,v.col+1))) {
                            point t = new point(v.row,v.col+1);
                            tovisit.push(t);
                            visited.add(t);
                        }
                    }
                    max = Math.max(max,size);
                }
            }
        }
        return max;
    }
}
class point {
    int row;
    int col;
    public point(int a, int b) {
        this.row = a;
        this.col = b;
    }
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof point) {
            point other = (point) o;
            return this.row == other.row && this.col == other.col;
        }
        return false;
    }
    public String toString() {
        return this.row+","+this.col;
    }
}
