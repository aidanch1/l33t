package l33tc0de;

import java.util.*;

public class medium39CombinationSum {
	//similar to coins problem from cse 143
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates,0,new ArrayList<Point>(),target,ans);
        return ans;
    }
	public void solve(int[] candidates, int index, List<Point> soFar, int target, List<List<Integer>> ans) {
		if (target == 0) {
			List<Integer> toadd = new ArrayList<>();
			for (Point p:soFar) {
				for (int i=0; i<p.multiplier; i++) {
					toadd.add(p.num);
				}
			}
			ans.add(toadd);
			return;
		}
		if (index >= candidates.length) {
			return;
		}
		int i=0;
		while (candidates[index]*i <= target) {
			soFar.add(new Point(candidates[index], i));
			solve(candidates,index+1,soFar,target-candidates[index]*i,ans);
			soFar.remove(soFar.size()-1);
			i++;
		}
	}
}
class Point {
	int num;
	int multiplier;
	public Point(int a, int b) {
		num = a;
		multiplier = b;
	}
}
