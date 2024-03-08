package co.simplon.cliff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class Result {

	private final Collection<ResultItem> items = new ArrayList<>();
	
	private final ANSITheme theme;
	
	public Result() {
		this(ANSITheme.DEFAULT);
	}
	public Result(ANSITheme theme) {
		Objects.requireNonNull(theme, "theme cannot be null");
		this.theme= theme;
	}
	
	public Result(ANSITheme theme ,ResultItem item) {
		this(theme);
		items.add(item);
	}
	public Result(ResultItem item) {
		this();
		items.add(item);
	}
	
	public Result(ANSITheme theme,ResultItem... items) { //varargs "..." permet des args var
		this(theme);
		addAll(items);
	}
	
	public void addAll(ResultItem... items) {
		System.out.println(items.length);
		//depuis java 8, progr. functionnelle:
		 for(ResultItem resultItem: items) {//How
		add(resultItem); // What
		 }
	}
	
	public void add(ResultItem item) {
		Objects.requireNonNull(item, "result item cannot be null");
			items.add(item);
	}
	//faut pas exposer la collection sinon on peut la changer/effacer 
	//faut la rendre immuable >unmodifiableColl
	public Collection<ResultItem> getItems(){
		return Collections.unmodifiableCollection(items);
	}
	
	public ANSITheme getTheme(){
		return theme;
	}
}
