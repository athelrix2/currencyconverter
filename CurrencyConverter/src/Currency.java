
public class Currency implements CurrencyInterface{
	
	private String name;
	private double conversionRate;
	
	public Currency(String name, double conversionRate){
		
		this.name=name;
		this.conversionRate=conversionRate;
	}
	
	public String getName(){
		
		return name;
	}
	
	public double getRate(){
		
		return conversionRate;
	}

	public double convert(double rate) {
		
		return rate/conversionRate;
	}
}
