
public class Stock
{
	private String comp;
	private int numShare;
	private double purPrice, currPrice;
	//constructors
	public Stock()
	{
		comp = "No company name;";
		numShare=0;
		purPrice=0.0;
		currPrice=0.0;
	}
	public Stock (String name, int share, double pur,double curr)
	{
		comp = name;
		numShare=share;
		purPrice=pur;
		currPrice=curr;
	}
	//setter
	public void setCompName(String name)
	{
		comp = name;
	}
	public void setnumShare(int share)
	{
		numShare=share;
	}
	public void setPurPrice(double pur)
	{
		purPrice=pur;
	}
	public void setCurrPrice(double curr)
	{
		currPrice=curr;
	}
	//getter
	public String getCompName()
	{
		return comp;
	}
	public int getNumShare()
	{
		return numShare;
	}
	public double getPurPrice()
	{
		return purPrice;
	}
	public double getCurrPrice()
	{
		return currPrice;
	}
	//toSring
	public String ToString()
	{
		return (numShare+" shares of "+ comp);
	}
	//getVal
	public double getValue()
	{
		return numShare*(currPrice-purPrice);
	}
	
}
