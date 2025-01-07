package Dropdown_types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import jxl.read.biff.BiffException;

public class SelectDropdown {
	// In html dropdown list create by using select tag.
	@Test
	public void dropDownWithSelectTag() throws BiffException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<String> expected = ReadExcelSheet.readExcel("DropDown.xls", 0);// Use Utility class for the get the data
																			// from excel sheet
		List<String> actual = new ArrayList<String>();
		driver.manage().window().maximize();
		WebElement DrpOptions = driver.findElement(By.xpath("//select[@id='country']"));
		// DrpOptions.click();
		Select select = new Select(DrpOptions);
		List<WebElement> options = select.getOptions();
		System.out.println("Number of option in the DropDown: " + options.size());

		// Three methods of click the dropdown options only for dropdown created by use
		// select tag in HTML.
		// select.selectByIndex(9);
		// select.selectByValue("canada");
		select.selectByVisibleText("India");

		// first option Use Normal for loop for print the options
//		for (int i = 0; i < options.size(); i++) {
//			System.out.println(options.get(i).getText());
//		}

		// Second option Use enhance for loop for print options
		System.out.println("Print the dropDown Options");
		for (WebElement op : options) {
			String Data = op.getText();
			System.out.println(Data);
			actual.add(Data);
		}
		driver.quit();
		Assert.assertEquals(actual, expected);
	}
}