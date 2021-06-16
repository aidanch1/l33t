package junechal;

import java.util.*;

public class GenerateParenthesis {
	List<String> p;
    public List<String> generateParenthesis(int n) {
        p = new ArrayList<>();
        generate("", n*2);
        return p;
    }
    public void generate(String s, int n) {
        if (n == 0) {
            if (isWF(s)) {
                p.add(s);
            }
            return;
        }
        generate(s+")",n-1);
        generate(s+"(",n-1);
    }
    public boolean isWF(String s) {
        int t = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (t > 0) {
                    t--;
                }
                else {
                    return false;
                }
            }
            else {
                t++;
            }
        }
        return t==0;
    }
}
