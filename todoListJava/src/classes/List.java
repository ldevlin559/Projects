 package classes;

 import javax.swing.JPanel;
 import java.awt.GridLayout;
 import java.awt.Component;
 
public class List extends JPanel{

	List() 
	
	{
		
		GridLayout layout = new GridLayout(10, 2);
		layout.setVgap(3);
		
		this.setLayout(layout);
		
	}
	
	public void removeCompletedTasks() {
		for (Component c : getComponents()) {
			if (c instanceof Task) {
				if (((Task)c).getState()) {
					remove(c);
				}
			}
		}
	}
}
