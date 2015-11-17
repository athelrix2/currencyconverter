import java.util.ArrayList;

import javax.swing.JFrame;

public class Tester extends JFrame {
	
	private ArrayList<Currency> dineros;
	private JsonCurrency j;
	
	public Tester(){
		
		j=new JsonCurrency();
		getAll();
		update();
	}
	public void getAll(){
		
		dineros=j.getList();
	}
	
	public void update(){
		
		j.getText();
	}
	public static void main(String[] args){
		new Tester();
	}
	
	
}
