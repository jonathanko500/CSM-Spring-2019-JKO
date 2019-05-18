
public class Edge 
{//start class
	
	private int edgeValue;
	private int edgeLength;
	//constructor
	public Edge()
	{
		edgeValue=0;
		edgeLength=0;
	}
	public Edge(int val, int length)
	{
		edgeValue=val;
		edgeLength=length;
	}
	//setter
	public void setEdgeValue(int val)
	{
		edgeValue=val;
	}
	public void setEdgeLength(int length)
	{
		edgeLength=length;
	}
	//getter
	public int getEdgeValue()
	{
		return edgeValue;
	}
	public int getEdgeLength()
	{
		return edgeLength;
	}
	
}//end class
