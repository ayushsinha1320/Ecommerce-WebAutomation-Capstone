package openMRS.pages;

import openMRS.shared.Actions;
import openMRS.shared.FindElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenManageServiceType {
    private static OpenManageServiceType manageServiceType;
    private final FindElements findElements;
    private final Actions actions;

    public OpenManageServiceType(WebDriver driver) {
        this.findElements = FindElements.getInstance(driver);
        this.actions = Actions.getActionsObject(driver);
    }

    public static synchronized OpenManageServiceType getInstance(WebDriver driver) {
        if (manageServiceType == null) {
            manageServiceType = new OpenManageServiceType(driver);
        }
        return manageServiceType;
    }

    public void clickAppointmentScheduling(){
        WebElement appointmentSchedule = findElements.ByCSS("#appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension");
        actions.clickElement(appointmentSchedule);
    }

    public void clickManageServiceType(){
        WebElement manageServiceType = findElements.ByXPath("//*[@id=\"appointmentschedulingui-manageAppointmentTypes-app\"]");
        actions.clickElement(manageServiceType);

    }

    public void editManageServiceType(String name,String duration)  {
        WebElement clickEdit = findElements.ByCSS("#appointmentschedulingui-edit-General\\ Medicine\\ \\(New\\ Patient\\)");
        actions.clickElement(clickEdit);
       // Thread.sleep(10000);
        WebElement editName = findElements.ByID("name-field");
        actions.type(editName,name);
        WebElement editDuration = findElements.ByID("duration-field");
        actions.type(editDuration,duration);
        WebElement save = findElements.ByCSS("#save-button");
        actions.clickElement(save);
//        Thread.sleep(10000);

    }

    public void deleteManageServiceType(){
        WebElement delete = findElements.ByCSS("#appointmentschedulingui-delete-Dermatology\\ \\(New\\ Patient\\)");
        actions.clickElement(delete);
        WebElement deletePop = findElements.ByCSS("#delete-appointment-type-dialog > div.dialog-content > button.confirm.right");
        actions.clickElement(deletePop);

    }

    public void manageServiceType(String name,String duration) throws InterruptedException {
        clickAppointmentScheduling();
        clickManageServiceType();
        editManageServiceType(name,duration);
        deleteManageServiceType();

    }


}
