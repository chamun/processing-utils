package gui;

import java.util.ArrayList;
import java.util.List;

public class Modes implements PanelItem {
	
	private String title;
	private List<String> modes;
	private String currentContent;
	private int currentMode;

	public Modes(String title, String defaultMode) {
		this.title = title;		
		modes = new ArrayList<String>(5);
		modes.add(defaultMode);
		currentMode = 0;
		changeMode(0);
	}
	
	public void addMode(String newMode) { modes.add(newMode); }
	
	public void changeMode(int newMode) {
		if (newMode >= modes.size() || newMode < 0)
			throw new RuntimeException("Invalid mode!");
		currentContent = title + " " + modes.get(newMode);
		currentMode = newMode;
	}
	
	public int getCurrentMode() { return currentMode; }
	public String getString() { return currentContent; }

}
