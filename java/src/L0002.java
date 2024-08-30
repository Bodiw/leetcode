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

public class L0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0, carry = 0;
        ListNode list = new ListNode();
        ListNode node = list;

        value = l1.val + l2.val + carry;
        carry = value >= 10 ? 1 : 0;
        value = value % 10;
        node.val = value;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            node.next = new ListNode();
            node = node.next;

            value = l1.val + l2.val + carry;
            carry = value >= 10 ? 1 : 0;
            value = value % 10;
            node.val = value;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode trailing = (l1 == null) ? l2 : l1;

        while (trailing != null) {
            node.next = new ListNode();
            node = node.next;

            value = trailing.val + carry;
            carry = value >= 10 ? 1 : 0;
            value = value % 10;
            node.val = value;
            trailing = trailing.next;
        }

        if (carry != 0)
            node.next = new ListNode(carry);

        return list;
    }
}
