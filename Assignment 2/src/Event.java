
public abstract class Event implements Comparable
{//start
	
	public int time;
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
	//methods
	abstract void processEvent();
	public int compareTo (Object o) 
	{
		Event right = (Event) o;
		if (time < right.time) return -1;
		if (time == right.time) return 0;
		return 1;
	}
}//end
