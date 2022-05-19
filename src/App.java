import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
        
        // STEP 01 - Variables section
        String chromePath = "./drivers/chromedriver.exe";
        String chromeKey = "webdriver.chrome.driver";
        String url = "https://www.amazon.com.br/";
        String item = "Sandman 30 anos";

        System.setProperty(chromeKey, chromePath);

        // STEP 02 - Defining driver and opening browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // SETP 03 - Validating the url opened at browser
        String browserURL = driver.getCurrentUrl();
        if (url.equals(browserURL)) {
            System.out.println("Amazon aberta com sucesso!");
        } else {
            System.out.println("Site incorreto aberto!");
            driver.close();
        }

        // SETP 04 - Making the search of the item and sorting by prime filter
        WebElement searchBox = driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
        searchBox.sendKeys(item);

        WebElement searchButton = driver.findElement(By.cssSelector((".nav-search-submit")));
        searchButton.click();

        WebElement checkPrime = driver.findElement(By.id("p_n_free_shipping_eligible/19171733011"));
        checkPrime.click();

        // SETP 05 - Opening a item from the search
        //WebDriverWait wait = new WebDriverWait(driver, 15);  

        //driver.findElement(By.linkText("Sandman: Edição Especial de 30 Anos Vol. 9")).click();
        //driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
        //List<WebElement> resultsList = driver.findElements(By.xpath(".//div[@class='a-section aok-relative s-image-square-aspect']"));
        //int size = resultsList.size();
        //System.out.println("Tamaho da lista: " + size);
        //resultsList.get(1).click();


        // STEP 06 - Close browser
        //driver.close();

    }
}
