package weekly251;

public class q1 {
	public int getLucky(String s, int k) {
        int start = 0;
        for (char c:s.toCharArray()) {
            int t = (int) (c-'a')+1;
            if (t >= 10) {
                start += t%10;
                t /= 10;
            }
            start += t;
        }
        for (int i=1; i<k; i++) {
            int t = 0;
            while (start > 0) {
                t += start%10;
                start/=10;
            }
            start = t;
        }
        return start;
    }
}