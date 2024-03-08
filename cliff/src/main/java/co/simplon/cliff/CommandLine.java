package co.simplon.cliff;
/**
 * Replaces POJO.
 * 
 * Immutable objects. 
 */
 public record CommandLine(String name, String remainder) {
	
	/*
	 * private final String name;
	 * * private final String remainder;
	 * public CommandLine(String name, String remainder){
	 * this.name = name
	 * this.remainder = remainder;
	 * }
	 * public String name(){
	 * return name;
	 * }
	 * 
	 */
	 static CommandLine from(String input) {
		 String trimmed = input.trim();
		    String[] tokens = trimmed.split(" ", 2);
		    
		    String name = tokens[0].isEmpty() ? null : tokens[0];
		    
		    String remainder = tokens.length == 1 ? null : tokens[1].stripLeading();
		    
		    return new CommandLine(name, remainder);
		    }
	 
//	 static CommandLine from(String input) {
//		 
//			String[] tokens = input.split(" ", 2);
//			String name = !tokens[0].trim().isEmpty() ? tokens[0] : null;
//			String remainder = (tokens.length == 2 && !tokens[1].trim().isEmpty()) ? tokens[1] : null;
//		 	return new CommandLine(name, remainder);
//		 	}
}
