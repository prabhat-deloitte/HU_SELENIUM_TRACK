package HashedIn_HU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headless_execution {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\praparihar\\IdeaProjects\\Selenium_test\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

        driver.get("https://phptravels.com/demo");


        //Mazimize current window
        driver.manage().window().maximize();


        //Navigating to phptravels
        driver.get("https://phptravels.com/demo");


        //getting Title of webpage
        String received_title = driver.getTitle();
        String checked_title = "PHPTRAVELS";
        System.out.println(Check_Title(received_title,checked_title));


        //Clicking login button
        driver.findElement(By.xpath("//*[text() ='Login']")).click();
        String Login_page_title = driver.getTitle();
        System.out.println(Login_page_title);
        System.out.println(Check_Title(Login_page_title,received_title));


        //Switching back to phptravels_home_page
        String parentHandle = driver.getWindowHandle();
        driver.switchTo().window(parentHandle);

        //getting url of current tab
        String curr_url = driver.getCurrentUrl();
        System.out.println(curr_url);

        //Clicking on Prcing
        driver.findElement(By.xpath("//a[text() = \"Pricing\"]")).click();

        //Navigating Back using webdriver back method
        driver.navigate().back();

        //refresh the page
        driver.navigate().refresh();

        //close chrome
        driver.quit();

    }

    public static String Check_Title(String received, String check_title)   {
        if (received.equals(check_title)){
            return "PASS";}
        return "FAIL";
    }

}
