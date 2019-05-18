
public class BucketOfVertex extends Bucket
{//start class
	private int length;
	private int edgeCounter;
	//constructor
	public BucketOfVertex(Vertexs point)
	{
		super(point);
	}
	//setter
	public void setLength(int num)
	{
		length=num;
	}
	public void setEdgeCounter(int num)
	{
		edgeCounter=num;
	}
	//getter
	public int getLength()
	{
		return length;
	}
	public int getEdgeCounter()
	{
		return edgeCounter;
	}
	//edge counter changer
	public void incEdgeCounter()
	{
		edgeCounter++;
	}
	public void decEdgeCounter()
	{
		edgeCounter--;
	}
}//end class
