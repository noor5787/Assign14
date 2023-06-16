class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListLoopRemoval {
    static Node head;
    
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    
    void detectAndRemoveLoop() {
        Node slowPointer = head;
        Node fastPointer = head;
        boolean loopExists = false;
        
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            
            if (slowPointer == fastPointer) {
                loopExists = true;
                break;
            }
        }
        
        if (loopExists) {
            slowPointer = head;
            
            while (slowPointer.next != fastPointer.next) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            
            fastPointer.next = null; // Remove the loop
        }
    }
    
    public static void main(String[] args) {
        LinkedListLoopRemoval linkedList = new LinkedListLoopRemoval();
        
        // Example 1
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(1);
        
        // Creating a loop for testing
        head.next.next.next = head.next;
        
        linkedList.detectAndRemoveLoop();
        System.out.print("Output: ");
        linkedList.printList();
        
        // Example 2
        linkedList = new LinkedListLoopRemoval();
        
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(8);
        linkedList.push(1);
        
        linkedList.detectAndRemoveLoop();
        System.out.print("Output: ");
        linkedList.printList();
    }
}
