package Pages;

import com.microsoft.playwright.Page;

public class SignUpPage {
    Page page;

    private String firstNameFieldLocator = "#register-firstname";
    private String lastNameFieldLocator = "#register-lastname";
    private String emailFieldLocator = "#register-email";
    private String passwordFieldLocator = "#register-password";
    private String confirmPasswordFieldLocator = "#register-confirmPassword";
    private String groupSelectLocator = "#register-group";
    private String submitButtonLocator = "#register-submit";


    public SignUpPage(Page page) {
        this.page = page;
    }

    public SignUpPage enterFirstName(String firstName) {
        page.fill(firstNameFieldLocator, firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        page.fill(lastNameFieldLocator, lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        page.fill(emailFieldLocator, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        page.fill(passwordFieldLocator, password);
        return this;
    }

    public SignUpPage enterConfirmPassword(String confirmPassword) {
        page.fill(confirmPasswordFieldLocator, confirmPassword);
        return this;
    }

    public SignUpPage selectGroup(String group) {
        page.selectOption(groupSelectLocator, group);
        return this;
    }

    public SignUpPage clickSubmitButton() {
        page.click(submitButtonLocator);
        return this;
    }

}
