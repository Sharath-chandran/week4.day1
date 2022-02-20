package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
		Alert alert = driver.switchTo().alert();
		String Text = alert.getText();
		alert.accept();

		System.out.println("Text in Alert Box is " + Text);
		if (Text.contains("Click")) {
			System.out.println("Text displayed was correct");
		} else {
			System.out.println("Text displayed was not correct");
		}
		
	}

}
