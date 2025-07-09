package com.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePickerTest {
	static WebDriver driver;
	static Properties prop;
	static Logger logger = Logger.getLogger(DatePickerTest.class.getName());
	static WebDriverWait wait;

	@BeforeClass
	public void setup() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./configure.properties");
		prop.load(fis);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger.info("Browser get launched and Site Opened");
	}

	@Test
	public void selectDate() throws InterruptedException {

		WebElement element = driver.findElement(By.id(prop.getProperty("date_path")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		logger.info("CLick on the dapicker");
		String expectmonth_yr = "August 2026";
		String expectday = "15";
		String actmonth_year ="" ;
		Thread.sleep(3000);
		while (true) {
			  actmonth_year = driver.findElement(By.xpath(prop.getProperty("month_year_xpath"))).getText();
			if (actmonth_year.equals(expectmonth_yr)) {

				logger.info("Validation..");
				break;
			} else {

				driver.findElement(By.xpath(prop.getProperty("next_btn_xpath"))).click();
				logger.info("Nevigate the next month.." + actmonth_year);
				Thread.sleep(500);
			}
		}
		driver.findElement(By.xpath("//div[text()='" + expectday + "']")).click();
		logger.info("Selected date: " + expectday + " " + expectmonth_yr + " ");
        
		Assert.assertEquals(expectmonth_yr, actmonth_year);
  
	}

	public void teardown() {
		driver.close();
	}
}