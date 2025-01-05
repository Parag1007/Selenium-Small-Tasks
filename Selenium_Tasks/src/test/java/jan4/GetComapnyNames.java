package jan4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetComapnyNames {
	@Test(dataProvider = "data")
	public void test(String skill, String location) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Enter skills / designations / companies']")).sendKeys(skill);
		driver.findElement(By.xpath("//input[@id='expereinceDD']")).click();
		driver.findElement(By.xpath("//li[@value='#0']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter location']")).sendKeys(location);
		driver.findElement(By.xpath("//div[@class='qsbSubmit']")).click();
		Thread.sleep(3000);
		List<WebElement> element = driver.findElements(By.xpath(
				"//div[contains(@class, 'styles_middle-section-container__iteRZ')]//a[contains(@class, ' comp-name ')]"));
		int size = element.size();
		System.out.println(size);

		for (WebElement c : element) {
			System.out.println(c.getText());
		}

		driver.quit();
	}

	@DataProvider
	public Object[][] data() {
		return new Object[][] {
			new Object[] { "HTML", "Pune" }, 
			new Object[] { "Selenium", "Nashik" }, 
			};
	}

}
