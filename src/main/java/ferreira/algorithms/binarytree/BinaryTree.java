package ferreira.algorithms.binarytree;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            this.root.add(value);
        }
    }

    public void printFirstCommonAncestor(int valueA, int valueB) {
        Node nodeA = find(valueA);
        if (nodeA == null) throw new IllegalStateException("Could not find node for value: " + valueA);

        Node nodeB = find(valueB);
        if (nodeB == null) throw new IllegalStateException("Could not find node for value: " + valueB);

        // find deepest's node ancestor with same depth as the other one
        Node nodeOne;
        Node nodeTwo;
        if (nodeA.getDepth() > nodeB.getDepth()) {
            nodeOne = nodeA;
            nodeTwo = nodeB;
        } else {
            nodeOne = nodeB;
            nodeTwo = nodeA;
        }
        while (nodeOne.getDepth() > nodeTwo.getDepth()) {
            nodeOne = nodeOne.getParent();
        }

        // search for common ancestor, parent by parent
        while (!nodeOne.equals(nodeTwo)) {
            nodeOne = nodeOne.getParent();
            nodeTwo = nodeTwo.getParent();
        }

        System.out.println(nodeOne.getValue());
    }

    private Node find(int value) {
        return find(value, root);
    }

    private Node find(int value, Node node) {
        if (node == null) return null;
        if (node.getValue() == value) return node;

        Node leftResult = find(value, node.getLeft());
        if (leftResult != null) return leftResult;

        Node rightResult = find(value, node.getRight());
        if (rightResult != null) return rightResult;

        return null;
    }
}
