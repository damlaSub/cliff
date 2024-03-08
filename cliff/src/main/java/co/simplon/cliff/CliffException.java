package co.simplon.cliff;

@SuppressWarnings("serial")
public class CliffException extends RuntimeException {

	public CliffException(String string, Exception ex) {
		super(string, ex);
	}
	public CliffException(String string) {
		super(string);
	}

	
}
