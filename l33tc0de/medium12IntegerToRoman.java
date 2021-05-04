package l33tc0de;

import java.util.*;

public class medium12IntegerToRoman {
	/*
	 * need I = 1, IV = 4, V = 5, IX = 9, X = 10, XL = 40, L = 50, XC = 90, C = 100, CD = 400, D = 500, CM = 900, M = 1000
	 */
	public static String intToRoman(int num) {
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "I");
		m.put(4, "IV");
		m.put(5, "V");
		m.put(9, "IX");
		m.put(10, "X");
		m.put(40, "XL");
		m.put(50, "L");
		m.put(90, "XC");
		m.put(100, "C");
		m.put(400, "CD");
		m.put(500, "D");
		m.put(900, "CM");
		m.put(1000, "M");
		StringBuilder ans = new StringBuilder();
		while (num > 0) {
			int max = 0;
			for (int i:m.keySet()) {
				if (i > max && i <= num) {
					max = i;
				}
			}
			num -= max;
			ans.append(m.get(max));
		}
		return ans.toString();
    }
	//Problem #13 - easy - Roman to Integer
	public static int romanToInt(String s) {
		Map<String, Integer> m = new HashMap<>();
		m.put("I",1);
		m.put("IV",4);
		m.put("V",5);
		m.put("IX",9);
		m.put("X",10);
		m.put("XL",40);
		m.put("L",50);
		m.put("XC",90);
		m.put("C",100);
		m.put("CD",400);
		m.put("D",500);
		m.put("CM",900);
		m.put("M",1000);
		int index = 0;
		int ans = 0;
		while (index < s.length()) {
			if (index < s.length()-1) {
				String t = s.substring(index, index+2);
				if (m.containsKey(t)) {
					ans += m.get(t);
					index += 2;
				}
				else {
					String y = s.substring(index, index+1);
					if (m.containsKey(y)) {
						ans += m.get(y);
						index++;
					}
				}
			}
			else {
				String y = s.substring(index, index+1);
				if (m.containsKey(y)) {
					ans += m.get(y);
					index++;
				}
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(intToRoman(58));
		System.out.println(romanToInt("IV"));
	}
}
