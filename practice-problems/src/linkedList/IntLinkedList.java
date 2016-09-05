package linkedList;

import java.util.ArrayList;

public class IntLinkedList {
	LinkedListNode head;
	
	public IntLinkedList() {
		head = null;
	}
	
	public IntLinkedList(LinkedListNode head) {
		this.head = head;
	}
	
	public IntLinkedList(Integer[] arr) {
		for (int i=arr.length - 1; i >= 0; i--) {
			this.addToBeginning(arr[i]);
		}
	}
	
	private void addToBeginning(int val) {
		LinkedListNode newHead = new LinkedListNode(val, null);
		newHead.next = head;
		head = newHead;
	}
	
	private class LinkedListNode {
		int val;
		LinkedListNode next;
		public LinkedListNode(int val, LinkedListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public IntLinkedList reverse() {
		LinkedListNode prev = head;
		LinkedListNode current;
		LinkedListNode next;
        if (head == null || head.next == null) {
            return new IntLinkedList(head);
        }
        current = head.next;
        next = head.next.next;
        prev.next = null;
        current.next = prev;
        while (next != null) {
            prev = current;
            current = next;
            next = next.next;
            current.next = prev;
        }
        return new IntLinkedList(current);
    }
	
	public boolean isPalindrome() {
		LinkedListNode reversed = this.reverse().head;
		LinkedListNode ptr = head;
		LinkedListNode reversedPtr = reversed;
        while (ptr != null) {
            if (ptr.val != reversedPtr.val) {
                return false;
            }
            ptr = ptr.next;
            reversedPtr = reversedPtr.next;
        }
        return true;
    }
	
	public String toString() {
		StringBuilder toReturn = new StringBuilder("");
		LinkedListNode temp = head;
		while (temp != null) {
			toReturn.append("[");
			toReturn.append(temp.val);
			toReturn.append("]");
			if (temp.next != null) {
				toReturn.append(" -> ");
			}
			temp = temp.next;
		}
		return toReturn.toString();
	}
	
	public Integer[] toArray() {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		LinkedListNode temp = head;
		int count = 0;
		while(temp != null) {
			arrList.add(temp.val);
			temp = temp.next;
			count++;
		}
		return arrList.toArray(new Integer[count]);
	}
}
