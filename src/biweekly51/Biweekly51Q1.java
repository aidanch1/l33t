package biweekly51;

public class Biweekly51Q1 {
	public static String replaceDigits(String s) {
        char[] c = s.toCharArray();
        for (int i=1; i<c.length; i+=2) {
        	c[i] = shift(c[i-1], c[i]-'0');
        }
        return new String(c);
    }
	public static char shift(char c, int i) {
		return (char) (c + i);
	}
	public static void main(String[] args) {
		String s = "a1c1e1";
		System.out.println(replaceDigits(s));
	}
}
