package junechal;

import java.util.*;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
        HashSet<String> de = new HashSet<>();
        for (String s:deadends) {
            de.add(s);
        }
        if (de.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        HashMap<String, Integer> possible = new HashMap<>(); // possible code : moves it takes
        Queue<LockState> toexplore = new LinkedList<>();
        toexplore.add(new LockState("0000",0));
        while (!toexplore.isEmpty()) {
            LockState c = toexplore.poll();
            possible.put(c.state,c.moves);
            for (int i=0; i<4; i++) {
                String t1 = increment(c.state,i);
                if (t1.equals(target)) {
                    return c.moves+1;
                }
                else if (!de.contains(t1) && !possible.containsKey(t1)) {
                    possible.put(t1,c.moves+1);
                    toexplore.add(new LockState(t1,c.moves+1));
                }
                String t2 = decrement(c.state,i);
                if (t2.equals(target)) {
                    return c.moves+1;
                }
                else if (!de.contains(t2) && !possible.containsKey(t2)) {
                    possible.put(t2,c.moves+1);
                    toexplore.add(new LockState(t2,c.moves+1));
                }
            }
        }
        return -1;
    }
    public String increment(String s, int index) {
        int a = s.charAt(index)-'0';
        a = (a+1)%10;
        return s.substring(0,index)+a+s.substring(index+1);
    }
    public String decrement(String s, int index) {
        int a = s.charAt(index)-'0';
        a = a == 0 ? 9 : a-1;
        return s.substring(0,index)+a+s.substring(index+1);
    }
}
class LockState {
    String state;
    int moves;
    public LockState (String s, int a) {
        this.state = s;
        this.moves = a;
    }
}
