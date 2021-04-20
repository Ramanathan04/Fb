package org.cloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Cloud {
	 public static final String AUTOMATE_USERNAME = "ramanathan23";
	  public static final String AUTOMATE_ACCESS_KEY = "jqcXK7PuYQydgMc3USyx";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  public static void main(String[] args) throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "8.1");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "Windows");
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://www.facebook.com/");
	    System.out.println("DONE");
	  }

}
