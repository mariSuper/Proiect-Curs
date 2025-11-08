package testts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeForm2 {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        // 1️⃣ Deschidem browserul și mergem pe site
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        // 2️⃣ Navigăm la formular
        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        js.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        js.executeScript("arguments[0].click();", practiceForm);

        // 3️⃣ Completăm câmpurile simple
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Mari";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Minea";
        lastNameElement.sendKeys(lastName);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String userEmail = "minea_m@gmail.com";
        emailElement.sendKeys(userEmail);

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        String userNumber = "0728335012";
        mobileElement.sendKeys(userNumber);

        //Date Of birth interaction
//declaram un web element
        WebElement dateOfBirth=driver.findElement(By.id("dateOfBirthInput"));
//facem click pe el
        dateOfBirth.click();
//identificam elementul din pagina by class name
        WebElement monthElement=driver.findElement(By.className("react-datepicker__month-select"));
//obiect de tip Select prin care interactionam direct cu lista
        Select monthSelect = new Select(monthElement);
//salvam valoarea lunii intr-o lista de tip String inainte de a apela metoda
        String monthValue = "January";
//interactionam prin obictul monthSelect - textul vizibil din lista 'luna'
        monthSelect.selectByVisibleText(monthValue);
        //Pentru an identificam elementul din pagina by class name
        WebElement yearElement=driver.findElement(By.className("react-datepicker__year-select"));
//obiect de tip Select prin care interactionam direct cu lista
        Select yearSelect = new Select(yearElement);
//salvam valoarea lunii intr-o lista de tip String inainte de a apela metoda
        String yearValue = "2030";
//interactionam prin obictul monthSelect - textul vizibil din lista 'luna'
        yearSelect.selectByVisibleText(yearValue);
// Găsim toate zilele din luna curentă (fără zilele din lunile adiacente)
        String dayValue ="5";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day--005')" +
                " and not(contains(@class, 'outside-month'))]"));
// Parcurgem lista de zile și selectăm ziua dorită
        for(int index=0; index<daysList.size(); index++){
            if(daysList.get(index).getText().equals(dayValue)){
                daysList.get(index).click();
                break;
            }
        }
        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddress = "Bragadiru";
        currentAddressElement.sendKeys(currentAddress);

        // 4️⃣ Selectăm genul
        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Male";
        switch (genderValue) {
            case "Male":
                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
                break;
            case "Female":
                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
                break;
            case "Other":
                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
                break;
        }

        // 5️⃣ Selectăm materiile
        WebElement subjectElementField = driver.findElement(By.id("subjectsInput"));
        //            String subjectValue = "Accounting";
        //            subjectElement.sendKeys(subjectValue);
        //            subjectElement.sendKeys(Keys.ENTER);
        List<String> subjectElements = Arrays.asList("Accounting", "Maths", "English");
        for (String subject : subjectElements) {
            subjectElementField.sendKeys(subject);
            subjectElementField.sendKeys(Keys.ENTER);
        }

        // 6️⃣ Selectăm hobby-urile
        List<String> hobbiesElements = Arrays.asList("Sports", "Reading", "Music");
        List<WebElement> hobbiesCheckList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < hobbiesElements.size(); i++) {
            js.executeScript("arguments[0].click();", hobbiesCheckList.get(i));
        }

        // 7️⃣ Încărcăm o poză
        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
        File resourcesDirectory = new File("src/test/resources/cursors.jpg");
        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());

        //Deschidem Dropdown-ul

        // 8️⃣ Selectăm statul și orașul
        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();", stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.xpath("//div[text()='Select City']"));
        js.executeScript("arguments[0].click();", cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        // 9️⃣ Trimitem formularul
        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);

        // 🔟 Verificăm mesajul de succes
        WebElement thankyouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankyouElement.getText(), "Thanks for submitting the form");

        //        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        //        closeElement.click();

        // 1️⃣1️⃣ Verificăm etichetele (header-urile) din tabel
        List<WebElement> labelList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        // 1️⃣2️⃣ Verificăm valorile completate
        List<WebElement> valueList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));
        Assert.assertEquals(valueList.get(0).getText(), firstName + " " + lastName);
        Assert.assertEquals(valueList.get(1).getText(), userEmail);
        Assert.assertEquals(valueList.get(2).getText(), genderValue);
        Assert.assertEquals(valueList.get(3).getText(), userNumber);
        Assert.assertEquals(valueList.get(5).getText(), String.join(", ", subjectElements));
        Assert.assertEquals(valueList.get(6).getText(), String.join(", ", hobbiesElements));
        Assert.assertEquals(valueList.get(7).getText(), resourcesDirectory.getName());
        Assert.assertEquals(valueList.get(8).getText(), currentAddress);
        Assert.assertTrue(valueList.get(9).getText().contains(stateValue));
        Assert.assertTrue(valueList.get(9).getText().contains(cityValue));

        // ✅ Test reușit — toate valorile verificate!
    }
}


