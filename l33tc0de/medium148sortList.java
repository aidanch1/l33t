package l33tc0de;

/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

public class medium148sortList {
	//idea: mergesort
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode[] halves = split(head);
        ListNode left = sortList(halves[0]);
        ListNode right = sortList(halves[1]);
        return merge(left, right);
    }
	public ListNode[] split(ListNode a) {
		ListNode fast = a;
		ListNode slow = a;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode t = slow.next;
		slow.next = null;
		return new ListNode[] {a, t};
	}
	public ListNode merge(ListNode a, ListNode b) {
		if (a.val > b.val) {
			ListNode t = a;
			a = b;
			b = t;
		}
		ListNode front = a;
		while (a != null && a.next != null && b != null) {
			if (b.val >= a.val && b.val < a.next.val) {
				ListNode t = b.next;
				b.next = a.next;
				a.next = b;
				a = a.next;
				b = t;
			}
			else {
				a = a.next;
			}
		}
		if (a.next == null) {
			a.next = b;
		}
		return front;
	}
}
