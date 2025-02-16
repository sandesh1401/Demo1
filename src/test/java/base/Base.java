package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class Base {
	WebDriver driver;
	public Properties p1;

	public WebDriver openApplication() throws IOException {



		p1 = CommonUtils.loadingProperties();
		String browser = p1.getProperty("browserName");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
//		p1 = CommonUtils.loadingProperties();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p1.getProperty("applicationURL"));

		return driver;
	}

	public void closeWindow(WebDriver driver) {

		// driver.quit();

		if (driver != null) {
			driver.quit();
		}

	}

}
