package week4.day1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");

		WebElement Table = driver.findElement(By.id("table_id"));

		// Get the count of number of Rows
		List<WebElement> Rows = Table.findElements(By.xpath("//*[@id='table_id']//tr"));
		System.out.println("Number of Rows in the table = " + Rows.size());

		// Get the count of number of Columns
		List<WebElement> Columns = Table.findElements(By.xpath("//*[@id='table_id']//th"));
		System.out.println("Number of Columns in the table = " + Columns.size());

		// Get the Progress value of 'Learn to interact with elements'
		WebElement ProgressValue = driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[3]/td[2]"));
		System.out.println("Progress Value for Learn to interact with elements is " + ProgressValue.getText());

		// Check the vital task for the least completed progress value
		List<WebElement> MyList = driver.findElements(By.xpath("//table[@id='table_id']//tr[*]/td[2]"));

		List<Integer> All_ProgressValues = new LinkedList<Integer>();

		for (WebElement Value : MyList) {
			String Num = Value.getText();
			String i = Num.replaceAll("%", "");

			int val1 = Integer.parseInt(i);

			All_ProgressValues.add(val1);
			Collections.sort(All_ProgressValues);
			Collections.min(All_ProgressValues);
		}
		System.out.println(All_ProgressValues);

		Integer n = All_ProgressValues.get(0);
		driver.findElement(By.xpath("//td[text()='" + n + "%']/following-sibling::td/input")).click();
	}

}
