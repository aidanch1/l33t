package weekly245;

import java.util.*;

public class q4 {
	//care about # players before 1st player # players between them and # players after 2nd player
    Map<State, int[]> m; // state : moves
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        m = new HashMap<>();
        return solve(new State(firstPlayer-1,secondPlayer-firstPlayer-1,n-secondPlayer));
    }
    public int[] solve(State s) {
        if (s.beforeFirst == s.afterSecond) {
            int[] ans = new int[] {1,1};
            m.put(s, ans);
            return ans;
        }
        else if (m.containsKey(s)) {
            return m.get(s);
        }
        int toRemove = s.totalPlayers()/2;
        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;
        for (int i=0; i<toRemove; i++) {
            //make first i players lose
            int bf = s.beforeFirst;
            int bt = s.between;
            int as = s.afterSecond;
            bf -= i;
            if (bf < 0) {
                bt += bf;
                bf = 0;
            }
            if (bt < 0) {
                as += bt;
                bt = 0;
            }
            as -= (toRemove-i);
            if (as < 0) {
                bt += as;
                as = 0;
            }
            if (bt < 0) {
                bf += bt;
                bt = 0;
            }
            if (s.totalPlayers()%2 == 1 && (s.totalPlayers()+1)/2 != s.beforeFirst+1 && (s.totalPlayers()+1)/2 != s.beforeFirst+s.between+2) {
                int a = (s.totalPlayers()+1)/2;
                if (a < s.beforeFirst && bf == 0) {
                    bf++;
                    bt--;
                    if (bt < 0) {
                        as += bt;
                        bt = 0;
                    }
                }
                else if (a < s.beforeFirst+2+s.between && bt == 0) {
                    bt++;
                    if (bf == 0) {
                        as--;
                    }
                    else {
                        bf--;
                    }
                }
                else if (as == 0){
                    as++;
                    bt--;
                    if (bt < 0) {
                        bf += bt;
                        bt = 0;
                    }
                }
            }
            int[] t = solve(new State(bf, bt, as));
            earliest = Math.min(earliest, t[0]+1);
            latest = Math.max(latest, t[1]+1);
        }
        return new int[] {earliest, latest};
    }
}
class State {
    int beforeFirst;
    int between;
    int afterSecond;
    public State(int a, int b, int c) {
        beforeFirst = a;
        between = b;
        afterSecond = c;
    }
    public int totalPlayers() {
        return 2+beforeFirst+between+afterSecond;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof State) {
            State o = (State) other;
            return this.beforeFirst == o.beforeFirst && this.between == o.between && this.afterSecond == o.afterSecond;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return beforeFirst*10000+between*100+afterSecond;
    }
}