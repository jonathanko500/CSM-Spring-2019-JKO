
public class Event
{//start
	private int time;
	//constructors
	public Event()
	{
		this.time=0;
	}
	public Event(int x)
	{
		this.time=x;
	}
	//setter
	public void setTime(int x)
	{
		time=x;
	}
	//getter
	public int getTime()
	{
		return time;
	}
	//toString
	@Override
	public String toString()
	{
		String x="";
		x="The time is "+time;
		return x;
	}
}//end
