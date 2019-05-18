

public interface Stacks<X>
{//start interface
	public boolean isEmpty();
	public boolean isFull();
	public void makeEmpty();
	public X peek();
	public void push(X obj);
	public X pop();
}//end interface
