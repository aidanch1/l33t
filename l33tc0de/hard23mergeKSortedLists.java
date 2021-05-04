package l33tc0de;

/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

public class hard23mergeKSortedLists {
	//idea: merge 2 lists, then do that over and over until you've merged every list into one
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		ListNode ans = mergeLists(lists[0], lists[1]);
		for (int i=2; i<lists.length; i++) {
			ans = mergeLists(ans, lists[i]);
		}
		return ans;
    }
	//best answer for merge 2 lists (medium) as well! unintentionally did it :)
	public ListNode mergeLists(ListNode a, ListNode b) {
		ListNode front = new ListNode();
		ListNode prev = null;
		ListNode cur = front;
		while (a != null && b != null) {
			if (a.val < b.val) {
				cur.val = a.val;
				cur.next = new ListNode();
				prev = cur;
				cur = cur.next;
				a = a.next;
			}
			else {
				cur.val = b.val;
				cur.next = new ListNode();
				prev = cur;
				cur = cur.next;
				b = b.next;
			}
		}
		if (a != null) {
			if (prev == null) {
				return a;
			}
			prev.next = a;
		}
		else if (b != null) {
			if (prev == null) {
				return b;
			}
			prev.next = b;
		}
		else {
			if (prev == null) {
				return null;
			}
			prev.next = null;
		}
		return front;
	}
}
