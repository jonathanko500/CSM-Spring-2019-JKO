import java.util.*;

public class Arrays<X> implements Stacks<X>
{//start class
	private int max;
	private int size;
	private X[] array;
	//overrides
	@Override
	public boolean isEmpty()
	{
		if (size!=1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean isFull()
	{
		if(max == (size+1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public void makeEmpty()
	{
		size = -1;
	}
	@Override
	public X peek()
	{
		if(isEmpty()==true)
		{
			return array[size];
		}
		else
		{
			throw new EmptyStackException();
		}
	}
	@Override
	public void push(X obj)
	{
		if(isFull()==true)
		{//check to see if array is full
			array = (X[]) new Object[max*2];
			max= max*2;
			push(obj);
		}
		else
		{
			size++;
			array[size]=obj;
		}
	}
	@Override
	public X pop()
	{
		if(isEmpty() == false)
		{//return poped value
			X target = array[size];
			array[size--] = null;
			return target;
		}
		if(size < (max/2))
		{//check for value to pop
			array = (X[]) new Object[max/2];
			return pop();
		}
		else
		{
			throw new EmptyStackException();
		}
	}
	//constructor
	public Arrays()
	{
		max=0;
		array = (X[]) new Object[max];
		size=-1;
	}
	public Arrays(int num, int area)
	{//start
		if (num<1)
		{//start if
			throw new IllegalArgumentException("Array should 1 or more");			
		}//end if
		max = num;
		array = (X[]) new Object[num];
		size = area;
	}//end
	//getters
	public int getSize()
	{
		return (size+1);
	}
	public Object[] getArray()
	{
		return array;
	}
	public X getElementOfArray(int x)
	{
		return array[x];
	}
}//end class
