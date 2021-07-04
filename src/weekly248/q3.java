package weekly248;

public class q3 {
	long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long n1 = pow(5, (n+1)/2);
        long n2 = pow(4, n/2);
        return (int) (n1 * n2 % mod);
    }
    private long pow(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long p = pow(x, y/2);
        p *= p;
        if (y%2 == 1) {
            p *= x;
        }
        return p % mod;
    }
}