# Junit-Testing
/*
 * Automation Project: Web Form Testing
 * 
 * Overview:
 * This project automates the process of testing two web forms using Selenium WebDriver and JUnit.
 */

// Prerequisites
/*
 * 1. Install Java Development Kit (JDK) 8 or higher.
 * 2. Set up Maven for dependency management.
 * 3. Add the following Maven dependencies to the pom.xml:
 */

<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.x.x</version>
    </dependency>
</dependencies>

// Automation Steps for Practice Web Form
/*
 * 1. Navigate to the form URL: https://www.digitalunite.com/practice-webform-learners
 * 2. Fill all required fields (e.g., First Name, Last Name, etc.).
 * 3. Upload a file (max size: 2MB).
 * 4. Submit the form.
 * 5. Assert that the success message: "Thank you for your submission!" is displayed.
 */

// Automation Steps for Guest Registration Form
/*
 * 1. Navigate to the form URL: https://demo.wpeverest.com/user-registration/guest-registration-form/
 * 2. Fill the following fields:
 *    - Firstname, Lastname, Email, Gender, Date of Birth, Nationality, Phone.
 *    - Country: Select "Bangladesh".
 * 3. Agree to the Terms & Conditions checkbox.
 * 4. Submit the form.
 * 5. Assert that the registration was successful.
 */

// Running Tests
/*
 * 1. Open the project in your preferred IDE.
 * 2. Run the JUnit tests:
 *    - Each test is annotated with @Test and @Order.
 * 3. Monitor the browser interactions.
 * 4. Check the console output for validation of success messages.
 */

// Troubleshooting
/*
 * Common issues and their resolutions:
 * 
 * 1. Element Not Found:
 *    - Use WebDriverWait to handle delayed loading elements.
 *    - Inspect the webpage to confirm element locators.
 * 
 * 2. Driver Mismatch:
 *    - Ensure that the browser and driver versions match.
 *    - Update the driver and add it to the PATH if needed.
 */



