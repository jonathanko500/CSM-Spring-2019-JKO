
public class Observation
{//start
	public static void main (String[]args)
	{//start
		int[] list = {30,-40,-20,-10,40,0,10,5};
		System.out.println(countForce(list));
		
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
