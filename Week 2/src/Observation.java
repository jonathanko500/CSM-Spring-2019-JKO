import java.util.Random;
import java.util.Scanner;
public class Observation
{//start
	public static void main (String[]args)
	{//start
		//int[] list = {30,-40,-20,-10,40,0,10,5};
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		boolean cont = true;
		int[] list2;
		int num=rand.nextInt(100000),num2,length,counter=0;
		System.out.print("How big of list do you want?: ");
		length=Integer.parseInt(scan.nextLine());
		int[] list3 = new int[length];
		/*
		for(int i=0;i<list3.length;i++)
		{
			list3[i]=num;
			System.out.println(list3[i]);
			num=rand.nextInt(100000);
		}
		*/
		list2= new int[length];
		while(cont==true)
		{//keep asking for number
			System.out.print("Enter number: ");
			num2=Integer.parseInt(scan.nextLine());
			for(int i=0;i<list2.length;i++)
			{//add to num to array
				list2[counter]=num;
			}//end
			counter++;
			if(counter==list2.length)
			{//stop asking for num
				cont=false;
			}//end
		}//end
		System.out.println(countForce(list2));
	}//end
	public static int countForce (int[] x)
	{//start
		int y=x.length;
		int num=0;
		for (int i=0;i<y;i++)
		{//start
			for(int j=i+1;j<y;j++)
			{//start
				for(int k=j+1;k<y;k++)
				{//start
					if(x[i]+x[j]+x[k]==0)
					{
						num++;
					}
				}//end
			}//end
		}//end
		return num;
	}//end
}//end