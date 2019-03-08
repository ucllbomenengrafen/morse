package domain;

import java.util.Arrays;

public class BinaryTree<E> {
    private E data;
    private BinaryTree<E> leftTree, rightTree;


    protected BinaryTree(E data) {
        this(data, null, null);
    }

    protected BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        if (data == null)
            throw new IllegalArgumentException("No null root");
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    private E getData() {
        return this.data;
    }

    private BinaryTree<E> getLeftTree() {
        return leftTree;
    }

    private BinaryTree<E> getRightTree() {
        return rightTree;
    }

    private E lookUp(E data) {
        if (data == null)
            throw new IllegalArgumentException("No lookup for null");
        if (this.data.equals(data))
            return this.data;
        if (rightTree != null) {
            E element = rightTree.lookUp(data);
            if (element != null)
                return element;
        }
        if (leftTree != null) {
            E element = leftTree.lookUp(data);
            if (element != null)
                return element;
        }
        return null;
    }


    /**
     * find node according to given sequence of booleans
     * start from root
     * true: go right
     * false: go left
     *
     * @param sequence of booleans
     * @return resulting node
     */
    protected E followPath(boolean[] sequence) {
        if (sequence == null)
            throw new IllegalArgumentException("No valid sequence to decode");
        if (sequence.length >= getDepth())
            throw new IllegalArgumentException("Given sequence is to long");
        if (sequence.length == 0)
            return this.getData();
        if (sequence[0]) {
            return getRightTree().followPath(Arrays.copyOfRange(sequence, 1, sequence.length));
        } else {
            return getLeftTree().followPath(Arrays.copyOfRange(sequence, 1, sequence.length));
            // niet nodig om te testen of lefttree/righttree == null
            // omdat fout opgegooid wordt als lengte van sequence groter is dan diepte van boom
        }
    }

    private boolean isLeaf() {
        return getLeftTree() == null && getRightTree() == null;
    }

    private int getDepth() {
        if (isLeaf())
            return 1;
        int depthLeft = getLeftTree() == null ? 0 : getLeftTree().getDepth();
        int depthRight = getRightTree() == null ? 0 : getRightTree().getDepth();
        return 1 + Math.max(depthLeft, depthRight);
    }


}
