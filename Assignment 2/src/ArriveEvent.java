
public class ArriveEvent extends Event
{//start
	private SoftwareGurusBar world = new SoftwareGurusBar ();
	private simulationFramework simulation = new simulationFramework();
	private int groupSize;
	//constructor
	public ArriveEvent()
	{
		super();
		this.groupSize=0;
	}
	public ArriveEvent(int time ,int size)
	{
		super(time);
		this.groupSize=size;
	}
	//setter
	public void setGroupSize(int size)
	{
		this.groupSize=size;
	}
	//getter
	public int getGroupSize()
	{
		return groupSize;
	}
	//toString
	@Override
	public String toString()
	{
		String x="";
		x="The time is "+getTime()+" the gorup size is "+groupSize;
		return x;
	}
	public void processEvent()
	{//start
		if(world.canSeat(groupSize))//place order within 2-10 min
		{
			simulation.schduleEvent(new OrderEvent(getTime()+simulation.randBtw(2,10),groupSize));
		}
	}//end
	
}//end
