package com.bridgelabz.bst;

public class BinarySTMain {

	public static void main(String[] args) {
        // Create a BST
        BinaryST<Integer> bst = new BinaryST<>();

        // Add nodes
        bst.add(56);
        bst.add(30);
        bst.add(70);
        bst.add(22);
        bst.add(40);
        bst.add(11);
        bst.add(3);
        bst.add(16);
        bst.add(95);
        bst.add(60);
        bst.add(65);
        bst.add(63);
        bst.add(67);
        bst.display();
        
        boolean found = bst.search(63);
        System.out.println("Key 63 found in the binary tree: " + found);
        
        int treeSize = bst.getRoot().size();
        System.out.println("Size of the binary tree: " + treeSize);
    }
	}