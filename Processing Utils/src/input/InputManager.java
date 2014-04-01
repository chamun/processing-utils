package input;

import log.Log;

public class InputManager {
	
	Callback keys[] = new Callback[256];
	
	public void register(char key, Callback c) {
		if (!isValid(key)) {
			Log.instance().error("Trying to register an invalid key: " + key);
			return;
		}
		
		if (c == null) {
			Log.instance().error("Callback can not be null!");
			return;
		}
		
		keys[key] = c;
	}
	
	private boolean isValid(char key) { 
		return key >= 0 && key < keys.length; 
	}

	public void execute(char key) {
		if (isValid(key)) {
			if (keys[key] != null)
				keys[key].execute();
			else
				Log.instance().warning(
						"Trying to execute an unregistered key! ("+key+")");
		}
	}
}
