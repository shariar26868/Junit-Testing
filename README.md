# Automation Project: Web Form Testing

![as2](https://github.com/user-attachments/assets/bf5c5ec5-62ab-496f-8a8d-310f74b55359)

## Overview
This project automates two web forms using Selenium and JUnit.
### Web Forms 

1. **Practice Web Form**: [Practice Webform for Learners](https://www.digitalunite.com/practice-webform-learners)
2. **Guest Registration Form**: [Guest Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form/)

## Prerequisites
- Java Development Kit (JDK) 7 or higher
- Gradle
- Selenium WebDriver
- ChromeDriver (or other browser drivers)
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup
1. Install the appropriate browser driver (e.g., ChromeDriver) and add it to your system PATH.

## Automation Steps

### Practice Web Form
1. Navigate to the form URL.
2. Input all required fields.
3. Upload a file (maximum size 2MB).
4. Submit the form.
5. Verify success message: `"Thank you for your submission!"`.

### Guest Registration Form
1. Navigate to the form URL.
2. Input fields:
   - First Name, Last Name, Email, Gender
   - Date of Birth, Nationality, Phone Number, Country (Bangladesh)
3. Agree to Terms & Conditions.
4. Submit the form.
5. Verify registration success.

## Run Instructions
1. Open the project in your IDE.
2. Run the tests using JUnit.
3. Monitor browser automation and console logs.

## Troubleshooting
- **Element Not Found**: Verify locators and adjust wait times.
- **Driver Mismatch**: Ensure the browser version matches the driver.
- **Validation Issues**: Use valid input data for forms.





