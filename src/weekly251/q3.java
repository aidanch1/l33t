package weekly251;

import java.util.*;

public class q3 {
	int ans;
    int[][] match;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        match = new int[m][m];
        for (int i=0; i<m; i++) {
            for (int k=0; k<m; k++) {
                int score = 0;
                for (int j=0; j<n; j++) {
                    if (students[i][j] == mentors[k][j]) {
                        score++;
                    }
                }
                match[i][k] = score;
            }
        }
        ans = 0;
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<m; i++) {
            l.add(i);
        }
        perm(l, 0);
        return ans;
    }
    public void perm(List<Integer> l, int sum) {
        if (l.size() == 0) {
            if (sum > ans) {
                ans = sum;
            }
            return;
        }
        for (int i=0; i<l.size(); i++) {
            int t = l.remove(i);
            int s = match[l.size()][t];
            perm(l, sum+s);
            l.add(i, t);
        }
    }
}