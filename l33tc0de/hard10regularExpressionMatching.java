package l33tc0de;

public class hard10regularExpressionMatching {
	public static boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }
	public static boolean isMatch(char[] s, char[] p, int is, int ip) {
		if (is == s.length) {
			while (ip+1 < p.length && p[ip+1]=='*') {
				ip+=2;
			}
			return ip == p.length;
		}
		if (ip == p.length) {
			return false;
		}
		if (ip < p.length-1 && p[ip+1] == '*') {
			int i = 0;
			//i is how many char i try taking
			while (is+i < s.length && (p[ip] == s[is+i] || p[ip] == '.')){
				if (isMatch(s,p,is+i,ip+2)) {
					return true;
				}
				i++;
			}
			return isMatch(s,p,is+i,ip+2);
		}
		else if (s[is] == p[ip] || p[ip] == '.') {
			return isMatch(s,p,is+1,ip+1);
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); //false
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("ab", ".*")); //true
		System.out.println(isMatch("aab", "c*a*b*")); // true
		System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
		System.out.println(isMatch("aaa", "a*a")); // true
		System.out.println(isMatch("aaa", "ab*a*c*a")); // true
		System.out.println(isMatch("aab", "c*a*b")); //true
	}
}
