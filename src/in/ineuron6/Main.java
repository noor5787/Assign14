package in.ineuron6;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void leftShift(int k) {
        if (head == null || k == 0) {
            return;
        }

        int count = 1;
        Node current = head;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(4);
        list.insert(7);
        list.insert(8);
        list.insert(9);

        int k = 3;
        System.out.println("Original List:");
        list.display();

        System.out.println("After left shifting " + k + " times:");
        list.leftShift(k);
        list.display();

        LinkedList list2 = new LinkedList();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);

        int k2 = 4;
        System.out.println("Original List:");
        list2.display();

        System.out.println("After left shifting " + k2 + " times:");
        list2.leftShift(k2);
        list2.display();
    }
}
