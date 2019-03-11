
public class OrderEvent extends Event
{//start
	private int groupSize;
	//constructor
	public OrderEvent()
	{
		super();
		this.groupSize=0;
	}
	public OrderEvent(int time ,int size)
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
	{
		//each member of group order beer (type 1,2,3)
		for(int i=0;i<groupSize;i++)
		{
			//order(1+randBetween(1,3));
		}
		// schedule a leaveEvent for this group
		// all the group leaves together (left for you)
	}
}//end
