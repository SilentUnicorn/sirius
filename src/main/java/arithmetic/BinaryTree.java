package arithmetic;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {

        Node n3 = new Node(null, null, 3, null);
        Node n4 = new Node(null, null, 4, null);
        Node n5 = new Node(null, null, 5, null);
        Node n1 = new Node(n3, n4, 1, null);
        Node n2 = new Node(null, n5, 2, null);
        Node root = new Node(n1, n2, 0, null);
        fillNext(root);
        System.out.println(root);
    }
    public static void fillNext(Node root){
        if (root == null){
            return;
        }
        Queue<Node> nodes = new LinkedList();
        nodes.add(root);
        while (nodes.size() > 0){
            int size = nodes.size();
            for(int i =0; i < size;i++){
                Node node = nodes.poll();
                Node next = nodes.peek();

                if (node!= null && next != null && i< size-1){
                    node.next = next;
                }
                if (node.left !=null){
                    nodes.add(node.left);
                }
                if (node.right != null){
                    nodes.add(node.right);
                }
            }
        }
    }
}
class Node{
    Node left;
    Node right;
    int value;
    Node next;

    Node(Node left, Node right, int value, Node next) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.next = next;
    }
}
