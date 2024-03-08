package co.simplon.cliff;

public class CliffApplication {

	private static final Configuration CONF = Configuration.INSTANCE;
	//in state of main, on a dit method run 
	public static void run(String[] args) {
//		System.out.println(CONF.getString("cliff.text"));
//		System.out.println(CONF.getBoolean("cliff.beep-on-exit"));
	Printer.startInfo();
	CliffScanner.scan();
	Printer.stopInfo();
	}

}
