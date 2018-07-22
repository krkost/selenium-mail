package by.htp.selenium.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainAppSelenium {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.ru/");
		
		driver.findElement(By.xpath("//div[@id=\"mailbox:loginContainer\"]/child::*")).sendKeys("tathtp");
		driver.findElement(By.xpath("//div[@class='mailbox__input__container']/child::*[1]")).sendKeys("Klopik123");
		driver.findElement(By.xpath("//input[@class='o-control']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='b-toolbar__left']/div/div/div[2]/div/a/span")).click();
		
		driver.findElement(By.xpath("//textarea[@data-original-name='To']")).sendKeys("mail.ru");
		driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("Auto Generated Mail from Kristina K");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='{#aria.rich_text_area}']")));
		
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Auto Generated email from Kristina K!!");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//div[@data-name='send']")).click();
		
		Thread.sleep(1500);
		driver.close();
		
		
	}

}
