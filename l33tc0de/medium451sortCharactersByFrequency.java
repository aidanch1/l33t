package l33tc0de;

import java.util.*;

public class medium451sortCharactersByFrequency {
	public static String frequencySort(String s) {
		Map<Character, Integer> m = new HashMap<>();
		char[] sc = s.toCharArray();
		for(int i=0; i<sc.length; i++) {
			m.putIfAbsent(sc[i], 0);
			m.put(sc[i], m.get(sc[i])+1);
		}
		Queue<a> pq = new PriorityQueue<a>(10, new sort());
		for (char c : m.keySet()) {
			pq.add(new a(c, m.get(c)));
		}
		StringBuilder ans = new StringBuilder();
		while(!pq.isEmpty()) {
			a next = pq.poll();
			for (int i=0; i<next.freq; i++) {
				ans.append(next.c);
			}
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}
}
class a {
	char c;
	int freq;
	public a(char c, int freq) {
		this.c = c;
		this.freq = freq;
	}
}
class sort implements Comparator<a> {
	@Override
	public int compare(a o1, a o2) {
		return o2.freq - o1.freq;
	}
}
 