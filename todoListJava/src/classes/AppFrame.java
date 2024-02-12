package classes;

import java.awt.BorderLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
	
	private TitleBar title;
	private List list;
	private ButtonBar btnBar;
	
	private JButton addTask;
	private JButton clear;
	
	// Contructor
	
	AppFrame() 
	
	{
		
		this.setSize(400, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		title = new TitleBar();
		list = new List();
		btnBar = new ButtonBar();
		
		this.add(title, BorderLayout.NORTH);
		this.add(btnBar, BorderLayout.SOUTH);
		this.add(list, BorderLayout.CENTER);
		
		addTask = btnBar.getAddTask();
		clear = btnBar.getClear();
		
		addListeners();
		
		this.setVisible(true);
		
		
	}


	public void addListeners()
	
	{
		addTask.addMouseListener(new MouseAdapter() {
		       @override
	            public void mousePressed(MouseEvent e) {
	                final Task task = new Task();
	                list.add(task); // Add new task to list
	                revalidate();
	                
	                task.getDone().addMouseListener(new MouseAdapter() {
	                    @override
	                    public void mousePressed(MouseEvent e) {
	                  
	                        task.changeState(); // Change color of task
	                        revalidate();
			
	                    }
	                });
		       }       
		});
		
	     clear.addMouseListener(new MouseAdapter() {
	            @override
	            public void mousePressed(MouseEvent e) {
	                list.removeCompletedTasks(); // Removes all tasks that are done
	                repaint(); // Repaints the list
	                
	            }
	        });
	    }		
		
		
}