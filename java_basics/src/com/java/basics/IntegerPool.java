package com.java.basics;

/**
 * Integer pool in detail
 * 
 * @author Ashamol
 *
 */
public class IntegerPool {

	public static void main(String[] args) {
		int i1 = 1000;
		Integer i2 = 1000;
		Integer i3 = 1000;
		System.out.println(i1==i2);// true since i1 in primitive and i2 is wrapper, unboxing happens and compared
		System.out.println(i2==i1);// true since i1 in primitive and i2 is wrapper, unboxing happens and compared
		//Note: which ever is lower, ie; compared to wrapper, primitive is primary and unboxing happended.
		
		System.out.println(i2.equals(i1));//equals() internally checks for valueOf of input i1. 
		//While calling equals, boxing happened to i1. So, gets valueOf(i1) inside equals() and returns true
		
		System.out.println("i2==i3 : " + (i2==i3));// i2 and i3 are wrapper. Not autoboxing. Direct == ie; memory location check happens
		//and false comes as both are separate instances in heap and not exists in pool since > 127
		
		System.out.println("i2==1000 : " + (i2==1000));//here unboxing happends and then checks for equality. So, becomes int and == true.
		
		Integer i4 = 127;
		Integer i5 = 127;
		System.out.println("i4==i5 : " + (i4==i5));//comes as true since 127 in within integer pool. If its 128, 
		//result will be false as in case of i2==i3. In direct assigning of int to Integer, Integer.valueOf(int) used to box it.
		//This method checks in cache first. I found, return it from cache, else creates new instance.
		//For 127, its in cache, so both call to valueOf() returned same address. But if > 127 or < -128, new object gets created
		// in heap.
		System.out.println(i2.equals(i3));// equals() called, valueOf() happens and comes equal. Since "int value" inside i2
		//is equal to valueOf(i3) which is also an int.
		
		System.out.println(++i4 == ++i5);
		
		Integer i6 = 127;
		i6 = i6 + 20;
		
		System.out.println(i6 == 147);//>127, Integer.valueOf(i6) + 20 happened and assigned to Integer by again boxing.
		//Now when checks, unboxed and checked. So matches, true.
		System.out.println(i6-20 == 127);// Same as in above.

	}

}
