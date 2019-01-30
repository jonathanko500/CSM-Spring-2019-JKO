import java.util.Stack;

public class StackEX 
{//start
	public static void main(String[] args)
	{//start
		Stack stack = new Stack();
		stack.add("to");
		stack.add("be");
		stack.add("or");
		stack.add("not");
		stack.add("to");
		stack.add("-");
		stack.add("be");
		stack.add("-");
		stack.add("-");
		stack.add("that");
		stack.add("-");
		stack.add("-");
		stack.add("-");
		stack.add("is");
		for(int i=0;i< stack.size();i++)
		{//looks through stack
			if(stack.get(i).equals("-"))
			{//determines if string is "-"
				System.out.println(stack.pop());
			}//end
			else
			{
				System.out.println(stack.get(i));
			}
		}//end loop
		System.out.println("********************");
		for(int i=0;i< stack.size();i++)
		{//looks through stack
			System.out.print(stack.get(i)+" ");	
		}//end loop
	}//end
}//end
