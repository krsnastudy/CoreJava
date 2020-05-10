package com.prac.core.tree.binarytree;

class Node {
    int value;
    Node left;
    Node right;
 
    public Node(int value) {
        this.value = value;
    }

	@Override
	public String toString() {
		return "Node("+value+") [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
    
    
}