
public class leaveEvent extends Event
{//start
	private int groupSize;
	///constructor
	public leaveEvent()
	{
		super();
		this.groupSize=0;
	}
	public leaveEvent(int x, int size)
	{
		super(x);
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
	public void processEvent ()
	{ 
		leave(groupSize); 
	}
	public void leave(int x)
	{
		
	}
}//end
