package weekly246;

public class q1 {
	public String largestOddNumber(String num) {
        int last = -1;
        for (int i=0; i<num.length(); i++) {
            if ((num.charAt(i)-'0')%2==1) {
                last = i;
            }
        }
        return num.substring(0,last+1);
    }
}
