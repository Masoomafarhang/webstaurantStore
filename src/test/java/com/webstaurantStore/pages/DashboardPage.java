package com.webstaurantStore.pages;

import com.webstaurantStore.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "searchval")
    public WebElement searchBox;

    @FindBy (xpath = "(//button[@value='Search'])[1]")
    public WebElement searchButton;


    @FindBy(xpath = "//div [@id= 'ProductBoxContainer']//span[@data-testid='itemDescription']")
    public List<WebElement> product;


    @FindBy(xpath = "//div [@id= 'ProductBoxContainer']//input[@gtm-id='AddToCartATC']")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//a[@data-testid='cart-button']")
    public WebElement cartButton;

    @FindBy(xpath = "//div[@id='watnotif-wrapper']//a[@href='/viewcart.cfm']")
    public WebElement viewCart;

    @FindBy(xpath = "//div[@id='watnotif-wrapper']//div[@class='notification__description']")
    public WebElement selectedItemNotification;

    @FindBy(xpath = "//p[@class='msg']//button")
    public WebElement notificationCloseButton;









}
