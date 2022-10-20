package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Properties_File_Reader {
	static String browser, url;

	public static String getbrowser() {

		try {
			Properties pro = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\spati\\eclipse-workspace\\PractiseTest\\src\\test\\resources\\Properties\\testdata.properties");
			pro.load(fis);
			browser = pro.getProperty("browser");
			url = pro.getProperty("url");

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return browser;

	}

	public static String geturl() {

		try {
			Properties pro = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\spati\\eclipse-workspace\\PractiseTest\\src\\test\\resources\\Properties\\testdata.properties");
			pro.load(fis);

			url = pro.getProperty("url");

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return url;

	}
}
