/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    HashMap<Node, Node> tracker = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (tracker.containsKey(head)) return tracker.get(head);

        Node copy = new Node(head.val);
        tracker.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = tracker.get(head.random);
        return copy;
    }
}
