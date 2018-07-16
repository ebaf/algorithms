package ferreira.algorithms.binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(43);
        tree.add(26);
        tree.add(14);
        tree.add(20);
        tree.add(31);
        tree.add(59);
        tree.add(48);
        tree.add(45);
        tree.add(51);
        tree.add(71);

        tree.printFirstCommonAncestor(45, 71);
        tree.printFirstCommonAncestor(1,71);
    }
}
