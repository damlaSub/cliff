package co.simplon.cliff;

@FunctionalInterface
public interface Command {

	//public abstract >> comme tous les interfaces
	Result execute(CommandLine cmdLine);
}
