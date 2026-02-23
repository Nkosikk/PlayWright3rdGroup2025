# Playwright Automation Framework - PlayWright3rdGroup2025

This project is a robust test automation framework built using **Playwright with Java**. It is designed to provide a structured, scalable, and maintainable approach to testing web applications. The framework incorporates modern testing practices, including the Page Object Model (POM) design pattern, comprehensive reporting, and flexible browser management.

## 🚀 Features

*   **Playwright Integration:** Fast, reliable, and capable of cross-browser testing (Chromium, Firefox, WebKit).
*   **Page Object Model (POM):** separation of test logic and page-specific code for better maintainability.
*   **Test Framework:** Utilizes **TestNG** for test organization, assertions, and execution control.
*   **Reporting:**
    *   **Allure Reports:** Detailed, interactive test execution reports.
    *   **Extent Reports:** Rich HTML reports with screenshots and logs.
*   **Video & Screenshot Capture:** Automatically captures evidence on test failure.
*   **Browser Factory:** Centralized management for browser instantiation and configuration.

## 🛠️ Tech Stack

*   **Language:** Java 21
*   **Automation Tool:** [Playwright](https://playwright.dev/java/) (v1.52.0)
*   **Test Runner:** [TestNG](https://testng.org/) (v7.11.0)
*   **Build Tool:** Maven
*   **Reporting:** [Allure](https://allurereport.org/) & [ExtentReports](https://www.extentreports.com/)

## 📂 Project Structure

The project follows a standard Maven directory structure with a custom organization for test artifacts:

```text
PlayWright3rdGroup2025/
├── src/test/java/
│   ├── Base/            # Base classes for test initialization and teardown
│   ├── BrowserFactory/  # Logic for creating and managing browser contexts
│   ├── Constants/       # Global constants and configuration variables
│   ├── ExtentReport/    # Configuration and utilities for Extent Reports
│   ├── Pages/           # Page Object classes representing web pages
│   ├── Runners/         # Test suites or custom runners
│   ├── TestData/        # Data providers or external data files
│   ├── Tests/           # Actual test scripts
│   └── aBasics/         # Basic examples and learning scripts
├── src/test/resources/  # Configuration files (e.g., testng.xml, properties)
├── target/              # Compiled binaries and build artifacts
├── videos/              # Recorded videos of test executions
├── Screenshots/         # Screenshots captured during tests (usually on failure)
├── allure-results/      # Raw data for generating Allure reports
├── pom.xml              # Maven project configuration and dependencies
└── README.md            # Project documentation
```

## ⚙️ Prerequisites

Before running the tests, ensure you have the following installed:

1.  **Java Development Kit (JDK) 21**
2.  **Maven** (usually bundled with IDEs like IntelliJ IDEA)
3.  **Git**

## 🏃‍♂️ How to Run Tests

You can execute tests using Maven from the command line or your IDE.

### Command Line

Run all tests specified in the default TestNG suite:
```bash
mvn clean test
```

### IDE (IntelliJ IDEA / Eclipse)

1.  Navigate to `src/test/java/Tests` or `src/test/java/Runners`.
2.  Right-click on a Test class or `testng.xml` file.
3.  Select **Run**.

## 📊 Generating Reports

### Allure Report
To view the Allure report after a test run:

```bash
mvn allure:serve
```
*Note: This requires the Allure Maven plugin or CLI tool.*

### Extent Report
Extent reports are typically generated in a `reports` or `test-output` folder (check the `ExtentReport` directory logic for the exact output path). Open the generated `.html` file in any browser.

## 📝 Configuration

*   **Dependencies:** Managed via `pom.xml`.
*   **Browser Configuration:** Check `src/test/java/BrowserFactory` to modify browser launch arguments (headless mode, viewport size, etc.).
