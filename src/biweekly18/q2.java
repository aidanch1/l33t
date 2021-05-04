package biweekly18;

public class q2 {
	public String breakPalindrome(String palindrome) {
        char[] c = palindrome.toCharArray();
        if (c.length <= 1) {
        	return "";
        }
        for (int i=0; i<c.length; i++) {
        	if (i != c.length/2 && c[i] != 'a') {
        		c[i] = 'a';
        		return new String(c);
        	}
        }
        if (c[c.length-1] == 'a') {
        	c[c.length-1] = 'b';
        }
        else {
        	c[c.length-1] = (char) (c[c.length-1] - 1);
        }
        return new String(c);
    }
}
