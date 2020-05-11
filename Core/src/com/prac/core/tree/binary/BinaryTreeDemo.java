package com.prac.core.tree.binary;

public class BinaryTreeDemo {

	public static void main(String[] args) {

		BinaryTreeExample binaryTree = new BinaryTreeExample();
		binaryTree.add(90);
		binaryTree.add(80);
		binaryTree.add(40);
		binaryTree.add(60);
		binaryTree.add(10);
		binaryTree.add(100);
		binaryTree.add(25);
		binaryTree.add(1);
		binaryTree.add(99);
		binaryTree.add(154);
		binaryTree.add(58);
		binaryTree.add(14);
		System.out.println("BinaryTree Size: "+binaryTree.getSize());
		binaryTree.printAllTraversal();
		
	}

}
