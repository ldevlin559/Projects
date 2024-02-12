package classes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;

public class ButtonBar extends JPanel {
	
	public JButton addTask;
	public JButton clear;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();

	ButtonBar() 
	
	{
		
		this.setPreferredSize(new Dimension(400, 60));
		
		this.add(Box.createHorizontalStrut(5));
		addTask = new JButton("Add Task");
		addTask.setFont(new Font("Sans-serif", Font.PLAIN, 17));
		
		this.add(Box.createHorizontalStrut(5));
		clear = new JButton("Clear Completed Tasks");
		clear.setFont(new Font("Sans-serif", Font.PLAIN, 17));
		
		this.add(addTask);
		this.add(clear); 
		
	}
	
	public JButton getAddTask() {
		
		return addTask;
	}
	
	public JButton getClear() {
		
		return clear;
	}
}
