package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	static Properties prop;
	protected static WebDriver driver;
	static FileInputStream fis;
	public static Logger logger = Logger.getLogger(BaseTest.class.getName());

	public BaseTest() throws FileNotFoundException {

		fis = new FileInputStream("./configure.properties");
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initilization() {

		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {

			System.out.println("Invalid browser name specified.");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

}
