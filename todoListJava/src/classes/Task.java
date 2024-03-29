 package classes;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Task extends JPanel {
	
	private JLabel index;
	private JTextField taskName;
	private JButton done;
	
	private boolean checked;
	
	Task() 
	
	{
		
		this.setPreferredSize(new Dimension(40, 20));
		
		this.setLayout(new BorderLayout());
		
		checked = false;
		
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20, 20));
		index.setHorizontalAlignment(JLabel.CENTER);
		this.add(index, BorderLayout.WEST);
		
		
		taskName = new JTextField("Task");
		taskName.setBorder(BorderFactory.createEmptyBorder());	
		
		this.add(taskName, BorderLayout.CENTER);
		
		done = new JButton("done");
		done.setPreferredSize(new Dimension(40, 70));
		done.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(done, BorderLayout.EAST);
		
	}
	
	public JButton getDone() 
	
	{
		return done;
	}
	
	public boolean getState() 
	
	{
	    return checked;
	}
	
	public void changeState() 
	
	{
	    this.setBackground(Color.GREEN);
	    taskName.setBackground(Color.GREEN);
	    checked = true;
	    revalidate();
	}
	
}
