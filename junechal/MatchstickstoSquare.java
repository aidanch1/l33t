package junechal;

public class MatchstickstoSquare {
	boolean[] vis;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        vis = new boolean[16];
        for (int i:matchsticks) {
            sum+=i;
        }
        if (sum%4 != 0) {
            return false;
        }
        return dfs(matchsticks,0,sum/4,4,0);
    }
    public boolean dfs(int[] matchsticks, int sum, int target, int sides, int index) {
        if (sides == 1) {
            return true;
        }
        else if (sum == target) {
            return dfs(matchsticks, 0, target, sides-1, 0);
        }
        for (int i=index; i<matchsticks.length; i++) {
            if (!vis[i] && sum+matchsticks[i]<=target) {
                vis[i] = true;
                if (dfs(matchsticks,sum+matchsticks[i],target,sides,i+1)) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
