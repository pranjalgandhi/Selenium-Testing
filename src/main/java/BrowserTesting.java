
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class BrowserTesting {
WebDriver driver;
	
	public void startBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\SeleniumJava\\Drivers\\CromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		
			testHomePage();
            testLinksPage();
			testJoinUsPage();
			testPrograms();
			testContactUsPage();
            testAboutUsPage();
            
            driver.close();
			
		} 
        catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Testing page 1: Home Page
	public void testHomePage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org");
			 
			//Test case 1: Playing and pausing Youtube video
			 WebElement Element = driver.findElement(By.id("youtube-video"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
			 Element.click();
			 Thread.sleep(6000);
			 Element.click();
			 Thread.sleep(2000);
			 
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			
			//Test case 2: Checking for scroll up button
			driver.findElement(By.id("toTop")).click();
		     
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
        
	
	//Testing page 2: Links Page
	public void testLinksPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org");
			
			 //Test case 3: Testing Links button on navbar
		    Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[4]/a"))).click().moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[4]/ul/li[1]/a"))).click().perform();
			Thread.sleep(2000);
			
			//Test case 4:Testing salient-features button
			driver.findElement(By.linkText("Salient Features")).click();
			Thread.sleep(3000);
			
			//Test case 5:Testing AI in Education button
			driver.findElement(By.linkText("AI in Education")).click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
        
      //Testing page 3: Join us Page
	public void testJoinUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/join-us/why-join-us/");
			Thread.sleep(2000);
			
			//Test case 6: Testing Expert Mentor button
			driver.findElement(By.linkText("Expert Mentor")).click();
			Thread.sleep(3000);
			
			//Test case 7: Testing Events Volunteer button
			driver.findElement(By.linkText("Events Volunteer")).click();
			Thread.sleep(3000);
			
			//Test case 8: Testing Management Volunteer button
			driver.findElement(By.linkText("Management Volunteer")).click();
			Thread.sleep(2000);
			
			// Test case 9:Checking name field
			driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("XYZ");
			Thread.sleep(2000);
			
			// Test case 10:Checking email field
			driver.findElement(By.xpath("//input[@placeholder='Email or Phone Number']")).sendKeys("xyz@gmail.com");
			Thread.sleep(2000);
			
			// Test case 11:Checking dropdown
			Select dropdown = new Select(driver.findElement(By.className("form-control")));
			dropdown.selectByVisibleText("Volunteer");
			Thread.sleep(2000);
			dropdown.selectByVisibleText("Intern");
		} 
                catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Testing page 4: Contact us Page
	public void testContactUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/contact-us/");
			Thread.sleep(2000);
			
			// Test case 12:Checking TSF NETWORK linkedin link
			driver.findElement(By.linkText("JOIN TSF NETWORK HERE (https://www.linkedin.com/groups/10379184/)")).click();
			Thread.sleep(2000);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//Testing page 5: Programs Page
	public void testPrograms() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org/programs/student-scholarship-program/");
			
			//Test case 13:Checking student mentorship button
			driver.findElement(By.linkText("Student Mentorship Program")).click();
			Thread.sleep(2000);
			
			//Test case 14:Checking Student SOS Program button
			driver.findElement(By.linkText("Student SOS Program")).click();
			Thread.sleep(2000);
			
			js.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
        
	
	//Testing page 6: About Us Page
	public void testAboutUsPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org");
			
			//Test case 15: Testing About us button on navbar
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/a"))).click().moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[1]/a"))).click().perform();
			Thread.sleep(2000);
			
			//Test case 16: Testing Vision, Mission and Values button
			driver.findElement(By.linkText("Vision, Mission and Values")).click();
			Thread.sleep(2000);
			
			//Test case 17: Testing Guiding Principles button
			driver.findElement(By.linkText("Guiding Principles")).click();
			Thread.sleep(2000);
			
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		BrowserTesting t = new BrowserTesting();
		t.startBrowser();
		System.out.println("6 Pages and 17 elements in total are tested");
	}
}
