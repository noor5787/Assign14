package in.ineuron7;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        // Convert linked list to array
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Create the linked list: [2, 1, 5]
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        
        NextGreaterNode solution = new NextGreaterNode();
        int[] result = solution.nextLargerNodes(head);
        
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
