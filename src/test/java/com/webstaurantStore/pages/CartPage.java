package com.webstaurantStore.pages;

import com.webstaurantStore.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//div//button[text()='Empty']")
    public WebElement emptyCartNotification;

    @FindBy(xpath = "//div[@class='cartEmpty']//p[@class='header-1']")
    public WebElement message;

    @FindBy(xpath = "//div[@class='cartItems']//span[@class='itemDescription description overflow-visible']//a")
    public WebElement titleOfProduct;

}
