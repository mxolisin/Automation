package hotelbookingsys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class delete_bookings {

    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "/Users/mxolisi.ngcobo/eclipse-workspace/drivers/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://hotel-test.equalexperts.io/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	driver.findElement(By.id("firstname")).sendKeys("Kayler");                     // Enter first name
	driver.findElement(By.id("lastname")).sendKeys("Ngcobo");                      // Enter surname
	driver.findElement(By.id("totalprice")).sendKeys("650.00");                   // Enter total price
	Select dropdown = new Select(driver.findElement(By.id("depositpaid")));               
	dropdown.selectByVisibleText("false");                                       // Check if deposit is paid
	WebElement checkinDate = driver.findElement(By.id("checkin"));             //Find the date time picker control
	checkinDate.sendKeys("2021-08-01");                                       //Fill date as yyyy/mm/dd as 2021/06/01
	WebElement checkoutDate = driver.findElement(By.id("checkout"));         //Find the date time picker control
	checkoutDate.sendKeys("2021-08-03");                                    //Fill date as yyyy/mm/dd as 2021-06-03
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[7]/input")).click();     // Saving and finalising a booking
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // First wait to show you successful booking of the above user
	driver.findElement(By.xpath("//*[@id=\"7208\"]/div[7]/input")).click();     // Deleting and finalising a booking
    System.out.println("Booking deleted successfully");
	//driver.quit();    // close browser window

	}
}