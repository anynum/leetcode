package com.anynum.demo.tree;

import java.util.NoSuchElementException;

class AvlTree<E extends Comparable<? super E>> {

    public static void main(String[] args) {

    }

    private Node<E> root;

    private static final int ALLOWED_IMBALANCE = 1;

    public AvlTree() {

    } // 无参构造器

    public void makeEmpty() { // 树置空
        root = null;
    }

    public boolean isEmpty() { // 树判空
        return root == null;
    }

    public void insert(E e) { // 插入结点驱动方法
        root = insert(e, root);
    }

    public void remove(E e) { // 删除结点驱动方法
        root = remove(e, root);
    }

    public E findMin() { // 查找最小结点驱动方法
        if (isEmpty()) throw new NoSuchElementException();
        return findMin(root).element;
    }

    public E findMax() { // 查找最大结点驱动方法
        if (isEmpty()) throw new NoSuchElementException();
        return findMax(root).element;
    }

    public boolean contains(E e) { // 判断是否包含指定元素驱动方法
        return contains(e, root);
    }

    public void printTree() { // 按中序遍历打印树的驱动方法
        if (isEmpty()) System.out.println("Empty tree");
        else printTree(root);
    }

    public int size() { // 求树的结点个数驱动方法
        return size(root);
    }

    public int height() { // 求树的高度驱动方法
        return height(root);
    }

    public void checkBalance() { // 树平衡检查驱动方法
        checkBalance(root);
    }

    private Node<E> balance(Node<E> t) { // 调整 t 结点处的平衡，并返回 t
        if (t == null) return null;

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) { // 失衡，且左高于右
            // 此处不会NPE
            if (height(t.left.left) >= height(t.left.right)) { // 右单旋情形
                t = rotateRight(t);
            } else t = rotateLeftRight(t); // 左右双旋情形
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) { // 失衡，且右高于左
            if (height(t.right.right) >= height(t.right.left)) { // 左单旋情形
                t = rotateLeft(t);
            } else t = rotateRightLeft(t); // 右左双旋情形
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1; // 更新 t 的高度
        return t;
    }

    private Node<E> insert(E e, Node<E> t) { // 插入结点，返回时沿路检查平衡并调整
        if (t == null) return new Node<>(e, null, null);
        int compareRes = e.compareTo(t.element);
        if (compareRes < 0) t.left = insert(e, t.left);
        else if (compareRes > 0) t.right = insert(e, t.right);
        // 等于时不插入(以该树只能存放不同的元素为前提)
        return balance(t); // 调整t处的平衡并返回t
    }

    private Node<E> remove(E e, Node<E> t) { // 删除结点(懒惰删除)，返回时沿路检查平衡并调整
        if (t == null) return null;
        int compareRes = e.compareTo(t.element);
        if (compareRes < 0) t.left = remove(e, t.left); // 递归地在左侧寻找
        else if (compareRes > 0) t.right = remove(e, t.right); // 递归地在右侧寻找
            // e等于t.element，分两种情形
        else if (t.left != null && t.right != null) { // 情形1：该t的左右子结点均不为null
            t.element = findMin(t.right).element; // 在右子树中找min
            t.right = remove(t.element, t.right); // 此时min已是t.element，必为情形2
        } else t = (t.left != null) ? t.left : t.right; // 情形2: 1以外的情形
        return balance(t); // 调整t处的平衡并返回t
    }

    private Node<E> findMin(Node<E> t) { // 返回树的最小结点(递归方式)
        if (t == null) return null;
        else if (t.left == null) return t;
        return findMin(t.left);
    }

    private Node<E> findMax(Node<E> t) { // 返回树的最大结点(循环方式)
        if (t == null) return null;
        while (t.right != null) t = t.right;
        return t;
    }

    private boolean contains(E e, Node<E> t) { // 判断树中是否有指定元素的结点
        if (t == null) return false;
        int compareRes = e.compareTo(t.element);
        if (compareRes < 0) return contains(e, t.left);
        else if (compareRes > 0) return contains(e, t.right);
        else return true;
    }

    private void printTree(Node<E> t) { // 中序遍历打印树
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(Node<E> t) { // 返回以t为根结点的树的高度
        return t == null ? -1 : t.height;
    }

    private int size(Node<E> t) { // 递归地遍历所有结点，返回结点总数
        if (t != null) {
            if (t.left != null && t.right != null) {
                return 1 + size(t.left) + size(t.right);
            } else {
                return t.left != null ? 1 + size(t.left) : 1 + size(t.right);
            }
        }
        return 0;
    }

    private int checkBalance(Node<E> t) { // 检查树是否平衡，不平衡打印“imbalance”，并返回树高度
        if (t == null) return -1;
        int lh = checkBalance(t.left);
        int rh = checkBalance(t.right);
        if (Math.abs(height(t.left) - height(t.right)) > 1
                || height(t.left) != lh || height(t.right) != rh) {
            System.out.println("imbalance");
        }
        return height(t);
    }

    private Node<E> rotateRight(Node<E> k2) { // 右单旋
        Node<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1; // 调整k2高度
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1; // 调整k1高度
        return k1; // 返回调整后原失衡处结点
    }

    private Node<E> rotateLeft(Node<E> k1) { // 左单旋
        Node<E> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1; // 调整k1高度
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1; // 调整k2高度
        return k2; // 返回调整后原失衡处结点
    }

    private Node<E> rotateLeftRight(Node<E> k3) { // 左右双旋
        k3.left = rotateLeft(k3.left);
        return rotateRight(k3);
    }

    private Node<E> rotateRightLeft(Node<E> k1) { // 右左双旋
        k1.right = rotateRight(k1.right);
        return rotateLeft(k1);
    }

    /**
     * AVL树结点嵌套类
     */
    private static class Node<E> {
        public E element;
        public Node<E> left, right;
        // 比BinaryNode多维护一个height字段，每次insert或remove一个结点时通过balance方法更新
        public int height;

        @SuppressWarnings("unused")
        public Node(E theElement) {
            this(theElement, null, null);
        }

        public Node(E element, Node<E> left, Node<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}