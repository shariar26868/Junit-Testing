# Junit-Testing
/*
Automation Project: Web Form Testing

Overview

This project automates the process of testing two web forms using Selenium WebDriver and JUnit.

Prerequisites

Software Requirements

Java Development Kit (JDK): Version 8 or higher.

Maven: For dependency management.

Maven Dependencies

Add the following dependencies to your pom.xml:

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

Automation Steps

Practice Web Form

Navigate to the form URL: Practice Web Form.

Input all required fields, such as First Name, Last Name, etc.

Upload a file (Maximum size: 2MB).

Submit the form.

Assert that the success message: "Thank you for your submission!" is displayed.

Guest Registration Form

Navigate to the form URL: Guest Registration Form.

Input the following fields:

First Name, Last Name, User Email, Gender, Date of Birth, Nationality, and Phone.

Select "Bangladesh" for Country.

Agree to the Terms & Conditions checkbox.

Submit the form.

Assert that the registration is successful.

Running Tests

Open the project in your preferred IDE.

Run the JUnit tests:

Each test is annotated with @Test and @Order.

Monitor browser interactions during the test execution.

Check the console output for validation of success messages.

Troubleshooting

Common Issues

Element Not Found:

Use WebDriverWait to handle delayed loading elements.

Inspect the webpage to confirm element locators are correct.

Driver Mismatch:

Ensure that the browser and WebDriver versions match.

Update the WebDriver and add it to the system PATH if necessary.

Notes

For detailed documentation, refer to the official Selenium WebDriver Documentation and JUnit 5 User Guide.




