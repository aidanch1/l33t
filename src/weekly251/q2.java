package weekly251;

public class q2 {
	public String maximumNumber(String num, int[] change) {
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            int t = (int) (c-'0');
            if (change[t]>t) {
                ans.append(num.substring(0,i));
                while (change[t]>=t) {
                    ans.append(change[t]);
                    i++;
                    if (i >= num.length()) {
                        break;
                    }
                    c = num.charAt(i);
                    t = (int) (c-'0');
                }
                ans.append(num.substring(i));
                return ans.toString();
            }
        }
        return num;
    }
}
