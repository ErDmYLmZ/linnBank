package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.MyAccountsPage;
import com.linnbank.pages.TransferMoneyPage;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TransferMoney {

    TransferMoneyPage transferMoneyPage = new TransferMoneyPage();
    MyAccountsPage myAccountsPage = new MyAccountsPage();
    Faker fake = new Faker();
    Random random = new Random();

    String firstAccountId;
    String secondAccountId;
    double firstBalance;
    double secondBalance;

    @And("retrieve account data")
    public void retrieveAccountData() {
        // It will retrieve all the account IDs and balance amounts from My Accounts page regardless of number of accounts
        List<String> allAccountsId = ReusableMethods.convertWebElementListToStringList(myAccountsPage.allAccountsId);
        List<String> allAccountsBalance = ReusableMethods.convertWebElementListToStringList(myAccountsPage.allAccountsBalance);
        // get 2 random account IDs to make transfer between accounts (random IDs must be different)
        int firstRandomIndex = random.nextInt(allAccountsId.size());
        int secondRandomIndex = random.nextInt(allAccountsId.size());
        while (firstRandomIndex == secondRandomIndex) {
            secondRandomIndex = random.nextInt(allAccountsId.size());
        }

        firstAccountId = allAccountsId.get(firstRandomIndex);
        secondAccountId = allAccountsId.get(secondRandomIndex);
        // convert String balances to Double to be able to compare
        firstBalance = Double.parseDouble(allAccountsBalance.get(firstRandomIndex)) / 100;
        secondBalance = Double.parseDouble(allAccountsBalance.get(secondRandomIndex)) / 100;
    }

    @And("customer choose first account to transfer money from")
    public void customerChooseFirstAccountToTransferMoneyFrom() {
        Select selectFrom = new Select(transferMoneyPage.fromAccountDropdown);
        ReusableMethods.waitForVisibility(transferMoneyPage.fromAccountDropdown, 10);
        // store all account dropdown options
        List<String> allAccounts = ReusableMethods.convertWebElementListToStringList(selectFrom.getOptions());
        // check the amount and choose the account with more balance between two chosen accounts
        String fromAccount = firstBalance > secondBalance ?
                allAccounts.stream().filter(t -> t.contains(firstAccountId)).collect(Collectors.toList()).get(0) :
                allAccounts.stream().filter(t -> t.contains(secondAccountId)).collect(Collectors.toList()).get(0);

        selectFrom.selectByVisibleText(fromAccount);
    }


    @And("customer choose second account to transfer money to")
    public void customerChooseSecondAccountToTransferMoneyTo() {
        Select selectTo = new Select(transferMoneyPage.toAccountDropdown);
        ReusableMethods.waitForVisibility(transferMoneyPage.toAccountDropdown, 10);
        // store all account dropdown options
        List<String> allAccounts = ReusableMethods.convertWebElementListToStringList(selectTo.getOptions());
        // check the amount and choose the account with less balance between two chosen accounts
        String toAccount = firstBalance < secondBalance ?
                allAccounts.stream().filter(t -> t.contains(firstAccountId)).collect(Collectors.toList()).get(0) :
                allAccounts.stream().filter(t -> t.contains(secondAccountId)).collect(Collectors.toList()).get(0);

        selectTo.selectByVisibleText(toAccount);

    }

    @And("customer enters the transaction amount")
    public void customerEntersTheTransactionAmount() {
        // to make sure not to exceed current balance, choose a random amount up to current balance
        String transactionAmount = firstBalance > secondBalance ?
                String.valueOf(random.nextInt((int) firstBalance)) :
                String.valueOf(random.nextInt((int) secondBalance));

        transferMoneyPage.amount.sendKeys(transactionAmount);
        ReusableMethods.clearAndSendText(transferMoneyPage.amountDecimal, "00");
    }

    @And("customer enters the description")
    public void customerEntersTheDescription() {
        transferMoneyPage.description.sendKeys(fake.internet().uuid());
    }

    @Then("customer clicks on make transfer button")
    public void customerClicksOnMakeTransferButton() {
        transferMoneyPage.makeTransfer.click();
    }

    @Then("customer verify the success message")
    public void customerVerifyTheSuccessMessage() {
        ReusableMethods.waitForVisibility(transferMoneyPage.popupMessage, 5);
        Assert.assertTrue(transferMoneyPage.popupMessage.getText().contains("Transfer is succesfull"));
    }
}
