import java.util.*;

public class Testing
{

	public static void main(String[] args)
	{
		
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		//int PathOrWall1=rand.nextInt(2);
		int PathOrWall2 = 0;
		PathOrWall2=randNum(PathOrWall2);
		String ans = null;
		boolean pass=true;
		
		while(pass==true)
		{
			//System.out.println(PathOrWall1);
			System.out.println(PathOrWall2);
			System.out.print("Cont: ");
			ans=scan.nextLine();
			if(ans.equalsIgnoreCase("n"))
			{
				pass=false;
			}
			
			else
			{
				PathOrWall2=randNum(PathOrWall2);
				//PathOrWall1=rand.nextInt(2);
			}
			
		}
		

	}
	public static int randNum(int num)
	{
		Random rand = new Random();
		double f=rand.nextDouble();
		if(f<0.75)
		{
			num=0;
		}
		else
		{
			num=1;
		}
		return num;
	}

}
