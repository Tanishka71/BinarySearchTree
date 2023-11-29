package com.bridgelabz.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySTTest {
    BinaryST<Integer> obj=new BinaryST<>();
	@Test
	void test() {
		 obj.add(56);
	     obj.add(30);
	     obj.add(70);
		int s=obj.getRoot().size();
		assertEquals(3,s, 
				"Gives the size of the obj: ");
	}

}
