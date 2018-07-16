package ferreira.algorithms.binarytree;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private int depth;
    private int value;

    public Node(int value) {
        this.value = value;
        this.depth = 0;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getDepth() {
        return depth;
    }

    public int getValue() {
        return value;
    }

    public void add(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.setLeft(new Node(value));
            } else {
                this.left.add(value);
            }
        } else if (value > this.value) {
            if (this.right == null) {
                this.setRight(new Node(value));
            } else {
                this.right.add(value);
            }
        }
    }

    private void setLeft(Node left) {
        assignChild(left);
        this.left = left;
    }

    private void setRight(Node right) {
        assignChild(right);
        this.right = right;
    }

    private void assignChild(Node child) {
        child.depth = this.depth + 1;
        child.parent = this;
    }
}
