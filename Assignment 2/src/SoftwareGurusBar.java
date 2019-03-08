
public class SoftwareGurusBar 
{//start
	private int freeChairs = 50;
	private double profit = 0.0;
	private simulationFramework simulation = new simulationFramework();
	public static void main(String[] args)
	{//start
		SoftwareGurusBar world = new SoftwareGurusBar ();
	}//end
	public SoftwareGurusBar()
	{//start
		int t=0;
		while(t<240)//4 hours of operation
		{//start loop
			t+=randBtw(2,5);//new group every 2-5 min
			simulation.schduleEvent(new ArriveEvent(t,randBtw(1,5)));//arrive within 2-5 min and rand num of ppl in group 1-5 ppl
			simulation.run();
		}//end loop
	}//end
	private int randBtw(int x, int y)
	{
		return x + (int) ((y - x + 1) * Math.random());
	}
	public boolean canSeat(int numPpl)
	{//start
		System.out.println("Group of " + numPpl + " customers arrives at time " + simulation.getCurrentTime());
		if (numPpl < freeChairs)
		{//start if
			System.out.println("Group is seated");
			freeChairs -= numPpl;
			return true;
		}//end if
		else
		{//start else
			System.out.println("No Room, Group Leaves");
			return false;
		}//end else
	}//end
}//end
