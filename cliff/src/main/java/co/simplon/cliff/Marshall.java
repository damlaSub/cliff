package co.simplon.cliff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

//pas public , non accessiblepour app.
final class Marshall { //Command executor

	 final static Marshall INSTANCE = new Marshall();

	 public static final CommandRegistry REG = CommandRegistry.INSTANCE;
	 
	 private final List<String> history = new ArrayList<>();
	 
	private Marshall() {
		//		
	}
	
	List<String> getHistory(){
		return Collections.unmodifiableList(history);
	}
	
	//method accessible par scanner
	void process(String input) {
		history.add(input);
		CommandLine cmdLine = CommandLine.from(input);
		Supplier<Command> supplier = REG.get(cmdLine.name()); 
		Command command = supplier.get();
		//systrace short cut
		System.out.println("Marshall.process()");
		Result result = command.execute(cmdLine);
		Printer.result(result);
	}
}
