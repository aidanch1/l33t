package l33tc0de;

import java.util.*;

/*class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

public class medium19removeNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//challenge: do it in only 1 pass
		ArrayList<ListNode> t = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			t.add(cur);
			cur = cur.next;
		}
		if (n == t.size()) {
			return head.next;
		}
		ListNode before = t.get(t.size()-n-1);
		before.next = before.next.next;
		return head;
    }
}
