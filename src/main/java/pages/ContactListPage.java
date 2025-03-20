package pages;

import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{

    public static final String TABLE_CONTACT_XPATH = "//table";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_CONTACT_XPATH + "//a[contains(@title, '%s')]";
    public static final String ACCOUNT_NAME_ON_CAONTACT_PAGE_XPATH = TABLE_CONTACT_XPATH + "//a[contains(@title, '%s')]";
    public static final String CONTACT_PHONE_FIELD_XPATH = TABLE_CONTACT_XPATH + "//span[contains(@class, 'forceOutputPhone')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url){
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).getText();
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_ON_CAONTACT_PAGE_XPATH, accountName))).getText();
    }

    public String getExistContactPhone(String phone) {
        return driver.findElement(By.xpath(String.format(CONTACT_PHONE_FIELD_XPATH, phone))).getText();
    }
}
