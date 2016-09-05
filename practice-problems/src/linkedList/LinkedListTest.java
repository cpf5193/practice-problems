package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testCreate() {
		Integer[] input = {1, 4, 2, 6, 7, 3, 4, 2};
		IntLinkedList list = new IntLinkedList(input);
		assertArrayEquals(input, list.toArray());
		assertTrue("[1] -> [4] -> [2] -> [6] -> [7] -> [3] -> [4] -> [2]".equals(list.toString()));
	}
	
	@Test
	public void testReverse() {
		Integer[] input = {1, 4, 2, 6, 7, 3, 4, 2};
		Integer[] expected = {2, 4, 3, 7, 6, 2, 4, 1};
		IntLinkedList list = new IntLinkedList(input);
		IntLinkedList reversed = list.reverse();
		assertArrayEquals(expected, reversed.toArray());
		assertTrue("[2] -> [4] -> [3] -> [7] -> [6] -> [2] -> [4] -> [1]".equals(reversed.toString()));
	}
	
	@Test
	public void testPalindrome() {
		Integer[] input1 = {};
		Integer[] input2 = {1};
		Integer[] input3 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		Integer[] input4 = {1, 2, 3, 3, 2, 1};
		Integer[] input5 = {1, 2, 3, 3, 2, 1, 0};
		Integer[] input6 = {3, 4, 1, 4, 2, 1, 5, 6, 0};
		IntLinkedList list1 = new IntLinkedList(input1);
		IntLinkedList list2 = new IntLinkedList(input2);
		IntLinkedList list3 = new IntLinkedList(input3);
		IntLinkedList list4 = new IntLinkedList(input4);
		IntLinkedList list5 = new IntLinkedList(input5);
		IntLinkedList list6 = new IntLinkedList(input6);
		boolean[] expected = {true, true, true, true, false, false};
		boolean[] actual = {list1.isPalindrome(), list2.isPalindrome(), list3.isPalindrome(), list4.isPalindrome(), list5.isPalindrome(), list6.isPalindrome()};
		assertArrayEquals(expected, actual);
	}

}
