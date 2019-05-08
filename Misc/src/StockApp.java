import java.util.Scanner;

public class StockApp
{//start class

	public static void main(String[] args) 
	{//start main
		Scanner input = new Scanner(System.in);
		int numStock;
		//check for valid num of stock
		System.out.print("How many stocks: ");
		numStock=Integer.parseInt(input.nextLine());
		while(numStock<1)
		{
			System.out.print("Must more than 1, re-enter: ");
			numStock=Integer.parseInt(input.nextLine());
		}
		System.out.println("");
		Stock[] list = new Stock[numStock];
		getData(list);
		printPor(list);
	
		
	}//end main
	public static void getData(Stock[] list)
	{
		String name;
		int share;
		double purr, curr;
		Scanner input = new Scanner(System.in);
		for (int i=0;i<list.length;i++)
		{
			System.out.print("Enter company name: ");
			name=input.nextLine();
			System.out.print("enter number of shares: ");
			share=Integer.parseInt(input.nextLine());
			System.out.print("Enter purchase price: ");
			purr=Double.parseDouble(input.nextLine());
			System.out.print("Enter current price: ");
			curr=Double.parseDouble(input.nextLine());
			list[i]= new Stock(name,share,purr,curr);
			System.out.println("");
		}
	}
	public static void printPor(Stock[] list)
	{
		System.out.println("report");
		System.out.println("Stock                    Value");
		for(int i=0;i<list.length;i++)
		{
			System.out.println(list[i].ToString()+"          "+list[i].getValue());
		}
	}

}//end class
