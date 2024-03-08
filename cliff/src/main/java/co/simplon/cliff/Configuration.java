package co.simplon.cliff;

import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton: design pattern insures a unique instance of a class in a program.
 */

final class Configuration {
	// public static final Configuration CONF =Configuration.INSTANCE;
//static and final donc pas de risque de l'exposer au monde ext..
	public static final Configuration INSTANCE = new Configuration() ;

	private static final String CLIFF_PROPS = "cliff.properties";
	
	private static final String APP_PROPS = "application.properties";
	
	private final Properties props;
	
	private Configuration() {
		//pour ne pas faire un get app or load properties, on les a 'fusionnés'
		props = loadCliffProperties();
		Properties appProps = loadAppProperties();
		props.putAll(appProps);
	}
	
	private Properties loadCliffProperties() {

		 try (InputStream is = ClassLoader.getSystemResourceAsStream(CLIFF_PROPS)) {
				Properties properties = new Properties();
	            properties.load(is);
	            return properties;
	        }catch (Exception ex) {
	        	
	       throw new CliffException("Error loading CLIFF config", ex);
	    }
	}
	
	private Properties loadAppProperties() {

		 try (InputStream is = ClassLoader.getSystemResourceAsStream(APP_PROPS)) {
				Properties properties = new Properties();
	            properties.load(is);
	            return properties;
	        }catch (Exception ex) {
	        	
	       throw new CliffException("Error loading APP config", ex);
	    }
	}
	
	Object getProperty(String key) {
		return props.get(key);
	}
	
	String getString(String key) {
		Object value = getProperty(key);
		//cast-er > ca va returner en String
		return (String) value;
	}
	
	boolean getBoolean(String key) {
		String value = getString(key);
		return Boolean.valueOf(value);
	}
	
	
	//ancien pattern : 
	//là y a 5 micro operations
//	private static Configuration instance;
//	private Configuration() {
//		//init
//	}
//	static Configuration getInstance() {
//		if(instance == null) {
//			instance = new Configuration();
//		}
//		return instance;
//	}
	
}

