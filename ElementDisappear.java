package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisappear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");

		WebElement Text = driver.findElement(By.xpath("//strong[contains(text(),'disappeared')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("b")));

		if (Text.isDisplayed()) {
			System.out.println("The new text displayed is: " + Text.getText());
		}
	}

}
