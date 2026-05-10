package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static String readConfig(String key) {
		String env=System.getProperty("env", "qa");
		try {
			FileInputStream fis=new FileInputStream("src/test/configfiles/config-"+env+".properties");
			Properties prop=new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		} catch (Exception e) {
			
		}
		return key;
		
	}

}
