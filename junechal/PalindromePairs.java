package junechal;

import java.util.*;

public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> getindex = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            getindex.put(words[i],i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pairs = new boolean[words.length][words.length];
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) {
                //treat words[i] as first word in pal
                String s1 = reverse(words[i].substring(0,j));
                if (isP(words[i], j, words[i].length()) && 
                    getindex.containsKey(s1)) {
                    if (!pairs[i][getindex.get(s1)] && i != getindex.get(s1)) {
                        ans.add(makeList(i,getindex.get(s1)));
                        pairs[i][getindex.get(s1)] = true;
                    }
                }
                //treat as second word
                String s2 = reverse(words[i].substring(j));
                if (isP(words[i],0,j) && 
                   getindex.containsKey(s2)) {
                    if (!pairs[getindex.get(s2)][i] && i != getindex.get(s2)) {
                        ans.add(makeList(getindex.get(s2),i));
                        pairs[getindex.get(s2)][i] = true;
                    }
                }
            }
        }
        return ans;
    }
    public boolean isP(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        end--;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String reverse(String s){
        StringBuilder r = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            r.append(s.charAt(i));
        }
        return r.toString();
    }
    public List<Integer> makeList(int a, int b) {
        List<Integer> r = new ArrayList<>();
        r.add(a);
        r.add(b);
        return r;
    }
}
