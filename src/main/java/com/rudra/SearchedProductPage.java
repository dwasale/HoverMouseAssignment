package com.rudra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchedProductPage extends Utils{
    private By _searchedProductItems = By.xpath("//h2[@class='product-title']");
    private String itemToSearch = LoadProp.getProperty("Text");

    public void toGetAllTheSearchedItem(){

        List<WebElement> productList = driver.findElements(_searchedProductItems);
        for (WebElement items: productList){
            System.out.println(items.getText());
            Assert.assertTrue(items.getText().toLowerCase().contains(itemToSearch.toLowerCase()),"Searched items are different");
        }

    }
}
