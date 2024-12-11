import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class junit_test {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        // Setup ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Reduced timeout
    }
    @DisplayName("Write the Name")
    @Test
    public void testautomation() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-name")).sendKeys("Md.Shariar Emon Shaikat");
        driver.findElement(By.id("edit-number")).sendKeys("01946923532");
        driver.findElement(By.id("edit-date")).sendKeys("02/12/2024");
        driver.findElement(By.id("edit-email")).sendKeys("shariar.emon.shaikat@g.bracu.ac.bd");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I'm Shaikat, a CSE student navigating the challenges of life and studies.");
        String relativepath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Md.Shariar Emon Shaikat.pdf";
        String absolutepath = System.getProperty("user.dir") + relativepath;
        File file = new File(absolutepath);
        if (!file.exists()) {
            throw new RuntimeException("File not found at path: " + absolutepath);
        }
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(file.getAbsolutePath());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
        try {
            checkbox.click(); // Standard click
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JavaScript click.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox); // JavaScript click as a fallback
        }
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("container")));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Thank you for your submission!";
        assertEquals(expectedMessage, actualMessage, "The success message does not match!");
    }

//
//
//
//
//
//
//
    @DisplayName("2nd link Automation")

    @Test
    public void testautomation_secondlinke(){
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("form-row")));
        List<WebElement> form = driver.findElements(By.className("form-row"));
        System.out.println("Form size: " + form.size());
        if (form.size() < 13) {
            throw new IllegalStateException("Not enough form fields detected.");
        }
        form.get(0).findElement(By.tagName("input")).sendKeys("Md. Shariar Emon");
        form.get(1).findElement(By.tagName("input")).sendKeys("semonshaikat702@gmail.com");
        form.get(2).findElement(By.tagName("input")).sendKeys("S1h2a3i4#");
        form.get(3).findElement(By.tagName("input")).sendKeys("Shaikat");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("radio_1665627729")));
        List<WebElement> genderCheckboxes = driver.findElements(By.name("radio_1665627729"));
        if (!genderCheckboxes.isEmpty()) {
            genderCheckboxes.get(0).click();
        }

        form.get(6).findElement(By.tagName("input")).sendKeys("01735567745");
        form.get(7).findElement(By.tagName("input")).sendKeys("01945967545");
        form.get(8).findElement(By.tagName("input")).sendKeys("Bangladeshi");
        WebElement countryDropdown = driver.findElement(By.id("country_1665629257"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("Bangladesh");
        form.get(11).findElement(By.tagName("input")).sendKeys("5");
        form.get(12).findElement(By.tagName("input")).sendKeys("Room number 302 and Bed Number is 02");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("radio_1665627931_field")));
        List<WebElement> parkingCheckboxes = driver.findElements(By.name("radio_1665627931_field"));
        if (!parkingCheckboxes.isEmpty()) {
            parkingCheckboxes.get(0).click();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("radio_1665627997_field")));
        List<WebElement> preference = driver.findElements(By.name("radio_1665627997_field"));
        if (!preference.isEmpty()) {
            preference.get(0).click();
        }
        List<WebElement> restriction = driver.findElements(By.name("radio_1665628131_field"));
        if (!restriction.isEmpty()) {
            restriction.get(0).click();
        }
        WebElement activities = driver.findElement(By.id("select_1665628361_field"));
        Select attend = new Select(activities);
        attend.selectByIndex(1);
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
        try {
            checkbox.click(); // Standard click
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JavaScript click.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox); // JavaScript click as a fallback
        }
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    //    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
