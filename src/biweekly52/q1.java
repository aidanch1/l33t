package biweekly52;
import java.util.*;

public class q1 {
	public String sortSentence(String s) {
		List<a> arr = new ArrayList<>();
        while (!s.isEmpty()) {
        	int next = s.indexOf(' ');
        	if (next == -1) {
        		next = s.length();
        		int n = s.charAt(next-1) - '0';
	        	s = s.substring(0, next-1);
	        	arr.add(new a(n, s));
	        	break;
        	}
        	else {
        		String sub = s.substring(0, next);
	        	int n = sub.charAt(next-1) - '0';
	        	sub = sub.substring(0, next-1);
	        	arr.add(new a(n, sub));
	        	s = s.substring(next+1);
        	}
        }
        Collections.sort(arr, new sort());
        StringBuilder ans = new StringBuilder();
        ans.append(arr.get(0).str);
        for (int i=1; i<arr.size(); i++) {
        	ans.append(' ');
        	ans.append(arr.get(i).str);
        }
        return ans.toString();
    }
}
class a {
	int index;
	String str;
	public a (int i, String s) {
		this.index = i;
		this.str = s;
	}
}
class sort implements Comparator<a> {

	@Override
	public int compare(a o1, a o2) {
		return o1.index - o2.index;
	}
	
}
