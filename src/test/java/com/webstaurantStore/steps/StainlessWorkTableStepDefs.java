package com.webstaurantStore.steps;


import com.webstaurantStore.pages.*;

import com.webstaurantStore.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class StainlessWorkTableStepDefs {


    DashboardPage dashboardPage= new DashboardPage();
    CartPage cartPage= new CartPage();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));



    @Given("the user lands on the home page")
    public void the_user_lands_on_the_home_page() {
        //this step can be parametrized but since it is one page, I prefer to not parametrize it
        //The code to open the URL is already mentioned in the Hooks
        System.out.println("User is on the homepage");
    }

    @When("user searches for {string}")
    public void user_searches_for(String searchWord) {
        dashboardPage.searchBox.sendKeys(searchWord, Keys.ENTER);
    }

    @Then("the user should see the word {string} in the title of each product")
    public void the_user_should_see_the_word_in_the_title_of_each_product(String word) {
        for (WebElement each: dashboardPage.product){
            Assert.assertTrue(each.getText().contains(word));
            System.out.println(each.getText());// this is only for your observation
        }
    }
    @Then("the user should be able to add the last found items to the Cart")
    public void the_user_should_be_able_to_add_the_last_found_items_to_the_cart() {
        int size= dashboardPage.addToCart.size();
        WebElement lastProduct= dashboardPage.addToCart.get(size - 1);

        //to verify that we added the last product in the cart, we need the text of last product
        String lastProductText = dashboardPage.product.get((dashboardPage.product.size())-1).getText();


        lastProduct.click();


        //we will compare if the title of last product that we added to the cart is same as the notification text that we got
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.selectedItemNotification));
        String titleOfSelectedProductInTheCart = dashboardPage.selectedItemNotification.getText();
        System.out.println("titleOfSelectedProductInTheCart = " + titleOfSelectedProductInTheCart); //for your observation
        System.out.println("lastProductText = " + lastProductText); //for your observation
        Assert.assertEquals(lastProductText,titleOfSelectedProductInTheCart);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //close the notification
        dashboardPage.notificationCloseButton.click();



    }
    @Then("the user should be able to empty the cart.")
    public void the_user_should_be_able_to_empty_the_cart() {



        Actions actions= new Actions(Driver.getDriver());
        actions.scrollToElement(dashboardPage.cartButton).perform();


        //wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.cartButton));

       dashboardPage.cartButton.click();



        cartPage.emptyCartButton.click();
        cartPage.emptyCartNotification.click();

        Assert.assertEquals("Your cart is empty.",cartPage.message.getText());




    }

}
