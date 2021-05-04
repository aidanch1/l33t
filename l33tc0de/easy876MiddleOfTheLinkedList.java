package l33tc0de;

/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/
public class easy876MiddleOfTheLinkedList {
	//Better approach: fast guy and slow guy. fast guy runs twice as fast as slow guy, so when hes at the end slow guy is in the middle
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast.next == null) {
			return slow;
		}
		else {
			return slow.next;
		}
	}
	/*public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
        	length++;
        	cur = cur.next;
        }
        cur = head;
        for (int i=0; i<length/2; i++) {
        	cur = cur.next;
        }
        return cur;
    }*/
}
