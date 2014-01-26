package gui;


/* Boolean objects in java are immutable. So I needed to make my own */
public class Toggle implements PanelItem {
	private boolean val;
	private String trueString, falseString;
	
	public Toggle(boolean value, String trueString, String falseString) { 
		val = value; 
		this.trueString  = trueString;
		this.falseString = falseString;
	}
	
	public boolean getValue() { return val; }
	public void changeValue() { val = !val; }
	
	public String getString() { return val ? trueString : falseString; }
}