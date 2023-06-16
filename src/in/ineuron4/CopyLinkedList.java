package in.ineuron4;
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next, random;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class CopyLinkedList {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Create a map to store the mapping of original nodes to their copies
        Map<Node, Node> nodeMap = new HashMap<>();

        // Create a new list by copying the values of the original list
        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.data);
            nodeMap.put(curr, copyNode);
            curr = curr.next;
        }

        // Set the next and random pointers of the copied nodes
        curr = head;
        while (curr != null) {
            Node copyNode = nodeMap.get(curr);
            copyNode.next = nodeMap.get(curr.next);
            copyNode.random = nodeMap.get(curr.random);
            curr = curr.next;
        }

        return nodeMap.get(head);
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.data + " -> " + (curr.random != null ? curr.random.data : "null") + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        head1.random = head1.next;
        head1.next.random = head1.next.next.next;

        System.out.println("Original List:");
        printLinkedList(head1);

        Node copy1 = copyRandomList(head1);
        System.out.println("Copied List:");
        printLinkedList(copy1);

        // Example 2
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(9);

        head2.random = head2;
        head2.next.next.random = head2.next.next.next;

        System.out.println("Original List:");
        printLinkedList(head2);

        Node copy2 = copyRandomList(head2);
        System.out.println("Copied List:");
        printLinkedList(copy2);
    }
}
