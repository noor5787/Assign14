package in.ineuron2;
//Node class representing a single digit in the linked list
class Node {
 int digit;
 Node next;

 public Node(int digit) {
     this.digit = digit;
     this.next = null;
 }
}

//Linked list class
class LinkedList {
 Node head;

 public LinkedList() {
     this.head = null;
 }

 // Function to add a digit at the end of the linked list
 public void addDigit(int digit) {
     Node newNode = new Node(digit);
     if (head == null) {
         head = newNode;
     } else {
         Node current = head;
         while (current.next != null) {
             current = current.next;
         }
         current.next = newNode;
     }
 }

 // Function to add 1 to the linked list number
 public void addOne() {
     Node current = head;
     Node lastNonNine = null;

     // Traverse the linked list from left to right
     while (current.next != null) {
         if (current.digit != 9) {
             lastNonNine = current;
         }
         current = current.next;
     }

     // If the last digit is not 9, simply increment it
     if (current.digit != 9) {
         current.digit++;
     } else {
         // If the last digit is 9, set it to 0 and propagate the carry
         if (lastNonNine == null) {
             // If all digits are 9, create a new node with digit 1 at the beginning
             lastNonNine = new Node(0);
             lastNonNine.next = head;
             head = lastNonNine;
         }
         lastNonNine.digit++;
         lastNonNine = lastNonNine.next;

         // Set all digits after the lastNonNine node to 0
         while (lastNonNine != null) {
             lastNonNine.digit = 0;
             lastNonNine = lastNonNine.next;
         }
     }
 }

 // Function to convert the linked list number to an integer
 public int toInt() {
     int number = 0;
     Node current = head;
     while (current != null) {
         number = number * 10 + current.digit;
         current = current.next;
     }
     return number;
 }
}

//Main class
public class AddOneToLinkedListNumber {
 public static void main(String[] args) {
     // Create the linked list
     LinkedList linkedList = new LinkedList();
     linkedList.addDigit(4);
     linkedList.addDigit(5);
     linkedList.addDigit(6);

     // Add 1 to the linked list number
     linkedList.addOne();

     // Print the result
     System.out.println("Output: " + linkedList.toInt());
 }
}

