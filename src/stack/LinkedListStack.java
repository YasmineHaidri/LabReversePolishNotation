package stack;

import java.util.ArrayList;

public class LinkedListStack<E> implements Stack<E> {
	int max = 10;

	ArrayList<E> list = new ArrayList<>(max);

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E top() throws Underflow  {
		try{
		E curr = list.get(list.size()-1);
			return curr;}
		catch (IndexOutOfBoundsException exception){
			throw new Underflow();
		}
	}

	@Override
	public void push(E element) throws Overflow {
		if(getSize()+1== max)
			throw new Overflow();
		else
			list.add(element);
		
	}

	@Override
	public E pop() throws Underflow {
		try{
		E curr = list.get(getSize());
			list.remove(curr);
			return curr;}
		catch (IndexOutOfBoundsException exception){
			throw new Underflow();
		}
	}
	@Override
	public String toString(){
		return list.toString();
	}
	public int getSize()
	{
		return list.size()-1;
	}

}
