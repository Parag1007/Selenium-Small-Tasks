package Dropdown_types;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HiddenDropDownList {

	WebDriver driver = null;

	@Test
	public void flipkartElectronicFuncstionality() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//span[text()='Recruitment']")).click();

		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"))
				.click();
		// print the size of dropdown and print all text
		List<WebElement> alloptions = driver
				.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//span"));
		System.out.println("Number of options in list :" + alloptions.size());
		for (WebElement op : alloptions) {
			System.out.println(op.getText());
		}

		// Select the hidden dropdown option.
		driver.findElement(By.xpath("//span[normalize-space()='Senior QA Lead']")).click();
      driver.quit();
	}

}
