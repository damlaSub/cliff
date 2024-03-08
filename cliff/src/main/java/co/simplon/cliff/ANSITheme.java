package co.simplon.cliff;

import java.util.Objects;

public final class ANSITheme {

	public static final ANSITheme LIGHT = new ANSITheme(ANSIColor.BACKGROUND_WHITE, ANSIColor.TEXT_BLACK);
	public static final ANSITheme DARK = new ANSITheme(ANSIColor.BACKGROUND_BLACK, ANSIColor.TEXT_WHITE);
	public static final ANSITheme DEFAULT = LIGHT;
	
	private final ANSIColor background;
	private final ANSIColor text;
	
	public ANSITheme(ANSIColor background, ANSIColor text) {
		Objects.requireNonNull(background, "background cannot be null");
		Objects.requireNonNull(text, "text cannot be null");
		this.background = background;
		this.text = text;
	}
	public ANSIColor getBackground() {
		return background;
	}
	public ANSIColor getText() {
		return text;
	}
}
