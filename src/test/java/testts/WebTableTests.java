package testts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTableTests {

    public WebDriver driver;

    @Test

    public void metodaTest() throws InterruptedException {

        //deschidem un browser
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        //accesam un URL
        driver.get("https://demoqa.com/");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        js.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        js.executeScript("arguments[0].click();", webTables);

// Dimensiunea inițială
        List<WebElement> continutTabel = driver.findElements(
                By.xpath("//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]"));
        System.out.println("Dimensiunea tabelului este " + continutTabel.size());
        Assert.assertEquals(continutTabel.size(), 3, "marimea tabelului nu este 3 ");

        //definim un element; click pe Add
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();


        Thread.sleep(1000); // mică pauză de siguranță, 1 secundă
        List<WebElement> continutTabelNou = driver.findElements(
                By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Mari";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Mreana";
        lastNameElement.sendKeys(lastName);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String email = "Man@yahoo.com";
        userEmailElement.sendKeys(email);

        WebElement ageElement = driver.findElement(By.id("age"));
        String age = "45";
        ageElement.sendKeys(age);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salary = "513";
        salaryElement.sendKeys(salary);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String department = "IT";
        departmentElement.sendKeys(department);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Așteptăm până când apare noul nume introdus ("Mari") în tabel
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.className("rt-tbody"),
                        "Mari"));

        Thread.sleep(1000); // mică pauză extra pentru refresh

        //Verificăm noua dimensiune a tabelului (Apoi recalculează lista)
        List<WebElement> continutTabelNou1 = driver.findElements(
                By.xpath("//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]"));
        Assert.assertEquals(continutTabelNou1.size(), 4, "marimea tabelului nu este 4 ");

        //Validăm valorile introduse în ultimul rând adăugat
        String continutRand = continutTabelNou1.get(continutTabelNou1.size() - 1).getText();
        System.out.println("Rând nou adăugat: " + continutRand);
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine firstName value");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine lastName value");
        Assert.assertTrue(continutRand.contains(email), "Randul nu contine email value");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine age value");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary value");
        Assert.assertTrue(continutRand.contains(department), "Randul nu contine department value");

        // Așteaptă până când fereastra modală dispare complet
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-content")));

        //        driver.quit();
        }
    }
