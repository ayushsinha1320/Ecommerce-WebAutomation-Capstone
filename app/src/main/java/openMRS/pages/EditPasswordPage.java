package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import openMRS.shared.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPasswordPage {

    private static EditPasswordPage editPasswordPage;
    private final FindElements findElements;
    private final Actions actions;
    private final PageWaits waits;

    private EditPasswordPage(WebDriver driver){
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
        this.waits = PageWaits.getPageWaitsObject(driver);
    }

    public static synchronized EditPasswordPage getInstance(WebDriver driver) {
        if (editPasswordPage == null) {
            editPasswordPage = new EditPasswordPage(driver);
        }
        return editPasswordPage;
    }

    private void enterOldPassword(String OldPassword){
        this.waits.waitUntilElementFoundByID("oldPassword-Field");
        WebElement oldPasswordField = findElements.ByID("oldPassword-field");
        actions.type(oldPasswordField,OldPassword);
    }
    private void enterNewPassword(String NewPassword){
        this.waits.waitUntilElementFoundByID("newPassword-Field");
        WebElement newPasswordField = findElements.ByID("newPassword-field");
        actions.type(newPasswordField,NewPassword);
    }
    private void enterConfirmPassword(String ConfirmPassword){
        this.waits.waitUntilElementFoundByID("confirmPassword-Field");
        WebElement confirmPasswordField = findElements.ByID("confirmPassword-field");
        actions.type(confirmPasswordField,ConfirmPassword);
    }
    private void clickSaveButton(){
        this.waits.waitUntilElementFoundByID("save-button");
        WebElement saveButtonLocator = findElements.ByID("save-button");
        actions.clickElement(saveButtonLocator);
    }

    private void editPassword(String OldPassword,String NewPassword){
        enterOldPassword(OldPassword);
        enterNewPassword(NewPassword);
        enterConfirmPassword(NewPassword);
        clickSaveButton();
    }
}
