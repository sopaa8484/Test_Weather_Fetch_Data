package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POTemp {
	public POTemp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	String city;
	String tp_xpath = "//div[@title='" + city + "']//div//span";

	@FindBy(xpath = "//input[@class='searchBox']")
	private WebElement Searchbox;

	// By checkbox = By.xpath("//input[@type='checkbox' and contains(@id,'" + city +
	// "')]");

	// By tempx = By.xpath("//div[@title='" + city + "']//div//span");

	public void SearchCity(String city) throws InterruptedException {
		this.city = city;
		Thread.sleep(1000);
		Searchbox.clear();
		Searchbox.sendKeys(city);
	}

	public void checkbox() throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='checkbox' and contains(@id,'" + city + "')]")).click();

	}

	public void temp() throws InterruptedException {
		List<WebElement> templist = driver.findElements(By.xpath("//div[@title='" + city + "']//div//span"));
		Thread.sleep(1000);
		String cel = templist.get(0).getText();
		String fah = templist.get(1).getText();
		Thread.sleep(1000);
		String cel1 = cel.replace("\u2103", "");
		String fah1 = fah.replace("\u2109", "");
		float cel2 = Float.parseFloat(cel1);
		int fah2 = Integer.parseInt(fah1);

		System.out.println("The Temperature in degree Celsius of " + city + " is :" + cel2);
		System.out.println("The Temperature in degree Fahrenheit of " + city + " is :" + fah2);

	}

}
