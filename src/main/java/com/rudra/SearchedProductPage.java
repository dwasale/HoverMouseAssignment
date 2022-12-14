package com.rudra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchedProductPage extends Utils{
    //Unique elements locators
    private By _searchedProductItems = By.xpath("//h2[@class='product-title']");
    private String itemToSearch = LoadProp.getProperty("Text");

    public void toGetAllTheSearchedItem(){
        //Get all the list of searched items
        List<WebElement> productList = driver.findElements(_searchedProductItems);
        for (WebElement items: productList){
            System.out.println(items.getText());
            //Checking whether the searched items are correct
            Assert.assertTrue(items.getText().toLowerCase().contains(itemToSearch.toLowerCase()),"Searched items are different");
        }

    }
}
