package classes;

import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T>{
	private T[] stack;
	private Node top;
	
	public LinkedStack(){
		stack = null;
		top = null;
	}
	
	@Override
	public void push(T anEntry) {
		top = new Node(anEntry, top);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		T newTop = peek();
		assert top.getNext() != null;
		
		return (T) top;
	}

	@Override
	public T peek() {
		if(isEmpty()) {throw new EmptyStackException();}
		
		return top.getData();
	}
	
	@Override
	public boolean isEmpty() {return top == null;}

	@Override
	public void clear() {top = null;}
	
	private class Node {
		private T data;
		private Node next;
		
		public Node(T data, Node next) {this.data = data; this.next = next;}
		public T getData() {return data;}
		public void setData(T data) {this.data = data;}
		public Node getNext() {return next;}
		public void setNext(Node next) {this.next = next;}
	}	
}
