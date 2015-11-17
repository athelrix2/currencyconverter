
public class Currency implements CurrencyInterface{
	
	private String name;
	private double conversionRate,baseNumber;
	
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
		
		return conversionRate/baseNumber*rate;
	}
	public void setBase(double base){
		
		this.baseNumber = base;
	}
}
