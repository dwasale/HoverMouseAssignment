package com.rudra;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    SearchedProductPage searchedItems = new SearchedProductPage();

    @Test
    public void toVerifyMouseIsHoveringOverComputerMenuAndSubMenu(){
        //Be on homepage
        //Hover the mouse over computer menu and desktops sub menu
        homePage.toHoverMouseOverComputerMenuAndDesktopsSubMenu();
        //See the color is changing
    }

    @Test
    public void toVerifyWhileSearchingCorrectItemsAreShowing(){
        //Be on home Page
        //Goto search bar
        //Type any item and hit the search button
        homePage.toSearchAnyItem();
        //Check that it is showing correct items
        searchedItems.toGetAllTheSearchedItem();
    }
}
