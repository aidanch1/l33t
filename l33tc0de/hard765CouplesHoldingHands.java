package l33tc0de;

import java.util.*;

public class hard765CouplesHoldingHands {
	public static int minSwapsCouples(int[] row) {
       	//map num to its index in the array
		Map<Integer, Integer> m = new HashMap<>();
		for (int i=0; i<row.length; i++) {
			m.put(row[i], i);
		}
		int ans = 0;
		Set<Integer> seen = new HashSet<>();
		for (int i=0; i<row.length/2; i++) {
			if (!seen.contains(i)) {
				Stack<Integer> people = new Stack<>(); // people to match
				//add group i
				people.push(row[i*2]);
				if (people.peek() == getPartner(row[i*2+1])) {
					people.pop();
				}
				else {
					people.add(row[i*2+1]);
				}
				int couplesAdded = 1;
				seen.add(i);
				while (!people.isEmpty()) {
					//match a person with their couple
					int toMatch = people.pop();
					int matcher = getPartner(toMatch);
					int indexOfMatcher = m.get(matcher);
					int newguy = getPartner(indexOfMatcher);
					int newpartner = row[newguy];
					if (people.peek() == getPartner(newpartner)) {
						people.pop();
					}
					else {
						people.push(newpartner);
					}
					seen.add(getGroup(indexOfMatcher));
					couplesAdded++;
				}
				ans += (couplesAdded-1);
			}
		}
		return ans;
    }
	public static int getPartner(int a) {
		//0 <-> 1, 2 <-> 3, 4 <-> 5
		if (a % 2 == 0) {
			return a + 1;
		}
		else {
			return a - 1;
		}
	}
	public static int getGroup(int index) {
		return index/2;
	}
	public static void main(String[] args) {
		int[] row = new int[] {0, 2, 1, 3};
		System.out.println(minSwapsCouples(row));
	}
}