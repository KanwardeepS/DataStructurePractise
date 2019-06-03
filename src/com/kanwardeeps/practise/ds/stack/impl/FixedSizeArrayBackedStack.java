package com.kanwardeeps.practise.ds.stack.impl;

import com.kanwardeeps.practise.project.ds.stack.Stack;

public class FixedSizeArrayBackedStack implements Stack {
	
	//Default capacity
	private static int CAPACITY = 10;

	//top pointing to -1, referring to empty stack
	private static int top = -1;

	//array backed Stack
	private static int[] fixedArray;

	//default constructor, initializing the array to default capacity of 10
	public FixedSizeArrayBackedStack() {
		fixedArray = new int[CAPACITY];
	}

	// constructor to initialize the array to any  value of our choice
	public FixedSizeArrayBackedStack( int capacity ) {
		CAPACITY = capacity;
		fixedArray = new int[CAPACITY];
	}

	/*
	 * method to check if the stack is empty or not
	 * @see com.kanwardeep.practise.project.ds.stack.Stack#isEmptyStack()
	 */
	public boolean isEmptyStack() {
		return ( top < 0 );
	}

	/*
	 * method to check the size of the stack
	 * @see com.kanwardeep.practise.project.ds.stack.Stack#size()
	 */
	public int size() {
		return ( top + 1 );
	}

	/*
	 * method to check the topmost element on the stack, throws Exception is Stack is empty
	 * @see com.kanwardeep.practise.project.ds.stack.Stack#top()
	 */
	public int top() throws Exception {
		if ( isEmptyStack() )
			throw new Exception( "Stack is empty" );
		return fixedArray[top];
	}

	/*
	 * Method to add an element to the stack which is added on top of the Stack
	 * throws Stack Overflow exception, if Stack is already full
	 * @see com.kanwardeep.practise.project.ds.stack.Stack#push(int)
	 */
	public void push( int data ) throws Exception {
		if ( size() == CAPACITY ) {
			throw new Exception( "Stack Overflow" );
		}
		else {
			fixedArray[++top] = data;
		}
	}
	
	
	/*
	 * 
	 * Removes the topmost element in the stack and decrement the top pointer
	 * @see com.kanwardeep.practise.project.ds.stack.Stack#pop()
	 */
	public int pop() throws Exception {
		int data;
		if ( isEmptyStack() ) {
			throw new Exception( "Stack is empty" );
		}
		else {
			data = fixedArray[top];
			fixedArray[top--] = Integer.MIN_VALUE;
			return data;
		}
	}

	
	/**
	 * to print all the elements in the stack
	 */
	public String toString() {
		String returnString = "[ ";
		if ( size() > 0 ) {
			returnString += fixedArray[0];
		}
		if ( size() > 1 ) {
			for ( int index = 1; index < size(); index++ ) {
				returnString += " " + fixedArray[index];
			}
			returnString+=" ]";
		}
		return returnString;
	}

}
