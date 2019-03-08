import java.util.*;

public class simulationFramework 
{//start
	private int currentTime;
	private Queue<Event> eventQ = new PriorityQueue<>();
	//constructor
	public simulationFramework()
	{
		this.currentTime=0;
		eventQ.clear();
	}
	public simulationFramework(int time, Queue<Event> x)
	{
		this.currentTime=time;
		Object[] cop = x.toArray();
		for(int i=0;i<x.size();i++)
		{
			eventQ.add((Event)cop[i]);
		}
	}
	//setter
	public void setCurrentTime(int x)
	{
		currentTime=x;
	}
	public void setEvent(Queue<Event> x)
	{
		Object[] copy = x.toArray();
		for(int i=0;i<x.size();i++)
		{
			eventQ.add((Event)copy[i]);
		}
	}
	//getter
	public int getCurrentTime()
	{
		return currentTime;
	}
	public Queue<Event> getEventQ()
	{
		return eventQ;
	}
	//methods
	public void schduleEvent(ArriveEvent x)
	{
		
	}
	public void run()
	{
		
	}
}//end