import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Window extends JPanel implements ActionListener{
	
	private ArrayList<Currency> list;
	private JComboBox dd1,dd2;
	private JButton button;
	
	public Window(ArrayList<Currency> list){
		
		this.list=list;
		
		button = new JButton();
		button.setSize(new Dimension(200,100));
		button .addActionListener(this);
		
		for(Currency c : list){
			String name = c.getName();
			dd1.addItem(name);
			dd2.addItem(name);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean found = false;
		String one= (String) dd1.getSelectedItem(),two=(String)dd2.getSelectedItem();
		while(found == false){
			if (one.equals(list.get))
		}
	}
}
