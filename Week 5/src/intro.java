import java.util.*;

public class intro
{//start

	public static void main(String[] args)
	{
		int x = 10;
		Random rand = new Random();
		int num =rand.nextInt(500);
		int[] a = new int[x];
		for(int i=0;i<x;i++)
		{
			a[i]=num;
			num =rand.nextInt(500);
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);;
		}
		doInsertionSort(a);
		System.out.println("");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static int[] doInsertionSort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}//end