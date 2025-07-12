package com.examples;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class Dropdown_select extends BaseTest {

	Select select;

	public Dropdown_select() throws FileNotFoundException {
		super();
	}
	@Test
	public void dropdowns() throws InterruptedException {
		initilization();
		driver.get("https://practice.expandtesting.com/dropdown");
		logger.info("Broweser get opened..");
		WebElement dp_1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
		WebElement dp_2 = driver.findElement(By.xpath("//select[@id='elementsPerPageSelect']"));

		// Select Visible text
		dp_1.click();
		select = new Select(dp_1);
		select.selectByVisibleText("Option 2");
		logger.info("Clicked using visible text..");
		Thread.sleep(3000);

		// selectBy Index
		dp_2.click();
		select = new Select(dp_2);
		select.selectByIndex(1);
		logger.info("Clicked using SelectByIndex method..");
		Thread.sleep(3000);

		// Select By Value
		WebElement dp_3 = driver.findElement(By.xpath("//select[@id='country']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dp_3);
		dp_3.click();
		select = new Select(dp_3);
		select.selectByValue("IN");
		dp_3.click();
		logger.info("CLicked using selectByValue method..");
		Thread.sleep(3000);
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

}
