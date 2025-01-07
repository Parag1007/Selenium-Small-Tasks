package Dropdown_types;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestDropDown {

	@Test
	public void autoSuggest() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		// print all auto suggested options
		Thread.sleep(2000);
		List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
		System.out.println("size of all autosuggetsted options: " + alloptions.size());
		for (WebElement as : alloptions) {
			System.out.println(as.getText());
		}
		// click the auto suggested options option

		driver.findElement(By.xpath("//span[normalize-space()='selenium']")).click();
      driver.quit();
	}

}
