
public interface CurrencyInterface {
	
	String getName();
	
	double getRate();
	
	double convert(double rate);
	
	void setBase(double base);
}
