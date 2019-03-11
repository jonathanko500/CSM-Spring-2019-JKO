
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
			t+=simulation.randBtw(2,5);//new group every 2-5 min
			simulation.schduleEvent(new ArriveEvent(t,simulation.randBtw(1,5)));//arrive within 2-5 min and rand num of ppl in group 1-5 ppl
			simulation.run();
		}//end loop
	}//end
	
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
	public void order (int beer)
	{
		System.out.println("Serviced order for beer type " + beer + " at time " + simulation.getCurrentTime());
		
	}
}//end
