import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class task1 {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Reduced timeout
    }

    @Test
    @Order(1)
    @DisplayName("Navigate to Web Form")
    public void navigateToWebForm() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        assertTrue(driver.getTitle().contains("Practice webform"), "Page title does not contain expected text!");
    }

    @Test
    @Order(2)
    @DisplayName("Fill Name Field")
    public void fillNameField() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-name")).sendKeys("Md.Shariar Emon Shaikat");
    }

    @Test
    @Order(3)
    @DisplayName("Fill Number Field")
    public void fillNumberField() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-number")).sendKeys("01946923532");
    }

    @Test
    @Order(4)
    @DisplayName("Fill Date Field")
    public void fillDateField() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-date")).sendKeys("02/12/2024");
    }

    @Test
    @Order(5)
    @DisplayName("Fill Email Field")
    public void fillEmailField() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-email")).sendKeys("shariar.emon.shaikat@g.bracu.ac.bd");
    }

    @Test
    @Order(6)
    @DisplayName("Fill About Yourself Field")
    public void fillAboutYourselfField() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I'm Shaikat, a CSE student navigating the challenges of life and studies.");
    }

    @Test
    @Order(7)
    @DisplayName("Upload Document")
    public void uploadDocument() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String relativePath = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Md.Shariar Emon Shaikat.pdf";
        String absolutePath = System.getProperty("user.dir") + relativePath;
        File file = new File(absolutePath);
        if (!file.exists()) {
            throw new RuntimeException("File not found at path: " + absolutePath);
        }
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(file.getAbsolutePath());
    }

    @Test
    @Order(8)
    @DisplayName("Click Checkbox")
    public void clickCheckbox() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
        try {
            checkbox.click();
        } catch (Exception e) {
            System.out.println("Standard click failed, attempting JavaScript click.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
        }
    }

    @Test
    @Order(9)
    @DisplayName("Submit Form")
    public void submitForm() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        submitButton.click();
    }

//    @Test
    @Order(10)
    @DisplayName("Verify Success Message")
    public void verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("container")));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Thank you for your submission!";
        assertEquals(expectedMessage, actualMessage, "The success message does not match!");
    }

    @AfterEach
    public void tearDown() {
        // Close the WebDriver instance
         driver.quit();
    }
}
