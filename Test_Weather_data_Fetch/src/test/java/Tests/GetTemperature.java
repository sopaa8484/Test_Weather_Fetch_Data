package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.POTemp;
import Utils.BrowserLaunch;
import Utils.CSV_File_Reader;
import Utils.Properties_File_Reader;

public class GetTemperature {
	WebDriver driver;
	POTemp po;
	Properties_File_Reader pr;
	CSV_File_Reader csv;

	@BeforeTest
	public void BeforeTest() throws InterruptedException {
		String url = Properties_File_Reader.geturl();
		String browser = Properties_File_Reader.getbrowser();
		driver = BrowserLaunch.LaunchBrowser(url, browser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		po = new POTemp(driver);
	}

	@Test
	public void gettemp() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String[] city = CSV_File_Reader.city();
		System.out.println(city);
		for (int i = 0; i < city.length; i++) {
			String cityname = city[i];
			Thread.sleep(1000);
			po.SearchCity(cityname);
			Thread.sleep(1000);
			po.checkbox();
			Thread.sleep(2000);
			po.temp();
		}

	}

	@AfterTest
	public void aftertest() {
		driver.close();
	}
}
