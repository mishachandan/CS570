package rmi.Client;

import java.util.EventObject;

public class DetailEvent extends EventObject {
		
	private String text;
	private String text2;
	
	public DetailEvent (Object source, String text){
		super (source);
		
		this.text=text;
	}

	public String getText() {
        return text;
    }
}
