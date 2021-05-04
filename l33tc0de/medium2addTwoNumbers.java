package l33tc0de;

import java.util.*;

/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

public class medium2addTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
	public ListNode add(ListNode l1, ListNode l2, int carryover) {
		if (l1 == null && l2 == null) {
			if (carryover == 0) {
				return null;
			}
			else {
				return new ListNode(carryover);
			}
		}
		if (l1 == null) {
			return add(l2, carryover);
		}
		if (l2 == null) {
			return add(l1, carryover);
		}
		int num = l1.val + l2.val + carryover;
		ListNode ans = new ListNode(num%10, add(l1.next, l2.next, num/10));
		return ans;
	}
	public ListNode add(ListNode l, int carryover) {
		if (l == null) {
			if (carryover == 0) {
				return null;
			}
			else {
				return new ListNode(carryover);
			}
		}
		l.val += carryover;
		if (l.val == 10) {
			l.val = 0;
			l.next = add(l.next, 1);
		}
		return l;
	}
}
