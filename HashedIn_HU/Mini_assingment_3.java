package HashedIn_HU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mini_assingment_3 {
    public static void main(String[] args) {

        Ticket_booking();

    }
        static void Frame_assingment(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\praparihar\\IdeaProjects\\Selenium_test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        //clicking on frame ;
        driver.findElement(By.xpath("//*[text()='Frames']")).click();
        driver.findElement(By.xpath("//*[text()='Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement m = driver.findElement(By.xpath("//body"));
        System.out.println("Element identified with xpath: " +m.getText());
        driver.close();}
        // Alert_assignment();
        // Ticket_booking();



       static  void Drag_drop(){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\praparihar\\IdeaProjects\\Selenium_test\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //getting the url
            driver.get("https://jqueryui.com/droppable/");
            driver.manage().window().maximize();
            //Creating a action class method to drag and drop
            Actions builder = new Actions(driver);
            driver.switchTo().frame(0);
            WebElement from = driver.findElement(By.id("draggable"));
            WebElement to = driver.findElement(By.id("droppable"));
            //perform drag and drop
            builder.dragAndDrop(from, to).perform();

        }

        static void Alert_assignment(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\praparihar\\IdeaProjects\\Selenium_test\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
            driver.manage().window().maximize();


            //clicking on elements
            driver.findElement(By.xpath("//*[text()='JavaScript Alerts']")).click();
            driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();


            //Alert handling
            String Input = "TEXT1234";
            driver.switchTo().alert().sendKeys(Input);
            String alert_text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            //checking the result
            String dynamic_path = "//*[text() = \"You entered: null\"]";
            String Result_text = driver.findElement(By.xpath(dynamic_path.replace("null",Input ))).getText();

            if (Result_text.equals("You entered: "+Input)){
                System.out.println(Result_text);
            }
            System.out.println(alert_text);

        }
        static void Ticket_booking(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\praparihar\\IdeaProjects\\Selenium_test\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(" https://www.goibibo.com/");
            driver.manage().window().maximize();

            //Selecting a round trip
            driver.findElement(By.xpath("//*[text() = \"Round-trip\"]")).click();

            //Selecting the New York (NYC) and Seatle
            driver.findElement(By.xpath("//*[text()=\"From\"]/following-sibling::*[text() = \"Enter city or airport\"]")).click();
            
        }
}
