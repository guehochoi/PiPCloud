package support;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;

public class ATMUserInterface implements Teller {

	private final EventFiringWebDriver webDriver;
	
	public ATMUserInterface() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
		this.webDriver = new EventFiringWebDriver(new ChromeDriver());
	}
	
	@Override
	public void withdrawFrom(Account account, int dollars) {
		try {
			webDriver.get("http://localhost:" + ServerHooks.PORT);
			webDriver.findElement(By.id("Amount"))
						.sendKeys(String.valueOf(dollars));
			webDriver.findElement(By.id("Withdraw")).click();
		} 
		finally {
			webDriver.close();
		}
	}
}
