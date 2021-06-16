package l33tc0de2;

import java.util.*;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        char[] ans = new char[n];
        List<Character> c = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            c.add((char) ('0'+i));
        }
        for (int i=0; i<n; i++) {
            int[] t = getNext(n-i,k);
            k = t[1];
            ans[i] = c.remove(t[0]-1);
        }
        return new String(ans);
    }
    public int[] getNext(int n, int k) {
        int rp = factorial(n-1);
        for (int i=1; i<=n; i++) {
            if (k <= rp*i) { 
                return new int[] {i,k-rp*(i-1)};
            }
        }
        return new int[] {-1,-1};
    }
    public int factorial(int n) {
        int a = 1;
        for (int i=2; i<=n; i++) {
            a*=i;
        }
        return a;
    }
}
