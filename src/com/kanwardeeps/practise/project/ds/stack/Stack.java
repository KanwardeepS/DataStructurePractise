package com.kanwardeeps.practise.project.ds.stack;


public interface Stack {
	
	void push(int value) throws Exception;
	int pop() throws Exception;

	int size();
	int top () throws Exception;
	boolean isEmptyStack();
	
}
