package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	String rootpath;
	File file;
	FileInputStream fileInputStream;
	Properties prop;
	
	public ReadPropertyFile() throws IOException {
		
		rootpath = System.getProperty("user.dir");
		file =new File("src/main/java/TestData.properties");
		fileInputStream = null;
		
		try
		{
			fileInputStream = new FileInputStream(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		prop = new Properties();
		prop.load(fileInputStream);
	}
	
	public String getTodoListURL() {
		
		return prop.getProperty("TodoListURL");
}
	public String getTaskValue() {
		return prop.getProperty("TaskValue");
	}

}
