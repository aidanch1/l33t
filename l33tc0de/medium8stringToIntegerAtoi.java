package l33tc0de;

public class medium8stringToIntegerAtoi {
	public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
        	return 0;
        }
        int mult = 1;
        int i=0;
        if (s.charAt(0) == '-') {
        	mult = -1;
        	i = 1;
        }
        if (s.charAt(0) == '+') {
        	i = 1;
        }
        int ans = 0;
        while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '9' <= 9) {
        	int test = (ans * 10 + s.charAt(i) - '0');
        	if (test/10 != ans) {
        		if (mult == 1) {
        			return Integer.MAX_VALUE;
        		}
        		else {
        			return Integer.MIN_VALUE;
        		}
        	}
        	ans *= 10;
        	ans += s.charAt(i) - '0';
        	i++;
        }
        return ans*mult;
    }
	public static void main(String[] args) {
		String s = "-6147483648";
		System.out.println(myAtoi(s));
	}
}
