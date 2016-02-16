package weather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	 private DetailsPanel DetailsPanel;
	 
	 public MainFrame(String title){
	 super(title);
	 
	
		        
		        // Set layout manager
		        setLayout(new BorderLayout());
		        
		        // Create Swing component
		        final JTextArea textArea = new JTextArea();

		        DetailsPanel = new DetailsPanel();
		        
		        DetailsPanel.addDetailListener(new DetailListener() {
		            public void detailEventOccurred(DetailEvent event) {
		                String text = event.getText();
		                
		                textArea.append(text);
		            }
		        });
		        
		        // Add Swing components to content pane
		        Container c = getContentPane();
		        
		        c.add(textArea, BorderLayout.CENTER);
		      //  c.add(Button, BorderLayout.SOUTH);
		        c.add(DetailsPanel, BorderLayout.WEST);
		        
		        // Add behaviour
		      /*  button.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                textArea.append("Hello");
	
		            }
		            
		        });*/
		    }
		}


	 
	 
	   