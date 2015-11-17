import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JPanel implements ActionListener{
	
	private ArrayList<Currency> list;
	private JComboBox<String> dd1,dd2;
	private JButton button;
	private JLabel lab;
	private FlowLayout flow;
	private JTextField text;
	
	public Window(ArrayList<Currency> list){
		setPreferredSize(new Dimension(1000,1000));
		
		text=new JTextField("0");
		text.setPreferredSize(new Dimension(300,50));
		
		flow=new FlowLayout();
		flow.preferredLayoutSize(this);
		
		this.list=list;
		
		button = new JButton("enter");
		button.setSize(new Dimension(500,200));
		button .addActionListener(this);
		
		dd1=new JComboBox<String>();
		dd2=new JComboBox<String>();
		for(Currency c : list){
			String name = c.getName();
			dd1.addItem(name);
			dd2.addItem(name);
		}
		
		lab=new JLabel();
		
		
		add(text,flow);
		add(dd1,flow);
		add(dd2,flow);
		add(lab,flow);
		add(button,flow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean found1 = false, found2 = false;
		
		String one= (String) dd1.getSelectedItem(),two=(String)dd2.getSelectedItem();
		
		int i =0,k=0;
		
		while(found1 == false){
			if (one.equals(list.get(i).getName())){
				found1=true;
			}
			else{
				i++;
			}
			
		}
		while(found2==false){
			if (two.equals(list.get(k).getName())){
				found2=true;
			}
			else{
				k++;
			}
		}
		double answer=Double.parseDouble(text.getText())* list.get(i).convert(list.get(k).getRate());
		lab.setText(Double.toString(answer));
	}
}
