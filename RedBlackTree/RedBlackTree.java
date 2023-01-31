package RedBlackTree;

public class RedBlackTree {

    private Node root;

    private class Node {
        private int value;
        private Color color;
        private Node rightChild;
        private Node leftChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node {value = " + value + "color = " + color + "}";
        }
    }

    private enum Color {
        RED, BLACK
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node rightSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node leftSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node rebalance(Node node) {
        Node parent = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (parent.rightChild != null && parent.rightChild.color == Color.RED &&
                    (parent.leftChild == null || parent.leftChild.color == Color.BLACK)) {
                parent = leftSwap(parent);
                needRebalance = true;
            }
            if (parent.leftChild != null && parent.leftChild.color == Color.RED &&
                    parent.leftChild.leftChild != null && parent.leftChild.leftChild.color == Color.RED) {
                parent = rightSwap(parent);
                needRebalance = true;
            }
            if (parent.leftChild != null && parent.leftChild.color == Color.RED &&
                    parent.rightChild != null && parent.rightChild.color == Color.RED) {
                colorSwap(parent);
                needRebalance = true;
            }
        } while (needRebalance);
        return parent;
    }

    private boolean addNode (Node root, int value){
        if (root.value == value)
            return false;
        else {
            if (value < root.value){
                if (root.leftChild != null){
                    boolean result = addNode(root.leftChild, value);
                    root.leftChild = rebalance (root.leftChild);
                    return result;
                } else {
                    root.leftChild = new Node(value);
                    root.leftChild.color = Color.RED;
                    return true;
                }
            } else {
                if (root.rightChild != null){
                    boolean result = addNode(root.rightChild, value);
                    root.rightChild = rebalance (root.rightChild);
                    return result;
                } else {
                    root.rightChild = new Node(value);
                    root.rightChild.color = Color.RED;
                    return true;
                }
            }
        }
    }

    public boolean add (int value){
        if (root!= null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node (value);
            root.color = Color.BLACK;
            return true;
        }
    }

}
