

public class Growth
{//start

	public static void main(String[] args) 
	{//start
		
		int[]list = {6,13,14,25,33,43,51,53,64,72,84,93,95,96,97};
		int x;
		System.out.println(x=binary(list,33));
		
	}//end
	public static int binary(int[] x, int y)
	{//start
		int lo=0,hi=x.length-1,mid=0;
		while(lo<=hi)
		{//start
			int need=lo + (hi - lo) / 2;
			if(y<x[mid])
			{
				hi=mid-1;
			}
			else if (y>x[mid])
			{
				lo = mid + 1;
			}
			else
			{
				mid=need;
			}
		}//end
		if(mid==y)
		{
			return mid;
		}
		else
		{
			return -1;
		}
		
	}//end
}//end
