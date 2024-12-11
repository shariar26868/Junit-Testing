import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(OrderAnnotation.class)
public class task2 {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        // Set up the WebDriver (use the correct driver for your browser)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    @DisplayName("Test: Open Registration Form")
    public void openRegistrationForm() {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
    }

    @Test
    @Order(2)
    @DisplayName("Test: Fill Personal Information")
    public void fillPersonalInformation() {
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
    }

    @Test
    @Order(3)
    @DisplayName("Test: Select Gender")
    public void selectGender() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("radio_1665627729")));
        List<WebElement> genderCheckboxes = driver.findElements(By.name("radio_1665627729"));
        if (!genderCheckboxes.isEmpty()) {
            genderCheckboxes.get(0).click();
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test: Fill Contact Details")
    public void fillContactDetails() {
        List<WebElement> form = driver.findElements(By.className("form-row"));
        form.get(6).findElement(By.tagName("input")).sendKeys("01735567745");
        form.get(7).findElement(By.tagName("input")).sendKeys("01945967545");
        form.get(8).findElement(By.tagName("input")).sendKeys("Bangladeshi");
    }

    @Test
    @Order(5)
    @DisplayName("Test: Select Country")
    public void selectCountry() {
        WebElement countryDropdown = driver.findElement(By.id("country_1665629257"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("Bangladesh");
    }

    @Test
    @Order(6)
    @DisplayName("Test: Fill Additional Information")
    public void fillAdditionalInformation() {
        List<WebElement> form = driver.findElements(By.className("form-row"));
        form.get(11).findElement(By.tagName("input")).sendKeys("5");
        form.get(12).findElement(By.tagName("input")).sendKeys("Room number 302 and Bed Number is 02");
    }

    @Test
    @Order(7)
    @DisplayName("Test: Select Preferences")
    public void selectPreferences() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
    }

    @Test
    @Order(8)
    @DisplayName("Test: Select Activities")
    public void selectActivities() {
        WebElement activities = driver.findElement(By.id("select_1665628361_field"));
        Select attend = new Select(activities);
        attend.selectByIndex(1);
    }

    @Test
    @Order(9)
    @DisplayName("Test: Agree to Terms and Submit")
    public void agreeAndSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
