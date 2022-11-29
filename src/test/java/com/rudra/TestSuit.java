package com.rudra;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();

    @Test
    public void toVerifyMouseIsHoveringOverComputerMenuAndSubMenu(){
        //Be on homepage
        //Hover the mouse over computer menu and desktops sub menu
        homePage.toHoverMouseOverComputerMenuAndDesktopsSubMenu();
        //See the color is changing
    }
}
