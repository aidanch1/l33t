package l33tc0de;

import java.util.*;


public class hard51NQueens {
	public List<List<String>> solveNQueens(int n) {
        //place n queens on this n * n chessboard
		List<List<String>> ans = new ArrayList<>();
		ArrayList<HashSet<Integer>> taken = new ArrayList<>();
		for (int i=0; i<3; i++) {
			taken.add(new HashSet<Integer>()); // stores which columns and diagonals are taken
		}
		solve(n, taken, new ArrayList<Integer>(), ans);
		return ans;
    }
	public void solve(int n, ArrayList<HashSet<Integer>> taken, List<Integer> soFar, List<List<String>> solutions) {
		if (soFar.size() == n) {
			List<String> toadd = new ArrayList<String>();
			for (int i=0; i<n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j=0; j<soFar.get(i); j++) {
					sb.append('.');
				}
				sb.append('Q');
				for (int j=soFar.get(i)+1; j<n; j++) {
					sb.append('.');
				}
				toadd.add(sb.toString());
			}
			solutions.add(toadd);
		}
		for (int i=0; i<n; i++) {
			int row = soFar.size();
			if (!taken.get(0).contains(i) && !taken.get(1).contains(row+i) && !taken.get(2).contains(row-i)) {
				soFar.add(i);
				taken.get(0).add(i);
				taken.get(1).add(row+i);
				taken.get(2).add(row-i);
				solve(n, taken, soFar, solutions);
				soFar.remove(soFar.size()-1);
				taken.get(0).remove(i);
				taken.get(1).remove(row+i);
				taken.get(2).remove(row-i);
			}
		}
	}
}
