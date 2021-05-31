package weekly243;

public class q2 {
	public String maxValue(String n, int x) {
        if (n.charAt(0) == '-') {
            for (int i=1; i<n.length(); i++) {
                if (n.charAt(i)-'0'>x) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(n.substring(0,i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                }
            }
        }
        else {
            for (int i=0; i<n.length(); i++) {
                if (n.charAt(i)-'0'<x) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(n.substring(0,i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                }
            }
        }
        return n+x;
    }
}
