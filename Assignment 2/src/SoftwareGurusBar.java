
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
	private int randBtw(int x, int y)//random # between two values
	{
		return x + (int) ((y - x + 1) * Math.random());
	}
	public boolean canSeat(int numPpl)//seating for more "events"
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
	public void order (int beer)//make profit from select beers
	{
		System.out.println("Serviced order for beer type " + beer + " at time " + simulation.getCurrentTime());
		switch(beer)
		{//start switch
		 case 1:
			 //beer #1
			 profit += 2; 
			 break;	
		 case 2: 
			 //beer #2
			 profit += 3; 
			 break;	
		 case 3: 
			 //beer #3
			 profit += 4; 
			 break;	
		 default:
			 System.out.println("No other options. Pick again.");
			 break;
		}//end switch
		System.out.println("Updated profit is "+profit);
		
	}
}//end
