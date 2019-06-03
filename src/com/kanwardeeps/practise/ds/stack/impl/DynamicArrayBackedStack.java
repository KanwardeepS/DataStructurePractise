package com.kanwardeeps.practise.ds.stack.impl;

import com.kanwardeeps.practise.project.ds.stack.Stack;

public class DynamicArrayBackedStack implements Stack {

	//length of array used to implement the stack
	protected int capacity;
	//default array capacity
	public static final int CAPACITY = 16; //power of 2
	public static int MINCAPACITY = 1 << 15;

	//array used to implement stack
	protected int[] array;

	protected int top = -1;

	public DynamicArrayBackedStack() {
		this( CAPACITY );
	}

	public DynamicArrayBackedStack( int p_capacity ) {
		capacity = p_capacity;
		array = new int[capacity];
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

	public int top() throws Exception {
		if ( isEmptyStack() ) {
			throw new Exception( "Stack is empty" );
		}
		else {
			return array[top];
		}
	}
	
	public void push( int p_value ) throws Exception {
		if(size()==capacity) {
			increaseArraySize();
		}
		array[++top]= p_value;
	}
	/*
	 * method to double the array size dynamically which is backing the Stack,when Stack is full
	 */
	private void increaseArraySize() {
		int currentSize = size();
		int newArray [] = new int [currentSize<<1];
		System.arraycopy( array, 0, newArray,0 , currentSize );
		array = newArray;
		this.capacity = this.capacity<<1;
	}

	public int pop() throws Exception {
		if(isEmptyStack()) {
			throw new Exception("Stack is empty");
		}
		int data;
		data = array[top];
		array[top--] = Integer.MIN_VALUE;
		shrinkArray();
		return data;
	}

	//dynamic array operation : shrinks to 1/2 if more than 3/4 empty
	private void shrinkArray() {
		int length = top+1;
		if(length<=MINCAPACITY || top<<2 >=length) {
			return;
		}
		length=length +(top<<1);
		if(top<MINCAPACITY) length = MINCAPACITY;
		int [] newArray = new int [length];
		System.arraycopy( array, 0, newArray, 0, top+1 );
		array = newArray;
		this.capacity = length;
	}

	/**
	 * to print all the elements in the stack
	 */
	public String toString() {
		String returnString = "[ ";
		if ( size() > 0 ) {
			returnString += array[0];
		}
		if ( size() > 1 ) {
			for ( int index = 1; index < size(); index++ ) {
				returnString += " " + array[index];
			}
			returnString += " ]";
		}
		return returnString;
	}

}
