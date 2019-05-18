
public abstract class Bucket 
{//start class
	
	private Vertexs point;//vertex being looked at
	//constructor
	public Bucket(Vertexs dot)
	{
		point = dot;
	}
	//setter
	public void setPoint(Vertexs dot)
	{
		point = dot;
	}
	//getter
	public Vertexs getPoint()
	{
		return point;
	}
}//end class
