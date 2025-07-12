package com.examples;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CheckBox_select extends BaseTest {

	public CheckBox_select() throws FileNotFoundException {
		super();

	}

	@Test
	public void checkBox() throws InterruptedException {
		initilization();
		driver.get("https://testautomationcentral.com/demo/checkboxes.html");
		logger.info("Web Browser got opened...");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		logger.info("Already selected checkbox.");

		for (WebElement cb : checkboxes) {

			if (!cb.isSelected()) {

				cb.click();
			}
			logger.info("All checkbox got checked...");

		}
		Thread.sleep(3000);
		for (WebElement cb1 : checkboxes) {

			if (cb1.isSelected()) {

				cb1.click();
			}
		}
		logger.info("All checkboxes got unchecked....");
	}

	@AfterClass
	public void teardown() {
		driver.close();

	}

}
