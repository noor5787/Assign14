package in.ineuron8;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteZeroSumSublists {
    public static ListNode deleteZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null) {
            ListNode runner = current.next;
            int sum = 0;
            while (runner != null) {
                sum += runner.val;
                if (sum == 0) {
                    current.next = runner.next;
                    break;
                }
                runner = runner.next;
            }
            if (runner == null) {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: [1,2,-3,3,1]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(-3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(1);

        ListNode result1 = deleteZeroSumSublists(head1);
        printLinkedList(result1);  // Output: [3, 1]

        // Example 2: [1,2,3,-3,4]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(-3);
        head2.next.next.next.next = new ListNode(4);

        ListNode result2 = deleteZeroSumSublists(head2);
        printLinkedList(result2);  // Output: [1, 2, 4]
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
