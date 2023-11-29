package com.bridgelabz.bst;

/*@desc:INode interface in the context of a Binary Search Tree (BST) or a general tree data structure, it typically 
serves as a blueprint for the nodes within the tree.*/
interface INode<K extends Comparable<K>> {
    K getKey();
    INode<K> getLeft();
    INode<K> getRight();

	/*
	 * @desc: Sets the left child of the node.
	 * 
	 * @params: left - The left child node to be set
	 */
    void setLeft(INode<K> left);

	/*
	 * @desc: Sets the right child of the node.
	 * 
	 * @params: right - The right child node to be set.
	 */
    void setRight(INode<K> right);
}


class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private INode<K> left;
    private INode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    /*
	 * @desc:gets the left child of the node.
	 * @params: none
	 * @return:left node
	 */
    public INode<K> getLeft() {
        return left;
    }

    @Override
    /*
 	 * @desc:gets the right child of the node.
 	 * @params: none
 	 * @return:right node
 	 */
    public INode<K> getRight() {
        return right;
    }

    @Override
    /*
	 * @desc: Sets the right child of the node.
	 * @params:left child node to be set.
	 * @return:none
	 */
    public void setLeft(INode<K> left) {
        this.left = left;
    }

    @Override
	/*
	 * @desc: Sets the right child of the node.
	 * @params: right - The right child node to be set.
	 * @return:none
	 */
    public void setRight(INode<K> right) {
        this.right = right;
    }
}

// Binary Search Tree class
class BinaryST<K extends Comparable<K>> {
    private INode<K> root;

    public BinaryST() {
        this.root = null;
    }

	/*
	 * @desc: Adds a key to the Binary Search Tree.
	 * @params: key - The key to be added.
	 * @return:none
	 */
    public void add(K key) {
        root = addRecursive(root, key);
    }

	/*
	 * @desc: Recursively adds a key to the BST.
	 * @params: root - The root of the current subtree.
	 * @params: key - The key to be added.
	 * @return: The updated root of the subtree.
	 */
    private INode<K> addRecursive(INode<K> root, K key) {
        // If the tree is empty, create a new node
        if (root == null) {
            return new MyBinaryNode<>(key);
        }

        // Otherwise, recur down the tree
        if (key.compareTo(root.getKey()) < 0) {
            root.setLeft(addRecursive(root.getLeft(), key));
        } else if (key.compareTo(root.getKey()) > 0) {
            root.setRight(addRecursive(root.getRight(), key));
        }

        return root;
    }
    
    /*
	 * @desc:display the bst
	 * @params: root - The root of the current subtree.
	 * @return: none
	 */
    
    public void display() {
        displayOrder(root);
    }
    private void displayOrder(INode<K> root) {
        if (root != null) {
            // Display left subtree
            displayOrder(root.getLeft());

            // Display current node's key
            System.out.print(root.getKey() + " ");

            // Display right subtree
            displayOrder(root.getRight());
        }
    }
}