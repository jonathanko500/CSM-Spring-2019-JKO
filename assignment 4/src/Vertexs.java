
public class Vertexs
{//start class
	
	private int verIndex;
	private String name;
	private boolean check;
	//constructors
	public Vertexs()
	{
		verIndex=0;
		name="No name of event.";
		check=false;
	}
	public Vertexs(int num, String title, boolean valid)
	{
		verIndex=num;
		name=title;
		check=valid;
	}
	//setter
	public void setVertexInex(int num)
	{
		verIndex=num;
	}
	public void setName(String title)
	{
		name=title;
	}
	public void setCheck(boolean valid)
	{
		check=valid;
	}
	//getter
	public int getVertexIndex()
	{
		return verIndex;
	}
	public String getName()
	{
		return name;
	}
	public boolean getCheck()
	{
		return check;
	}
	
}//end class
