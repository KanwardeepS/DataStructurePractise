package com.kanwardeeps.practise.tree.binary;

public class BinaryTree {

	private static Node rootNode;

	public static void main( String[] args ) {
		BinaryTree tree = new BinaryTree();
		tree.addNode( 50, "FIFTY" );
		tree.addNode( 25, "TWENTY FIVE" );
		tree.addNode( 15, "FIFTEEN" );
		tree.addNode( 30, "THIRTY" );
		tree.addNode( 75, "SEVENTY FIVE" );
		tree.addNode( 85, "EIGHTY FIVE" );

		inOrderTraverseTree( tree.rootNode );
		//preOrderTraverseTree( tree.rootNode );
		//postOrderTraverseTree( tree.rootNode );
	}

	public static void inOrderTraverseTree( Node focusNode ) {

		if ( focusNode != null ) {
			inOrderTraverseTree( focusNode.leftChild );
			System.out.println( focusNode );
			inOrderTraverseTree( focusNode.rightChild );
		}

	}
	
	public static void preOrderTraverseTree( Node focusNode ) {

		if ( focusNode != null ) {
			System.out.println( focusNode );
			preOrderTraverseTree( focusNode.leftChild );
			preOrderTraverseTree( focusNode.rightChild );
		}

	}
	
	
	public static void postOrderTraverseTree( Node focusNode ) {

		if ( focusNode != null ) {
			
			postOrderTraverseTree( focusNode.leftChild );
			postOrderTraverseTree( focusNode.rightChild );
			System.out.println( focusNode );
		}

	}

	public static void addNode( int key, String name ) {
		Node node = new Node( key, name );

		if ( rootNode == null ) {
			rootNode = node;
		}
		else {
			Node focusNode = rootNode;
			Node parent;

			while ( true ) {
				parent = focusNode;
				if ( key < focusNode.key ) {
					focusNode = focusNode.leftChild;
					if ( focusNode == null ) {
						parent.leftChild = node;
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;
					if ( focusNode == null ) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}

	}
}

class Node {
	int key;
	String name;
	Node leftChild;
	Node rightChild;

	Node( int key, String name ) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return key + "_" + name;
	}
}
