package l33tc0de;

import java.util.*;

public class hard32LongestValidParentheses {
	//theorem: every valid parentheses has to contain a "()" in it
	// -> strategy: find a "()" try and expand it by either growing it "(())" or combining it "()()"
	public static int longestValidParentheses(String s) {
		if (s.length() < 2) {
			return 0;
		}
        List<Range> p = new ArrayList<>();
        boolean added = false;
        char[] c = s.toCharArray();
        for (int i=0; i<c.length-1; i++) {
        	if (c[i] == '(' && c[i+1] == ')') {
        		Range r = new Range(i, i+1);
        		p.add(r);
        		i++;
        		added = true;
        	}
        }
        while (added) {
        	added = false;
        	//try to grow
        	for (Range r:p) {
        		if (r.begin > 0 && r.end < c.length-1 && c[r.begin-1] == '(' && c[r.end+1] == ')') {
        			r.begin-=1;
        			r.end+=1;
        			added = true;
        		}
        	}
        	//try to combine
        	for (int i=0; i<p.size(); i++) {
        		for (int j=i; j<p.size(); j++) {
        			if (p.get(i).end+1 == p.get(j).begin) {
        				p.get(i).end = p.get(j).end;
        				p.remove(j);
        				added = true;
        			}
        		}
        	}
        }
        int longest = 0;
        for (Range r:p) {
        	int t = r.end - r.begin + 1;
        	if (t > longest) {
        		longest = t;
        	}
        }
        return longest;
    }
	public static void main(String[] args) {
		String s = "(";
		int i = longestValidParentheses(s);
		System.out.println("The longest valid parentheses substring is: " + i);
	}
}
class Range {
	int begin;
	int end;
	public Range(int a, int b) {
		begin = a;
		end = b;
	}
}
