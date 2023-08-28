package cucumber.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import cucumber.data.provider.DataProviderPath;

public class ReadProperties {
	public String getDataObject(String key) {
		Properties obj = new Properties();
		String value = null;
		key = key.replace(" ", "_");
		String remote = System.getProperty("propertiesConfig");
		if (remote == null || "".equals(remote)) {
			value = getData(obj, key, "locators.properties");
		} else {
			try {
				FileInputStream inputStream = new FileInputStream(remote);
				obj.load(inputStream);
				inputStream.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			value = obj.getProperty(key);
			if (StringUtils.isEmpty(value)) {
				value = getData(obj, key, "locators.properties");
			}
		}
		return StringUtils.trim(value);
	}

	private static String getData(Properties obj, String key, String nameFile) {
		try {
			String file = new DataProviderPath().getPropertiesFile(nameFile);
			InputStream inputStream = new FileInputStream(file);
			obj.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return obj.getProperty(key);
	}
}
