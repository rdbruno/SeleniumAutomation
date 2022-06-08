import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    public static Properties getProp() throws IOException {
        Properties props= new Properties();
        FileInputStream file = new FileInputStream("./properties/application.properties");
        props.load(file);
        return props;
    }

    public static void main(String[] args) throws Exception {
        
        // STEP 01 - Variables section
        String chromePath;
        String chromeKey;
        String firefoxPath;
        String firefoxKey;
        String url;
        String item;

        Properties prop = getProp();
        chromePath = prop.getProperty("chromePath");
        chromeKey = prop.getProperty("chromeKey");
        firefoxPath = prop.getProperty("firefoxPath");
        firefoxKey = prop.getProperty("firefoxKey");
        url = prop.getProperty("urlPesq");
        item = prop.getProperty("itemPesq");

        // STEP 02 - Defining Chrome driver and opening Chrome browser
        System.setProperty(chromeKey, chromePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // SETP 03 - Validating the url opened at Chrome browser
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
        //WebDriverWait wait = new WebDriverWait(driver, 30);  

        //driver.findElement(By.linkText("Sandman: Edição Especial de 30 Anos Vol. 9")).click();
        //driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
        //List<WebElement> resultsList = driver.findElements(By.xpath(".//div[@class='a-section aok-relative s-image-square-aspect']"));
        //int size = resultsList.size();
        //System.out.println("Tamaho da lista: " + size);
        //resultsList.get(1).click();

        // STEP 06 - Close Chrome Browser
        driver.close();


        // ============= CHANGING TO FIREFOX ================ //


        // STEP 07 - Open Firefox browser
        System.setProperty(firefoxKey, firefoxPath);
        WebDriver fDriver = new FirefoxDriver();
        fDriver.manage().window().maximize();
        fDriver.get(url);

        // STEP 08 - Validating the url opened at Firefox browser
        String firefoxURL = fDriver.getCurrentUrl();
        if (url.equals(firefoxURL)) {
            System.out.println("Amazon aberta com sucesso!");
        } else {
            System.out.println("Site incorreto aberto!");
            fDriver.close();
        }

        // SETP 04 - Making the search of the item and sorting by prime filter
        WebElement searchBoxF = fDriver.findElement(By.cssSelector(("#twotabsearchtextbox")));
        searchBoxF.sendKeys(item);

        WebElement searchButtonF = fDriver.findElement(By.cssSelector((".nav-search-submit")));
        searchButtonF.click();

        WebElement checkPrimeF = fDriver.findElement(By.id("p_n_free_shipping_eligible/19171733011"));
        checkPrimeF.click();

        // STEP 09 - Close Firefox Browser
        fDriver.close();
    }
}