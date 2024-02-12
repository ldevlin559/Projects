package classes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;  

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel {
	
	TitleBar() 
	
	{
			
		this.setPreferredSize(new Dimension(400,50));
		
		JLabel titleText = new JLabel("To Do List");
		titleText.setPreferredSize(new Dimension(200, 40));
		titleText.setFont(new Font("Sans-serif", Font.BOLD, 30));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(titleText);
	}
}

