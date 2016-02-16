package weather;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class DetailsPanel extends JPanel {
   
	private static final long serialVersionUID = 2797269553098294153L;
	
	 private EventListenerList listenerList = new EventListenerList();


	public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 150;
        setPreferredSize(size);
        
        setBorder(BorderFactory.createTitledBorder("weather Details"));
        
        JLabel zipcode = new JLabel("enter the zipcode: ");
       
        final JTextField zipfield = new JTextField(10);
       
        JButton addBtn = new JButton("check weather");
        
        addBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String zip = zipfield.getText();
               

                String text = "weather report";
                
                
                System.out.println(text);
                
                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
   //// First column 
  	  
  	  gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 0.5;
        gc.weighty = 1;
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(zipcode, gc);
        
        //second 
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(zipfield, gc);
      
        //button 
        gc.weighty = 10;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);
        
	}    
        
        public void fireDetailEvent(DetailEvent event) {
            Object[] listeners = listenerList.getListenerList();
            
            for(int i=0; i < listeners.length; i += 2) {
                if(listeners[i] == DetailListener.class) {
                    ((DetailListener)listeners[i+1]).detailEventOccurred(event);
                }
            }
        }  
        
        public void addDetailListener(DetailListener listener) {
            listenerList.add(DetailListener.class, listener);
        }
        
        
      public void  removeDetailListener(DetailListener listener){
    	  listenerList.remove(DetailListener.class, listener);
          
      }
        
    }
       
  

      
      
      
      
      
      
      /*addBtn.addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent e) {
              String name = zipcode.getText();
              

              String text = name + ":  " + occupation + "n";
              
              fireDetailEvent(new DetailsEvent(this, text));
	  
	  JTextField zipfield = new JTextField(20);
	  
	  JButton addbtn = new JButton("add");
	  
	  setLayout(new GridBagLayout());
	  
	  GridBagConstraints gc = new GridBagConstraints();
	  
	//// First column 
	  
	  gc.anchor = GridBagConstraints.FIRST_LINE_START;
      gc.weightx = 0.5;
      gc.weighty = 1;
      
      gc.gridx = 1;
      gc.gridy = 0;
      add(zipcode, gc);
      
      //second 
      gc.anchor = GridBagConstraints.LINE_START;
      
      gc.gridx = 1;
      gc.gridy = 0;
      add(zipfield, gc);
    
      //button 
      gc.weighty = 10;
      
      gc.anchor = GridBagConstraints.FIRST_LINE_START;
      gc.gridx = 1;
      gc.gridy = 2;
      add(addbtn, gc);
      
  }
     
}
*/