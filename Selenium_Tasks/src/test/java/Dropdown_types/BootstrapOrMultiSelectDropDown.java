package Dropdown_types;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootstrapOrMultiSelectDropDown {

	@Test
	public void DropDown() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//b[@class='caret']")).click();

		// We want click option here we not use select class cuause of dropdown
		// not create using select class We use xpath

		// Select single option
		// driver.findElement(By.xpath("//input[@value='Java']")).click();

		// Print all dropdown Labels
		List<WebElement> Opts = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		int size = Opts.size();
		System.out.println("Count of dropdown Options: " + size);
		System.out.println("Print the all options from the dropdown: ");
	     
		for (WebElement li : Opts) {
			String text = li.getText();
			System.out.println(text);
			                    // Select Multiple Options
			if (text.equals("MySQL") || text.equals("Python") || text.equals("Oracle") || text.equals("Angular")) {

				li.click();
			}
		}

	}

}
