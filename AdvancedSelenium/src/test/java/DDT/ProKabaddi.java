package DDT;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProKabaddi {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.prokabaddi.com/standings");
	driver.manage().window().maximize();
	
	String won = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/../../../following-sibling::div[@class=\"table-data matches-won\"]//p[@class=\"count\"]")).getText();
		String lost = driver.findElement(By.xpath("//p[text()='Dabang Delhi K.C.']/../../../following-sibling::div[@class=\"table-data matches-lost\"]//p[@class=\"count\"]")).getText();
		String totalMatches = driver.findElement(By.xpath("//p[text()='Dabang Delhi K.C.']/ancestor::div[@class=\"row-head\"]//div[@class=\"table-data matches-play\"]")).getText();
		String draw = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"row-head\"]//div[@class=\"table-data matches-draw\"]")).getText();
System.out.println("won "+  won);
System.out.println("lost "+ lost);
System.out.println("TotalMatches "+totalMatches);
System.out.println("Draw " +draw);

	}

}
