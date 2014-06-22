package gui;

import java.util.ArrayList;
import java.util.List;

public class Modes implements PanelItem {
	
	private String title;
	private List<String> modes;
	private List<String> keys = new ArrayList<String>();
	private int currentMode;
	private boolean usingKeys = false;

	public Modes(String title, String defaultMode) {
		this.title = title;		
		modes = new ArrayList<String>(5);
		modes.add(defaultMode);
		currentMode = 0;
		changeMode(0);
	}
	
	public Modes(String title, String defaultMode, String key) {
		this(title, defaultMode);
		keys.add(key);
		usingKeys = true;
	}
	
	public void addMode(String newMode) { modes.add(newMode); }
	public void addMode(String newMode, String key) {
		modes.add(newMode);
		keys.add(key);
		usingKeys = true;
	}
	
	public void changeMode(int newMode) {
		if (newMode >= modes.size() || newMode < 0)
			throw new RuntimeException("Invalid mode!");
		currentMode = newMode;
	}
	
	private String getTitle() {
		String ret = title;
		if (keys.size() > 0)
			ret += " " + getOptions();
		if (usingKeys)
			ret += ":";
		return ret;
	}

	private String getOptions() {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		sb.append("(");
		for (String s: keys) {
			sb.append(s);
			if (count < keys.size())
				sb.append("/");
			count++;
		}
		sb.append(")");
		return sb.toString();
	}

	public int getCurrentMode() { return currentMode; }
	public String getString() { return getTitle() + " " + modes.get(currentMode); }

	public int modeNumber() { return modes.size(); }

}
