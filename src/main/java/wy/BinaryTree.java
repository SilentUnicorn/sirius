package wy;

/**
 * @author zhangjingsi
 * @date 2018/5/9下午4:47
 *
 *            n7
 *         /      \
 *        n5     n6
 *       /  |    / \
 *      n1  n2  n3 n4
 */
public class BinaryTree {
    public static void main(String[] args) {
        //构造二叉树
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, null, null);
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(0, n1, n2);
        Node n6 = new Node(0, n3, n4);
        Node n7 = new Node(0, n5, n6);
        System.out.println("sum:"+ first(n7));
    }
    public static Integer first(Node node){
        Integer sum = 0;
        if (node != null){
            System.out.println(node.getData());
            sum += node.getData();
            sum += first(node.getLeftNode());
            sum += first(node.getRightNode());
        }
        return sum;
    }
}
class Node{
    private Integer data;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
