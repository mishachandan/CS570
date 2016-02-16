package weather;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Application {
	
	  public static void main(String[] args){
		  
		  SwingUtilities.invokeLater(new Runnable(){
			  public void run() {
		  
		  JFrame frame = new MainFrame("weather");
		  frame.setSize(350,500);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
		  });
	  }
}
