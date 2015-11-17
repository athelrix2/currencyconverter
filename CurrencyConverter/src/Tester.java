import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Tester extends JFrame {
	
	private ArrayList<Currency> dineros;
	private JsonCurrency j;
	private Window win;
	
	public Tester(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		j=new JsonCurrency();
		getAll();
		update();
		win=new Window(dineros);
		setSize(new Dimension(500,200));
		add(win);
		setVisible(true);
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
