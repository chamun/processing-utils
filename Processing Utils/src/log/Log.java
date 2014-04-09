package log;

public class Log {
	
	private static Log instance;
	
	private boolean isOn = true;

	private Log() { }
	
	public static Log instance() {
		if (instance == null)
			instance = new Log();
		return instance;
	}

	public void error(String msg) {
		String error = makeString(msg);
		if (isOn)
			System.err.println("ERROR: "+error);
	}
	
	public void warning(String msg) {
		String warning = makeString(msg);
		if (isOn)
			System.err.println("warning: " + warning);;
	}
	
	public void debug(String msg) {
		String debug = makeString(msg);
		if (isOn)
			System.out.println(debug);;
	}
	
	public void turnOn() { isOn = true; }
	public void turnOff() { isOn = false; }
	
	private String makeString(String msg) {
		StackTraceElement[] ste = null;
		StringBuffer error = new StringBuffer();
		try {
			ste = Thread.currentThread().getStackTrace();
			if (ste != null && ste.length >= 4) {
				error.append(ste[3].getClassName());
				error.append("#");
				error.append(ste[3].getMethodName());
			}
		} catch (SecurityException e) {
			error.append("??#??");
		}
		error.append(": ");
		error.append(msg);
		return error.toString();
	}
}
