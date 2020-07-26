/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

public class Q23 {

}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0)
            return null;
        int interval = 1;

        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval * 2) {
                lists[i] = mergeList(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode vHead = new ListNode(-1);
        ListNode node = vHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return vHead.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}