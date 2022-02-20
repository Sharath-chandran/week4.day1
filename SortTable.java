package week4.day1;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		// table_id
		System.out.println("List 1");
		System.out.println(" ");
		List<WebElement> listname = driver.findElements(By.xpath("//*[@id=\"table_id_wrapper\"]//tr[*]//td[2]"));
		List<String> list = new LinkedList<String>();
		for (WebElement names : listname) {
			String names1 = names.getText();
			list.add(names1);
			System.out.println(names1);
		}
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		System.out.println(" ");
		System.out.println("List 2");
		System.out.println(" ");
		List<WebElement> listname1 = driver.findElements(By.xpath("//td[@class='sorting_1']"));
		List<String> list2 = new LinkedList<String>();
		for (WebElement names1 : listname1) {
			String names2 = names1.getText();
			list2.add(names2);
			System.out.println(names2);
		}
		System.out.println(" ");
		System.out.println("Result: ");
		if (list.equals(list2) == true) {
			System.out.println("The Lists are equal");
		} else

		{
			System.out.println("The Lists are not equal");
		}

	}
}
