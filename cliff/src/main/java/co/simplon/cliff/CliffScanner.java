package co.simplon.cliff;

import java.awt.Toolkit;
import java.util.Collection;
import java.util.Scanner;

final class CliffScanner {
	 private static final Configuration CONF =Configuration.INSTANCE;
	 
	 private static Marshall FRANK = Marshall.INSTANCE;
	 
	 
	private CliffScanner() {
		//Not instantiable
	}
	static void scan() {
		//System.out.println("scanning");
		try(Scanner scanner = new Scanner(System.in)){
			
			program: while(true) { //Potential infinite loop!!!
				Printer.prompt();
				String input = scanner.nextLine();
				if("exit".equals(input)) {
					boolean beep = CONF.getBoolean("cliff.beep-on-exit");
					if(beep) {
						Toolkit.getDefaultToolkit().beep();
					}
					break program;
				} else {
					//ancien code:
//					String name = cmdLine.name();
//					String remainder= cmdLine.remainder();
//					String output = String.format("name=%s, remainder=%s", name, remainder);
					//Delegate execution of the given command to the appli
					//pass CommLine obj to the command line
					//need an obj to represent result(output)
					FRANK.process(input);
					
				}
			}
			
		}
	}
}
