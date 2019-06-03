package com.kanwardeeps.practise.ds.stack.test;

import com.kanwardeeps.practise.ds.stack.impl.FixedSizeArrayBackedStack;

public class StackTesting {

	
	public static void main(String [] args) {
		
		FixedSizeArrayBackedStack stack = new FixedSizeArrayBackedStack();
		try {
			stack.push( 10 );
			stack.push( 43 );
			stack.push( 14 );
			stack.push( 23 );
			System.out.println( stack.top() );
			System.out.println( stack.toString() );
			stack.pop();
			stack.push( 17 );
			stack.push( 76 );
			stack.pop();
			System.out.println( stack.top() );
			stack.pop();
			System.out.println( stack.toString() );
		}
		catch ( Exception l_ex ) {
			// TODO Auto-generated catch block
			l_ex.printStackTrace();
		}
	}
}
