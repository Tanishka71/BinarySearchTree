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
	/*
	 * @desc: gives the size of the tree
	 * @params:none
	 * @return:integer
	 */
    int size();
    
	/*
	 * @desc: SEARCHES FOR AN ELEMENTS
	 * @params:object data/key
	 * @return:boolean
	 */
    boolean search(K key);
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
   
	/*
	 * @desc: gives the size of the tree
	 * @params:none
	 * @return:integer
	 */
     public int size() {
            // Calculate the size of the subtree rooted at this node
            int leftSize = (left != null) ? left.size() : 0;
            int rightSize = (right != null) ? right.size() : 0;
            return leftSize + rightSize + 1; // Add 1 for the current node

    }
     
 	/*
 	 * @desc: SEARCHES FOR AN ELEMENTS
 	 * @params:object data/key
 	 * @return:boolean
 	 */
     @Override
     public boolean search(K searchKey) {
         // Recursively search for the key in the subtree rooted at this node
         if (searchKey.compareTo(key) == 0) {
             return true; // Found the key in this node
         } else if (searchKey.compareTo(key) < 0 && left != null) {
             return left.search(searchKey); // Search in the left subtree
         } else if (searchKey.compareTo(key) > 0 && right != null) {
             return right.search(searchKey); // Search in the right subtree
         }
         return false; // Key not found
     }
}

// Binary Search Tree class
class BinaryST<K extends Comparable<K>> {
    private INode<K> root;

    public BinaryST() {
        this.root = null;
    }
     
    //@desc:Returns the root of the tree
    public INode<K> getRoot() {
        return root;
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
 	 * @desc: SEARCHES FOR AN ELEMENTS
 	 * @params:object data/key
 	 * @return:boolean
 	 */
    public boolean search(K key) {
        // Start the search from the root
        return root != null && root.search(key);
    }
    
    /*
	 * @desc:display the bst
	 * @params: root - The root of the current subtree.
	 * @return: none
	 */
    
    public void display() {
    	System.out.println("Displaying by inorder (ascending):");
        displayInOrder(root);
        System.out.println();
    }
    private void displayInOrder(INode<K> root) {
        if (root != null) {
            // Display left subtree
            displayInOrder(root.getLeft());

            // Display current node's key
            System.out.print(root.getKey() + " ");

            // Display right subtree
            displayInOrder(root.getRight());
        }
      
    }
   
}