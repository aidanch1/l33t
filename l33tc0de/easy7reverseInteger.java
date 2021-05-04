package l33tc0de;

public class easy7reverseInteger {
	public static int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		int ans = 0;
		int m = x/Math.abs(x);
		x=Math.abs(x);
        while (x > 0) {
        	if (ans*10/10 != ans) {
        		return 0;
        	}
        	ans*=10;
        	ans += x%10;
        	x/=10;
        }
        return ans*m;
    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(reverse(2147483647));
	}
}
