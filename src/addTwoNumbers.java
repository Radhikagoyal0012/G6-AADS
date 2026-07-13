class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node addTwoNumbers(Node head, Node head1) {
        Node dummy = new Node(0);
        Node curr = dummy;

        int carry = 0;

        while (head != null || head1 != null || carry != 0) {
            int sum = carry;

            if (head != null) {
                sum += head.data;
                head = head.next;
            }

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            carry = sum / 10;

            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Helper method to print linked list
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // First number: 342 represented as 2 -> 4 -> 3
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);

        // Second number: 465 represented as 5 -> 6 -> 4
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(4);

        Node result = sol.addTwoNumbers(head, head1);

        System.out.print("Result: ");
        sol.printList(result); // Expected output: 7 0 8 (represents 807)
    }
}
