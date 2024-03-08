package co.simplon.cliff;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.function.Consumer;

final class Printer {

	 public static final Configuration CONF =Configuration.INSTANCE;
	 private Printer() {
		 //Not instantiable
	 }
	 
	 private static final String PROMPT = initPrompt();
	 
	 static void startInfo() {
		 String text = CONF.getString("cliff.text");
		 System.out.println(text);
		 String startText = CONF.getString("cliff.start.text");
		 String applicationName = CONF.getString("cliff.application.name");
		 LocalDateTime now = LocalDateTime.now();
		 System.out.println(String.format(startText, applicationName, now));
		
	 }
	 
	 static void stopInfo() {
		 String stopInfo = CONF.getString("cliff.stop.text");
		 String applicationName = CONF.getString("cliff.application.name");
		 System.out.println(String.format(stopInfo, applicationName));
	 }
	 
	private static String initPrompt() {
		 String prompt = CONF.getString("cliff.prompt");
		 // ANSIColor.RESET.getCode()
		 return ANSIColor.TEXT_RED.getCode() + prompt + " ";
	 }
	static void prompt() {
		System.out.print(PROMPT);
	}
	static void result(Result result) {
		Collection<ResultItem> items = result.getItems();
		ANSITheme theme = result.getTheme();
		//Expression lambda forEach(do smthg with each element)
		System.out.println(theme.getBackground().getCode() + theme.getText().getCode());
		items.forEach((item) -> System.out.println(item.output()));
		
//		for(ResultItem item : items) { // How
//			System.out.println(item.output()); //What
//		}
	}
//	private static void example() {
//		//Consumer est une interface. Mais ici on instancie une implementation d'une interface. 
//		//On instancie pas l'interface (pas possible pour une class abstrait)
//		//Anonymus class of type Consumer
//		//consumer est une functional interface. quand mon interface est functional, je peut lui passer une expression lambda
//		//interface functional peut avoir une seule methode.Sinon exp lambda ne peut pas savoir quelle methode à lui passer...
//		Consumer<ResultItem> anonymus = new Consumer<ResultItem>() {
//			@Override
//			public void accept(ResultItem t) {
//				System.out.println(t);
//			}
//		};
//		//Named class 
////		Consumer<ResultItem> named = new ConsumerImpl();
////		named.accept(null);
////		
//	}
//	class ConsumerImpl implements Consumer<ResultItem> {
//		@Override
//		public void accept(ResultItem item) {
//			System.out.println(item);
//		}
//	}
	}
