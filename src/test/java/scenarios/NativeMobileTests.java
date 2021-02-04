package scenarios;

import coretest.InitializationTest;
import dataprovider.DataProviderForTests;
import org.testng.annotations.Test;

public class NativeMobileTests extends InitializationTest {

    @Test(
            groups = {"native"},
            description = "Register a new account and then sign in",
            dataProvider = "assertDataNativeApplication",
            dataProviderClass = DataProviderForTests.class
    )
    public void registerNewAccount(String expectedBudgetPage, String email,
                                   String username, String password) {

        assertionStepNativeApp.checkThatHomePageWasOpened();
        stepNativeApp.openRegistrationPage();
        stepNativeApp.fillEmailTextFieldByNewEmail(email);
        stepNativeApp.fillUsernameTextFieldByNewUsername(username);
        stepNativeApp.fillPasswordTextFieldByNewPassword(password);
        stepNativeApp.fillConfirmPasswordTextFieldByNewPassword(password);
        stepNativeApp.clickOnCheckBox(); //todo <<---??
        stepNativeApp.clickOnRegistrationButton();
        stepNativeApp.fillEmailTextFieldByCreatedEmail(email);
        stepNativeApp.fillPasswordTextFieldByCreatedPassword(password);
        stepNativeApp.clickOnSignInButton();
        assertionStepNativeApp.checkThatBudgetPageWasOpened(expectedBudgetPage);

        // Log that test finished
        System.out.println("Simplest Android native test done");
    }

}