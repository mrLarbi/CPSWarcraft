package preset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import factory.FactoryImpl;
import factory.IFactory;

public class AbstractPreset
{
	protected static String configFile = "config/entities.json";
	public static IFactory factory = new FactoryImpl(); 
	protected static String configuration = "";
	protected static boolean isConfigured = false;
	
	public static void getConfiguration()
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(configFile));
			StringBuilder configBuilder = new StringBuilder();
			
			String line = null;
			String lineSep = System.getProperty("line.separator");
			while( ( line = reader.readLine() ) != null ) {
				configBuilder .append( line );
				configBuilder .append(lineSep );
		    }
			configuration = configBuilder.toString();
			isConfigured = true;
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void configure()
	{
		if(!isConfigured)
		{
			getConfiguration();
		}
	}
}
