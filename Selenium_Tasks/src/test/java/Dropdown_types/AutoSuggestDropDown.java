package Dropdown_types;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoSuggestDropDown {	
	
	@Test
	public void autoSuggest() throws InterruptedException {

	    WebDriver driver = new ChromeDriver();

	    try {
	        driver.get("https://www.google.com/");

	        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
	        searchBox.sendKeys("selenium");

	     //    Wait for auto-suggestions to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//div[@class='wM6W7d']//span")));

	        // Print the size of all auto-suggested options
	        System.out.println("Size of all auto-suggested options: " + suggestions.size());

	        // Print all auto-suggested options
	        for (WebElement suggestion : suggestions) {
	            System.out.println(suggestion.getText());
	        }

	        // Click on the desired auto-suggested option (e.g., "selenium")
	        for (WebElement suggestion : suggestions) {
	            if (suggestion.getText().equalsIgnoreCase("selenium")) {
	                suggestion.click();
	                break;
	            }
	        }

	        // Optional: Wait to observe the action
	        Thread.sleep(2000);

	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    } finally {
	        // Quit the browser
	        driver.quit();
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Test
//	public void autoSuggest() throws InterruptedException {
//
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
//		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
//		// print all auto suggested options
//		Thread.sleep(2000);
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		List<WebElement> suggestions = wait
//				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wM6W7d']//span")));
//
//		// List<WebElement> alloptions =
//		// driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
//		System.out.println("size of all autosuggetsted options: " + suggestions.size());
//		for (WebElement as : suggestions) {
//			System.out.println(as.getText());
//		}
//		// click the auto suggested options option
////
////		driver.findElement(By.xpath("//span[normalize-space()='selenium']")).click();
////		driver.quit();
//	}

}
