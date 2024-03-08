package co.simplon.cliff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public final class CommandRegistry {

	//singleton
	//comme final, peut l'exposer 
	public final static CommandRegistry INSTANCE = new CommandRegistry();
	
	private final static Marshall FRANK = Marshall.INSTANCE;
	
	private final Map<String, Supplier<Command>> mappings = new HashMap<>();
	
	private CommandRegistry() {
		addDefaults();
	}
	private void addDefaults() {
		mappings.put("history",() -> (cmdLine) -> {
			List<String> history = FRANK.getHistory();
			Result result = new Result();
			for(String entry: history) {
				ResultItem item = new ResultItem(entry);
				result.add(item);
			}
			return result;
			//y a pas de constructor Marshall qu'on a ecrit dans cette function car c'est une expression lambda
		});
	}
	
	public void addMapping(String name, Supplier<Command> supplier) {
		Objects.requireNonNull(name, "command name cannot be null");
		Objects.requireNonNull(supplier, "command cannot be null");
		if(name.equals("history")){
			throw new CliffException("history is already existing command");
		}
		mappings.put(name, supplier);
	}
	
	Supplier<Command> get(String name) {
		return mappings.get(name);
	}
}
