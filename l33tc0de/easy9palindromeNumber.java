package l33tc0de;

public class easy9palindromeNumber {
	public static boolean isPalindrome(int x) {
        int t = x;
        int y = 0;
        while (t > 0) {
        	y*=10;
        	y += t%10;
        	t/=10;
        }
        return x == y;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
	}
}
