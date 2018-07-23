package by.htp.selenium.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailTest {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static boolean MailCheck(String website, String login, String pass, String receiver)
			throws InterruptedException {

		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get(website);

		driver.findElement(By.xpath("//div[@id=\"mailbox:loginContainer\"]/child::*")).sendKeys(login);
		driver.findElement(By.xpath("//div[@class='mailbox__input__container']/child::*[1]")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@class='o-control']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='b-toolbar__left']/div/div/div[2]/div/a/span")).click();

		driver.findElement(By.xpath("//textarea[@data-original-name='To']")).sendKeys(receiver); 
		driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("Auto Generated Mail from Kristina K + JUnit");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']")));

		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Auto Generated email from Kristina K!!");
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//div[@data-name='send']")).click();
		
		driver.get("https://e.mail.ru/messages/sent/");
		Thread.sleep(1500);
		
		boolean isSent = driver.findElement(By.xpath("//div[contains(text(), '"+receiver+"')]")).isEnabled();

		Thread.sleep(1500);
		driver.close();
		
		return isSent;

	}

}
