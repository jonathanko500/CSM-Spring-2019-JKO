import java.util.*;

public class PQprac {

	public static void main(String[] args) 
	{
		Queue <Integer> prac = new PriorityQueue<>();
		Queue <Integer> prac2 = new PriorityQueue<>();
		prac.add(5);
		prac.add(6);
		prac.add(7);
		prac.add(8);
		prac2.addAll(prac);
		Object[] arr = prac2.toArray();
		//1 way to print
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("***************");
		//1 way to print
		for(int i=0;i<prac2.size();i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("***************");
		System.out.println(prac.poll());
		System.out.println(prac.peek());
		prac.remove();
		System.out.println(prac.poll());
		System.out.println(prac.peek());
		System.out.println("***************");
		Queue <Integer> prac3 = copy(prac2);
		Object[] arr2 = prac3.toArray();
		for(int i=0;i<prac3.size();i++)
		{
			System.out.println(arr2[i]);
		}
	}
	public static Queue<Integer> copy(Queue<Integer> x)
	{
		Object[] cop = x.toArray();
		Queue<Integer> copied = new PriorityQueue<>();
		for(int i=0;i<x.size();i++)
		{
			copied.add((Integer)cop[i]);
		}
		return copied;
	}

}
