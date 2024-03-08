package co.simplon.cliff;

public enum ANSIColor {

	  RESET("\u001B[0m"),
	    // Regular text colors
	    TEXT_BLACK("\u001B[30m"),
	    TEXT_RED("\u001B[31m"),
	    TEXT_GREEN("\u001B[32m"),
	    TEXT_YELLOW("\u001B[33m"),
	    TEXT_BLUE("\u001B[34m"),
	    TEXT_MAGENTA("\u001B[35m"),
	    TEXT_CYAN("\u001B[36m"),
	    TEXT_WHITE("\u001B[37m"),
	    // Bright text colors
	    TEXT_BLACK_BOLD("\u001B[30;1m"),
	    TEXT_RED_BOLD("\u001B[31;1m"),
	    TEXT_GREEN_BOLD("\u001B[32;1m"),
	    TEXT_YELLOW_BOLD("\u001B[33;1m"),
	    TEXT_BLUE_BOLD("\u001B[34;1m"),
	    TEXT_MAGENTA_BOLD("\u001B[35;1m"),
	    TEXT_CYAN_BOLD("\u001B[36;1m"),
	    TEXT_WHITE_BOLD("\u001B[37;1m"),
	    // Background colors
	    BACKGROUND_BLACK("\u001B[40m"),
	    BACKGROUND_RED("\u001B[41m"),
	    BACKGROUND_GREEN("\u001B[42m"),
	    BACKGROUND_YELLOW("\u001B[43m"),
	    BACKGROUND_BLUE("\u001B[44m"),
	    BACKGROUND_MAGENTA("\u001B[45m"),
	    BACKGROUND_CYAN("\u001B[46m"),
	    BACKGROUND_WHITE("\u001B[47m");

	    private final String code;

	    private ANSIColor(String code) {
	    this.code = code;
	    }

	    String getCode() {
	    return code;
	    }
	
}
