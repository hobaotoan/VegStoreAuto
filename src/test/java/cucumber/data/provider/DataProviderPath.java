package cucumber.data.provider;

import java.io.File;
import java.io.IOException;

public class DataProviderPath {
	/*
	 * get path from Folder
	 * @param : fileName
	 */
	public String getPropertiesFile(String nameFile) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "src" 
					  + File.separator + "test" +  File.separator +"resources" +  File.separator + nameFile;
		return path;
	}
	
	/*
	 * get path from Folder
	 * @param : fileName
	 */
	public String getPropertiesFileJson(String nameFile) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "src" 
					  + File.separator + "test" +  File.separator +"resources" +  File.separator + nameFile + ".json";
		return path;
	}

}
