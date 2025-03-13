package tests;

import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest{

    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        contact.setContactLastName("ContactTest");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getContactLastName()), contact.getContactLastName());
    }
}
