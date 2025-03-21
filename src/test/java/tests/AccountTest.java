package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt());
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80296546637");
        account.setDescription("nothing");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountListPage.getPhoneByAccountName(account.getPhone()), account.getPhone());
        Assert.assertSame(accountListPage.getOwnerByAccountName(account.getAccountName()), "GAlek");
    }

    @Test
    public void checkNewAccountData() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt());
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80296546637");
        account.setDescription("nothing");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage
                .openPage(ACCOUNT_LIST_URL);
        accountPage
                .accountPageId(account);
        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountListPage.getAccountPhone(account.getPhone()), "80296546637");
        Assert.assertSame(accountListPage.getOwnerByAccountName(account.getAccountName()), "GAlek");
    }
}
