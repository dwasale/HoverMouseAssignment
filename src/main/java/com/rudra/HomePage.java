package com.rudra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class HomePage extends Utils{
    private By _computerMenu = By.linkText("Computers");
    private By _desktopsSubMenu = By.linkText("Desktops");
    public void toHoverMouseOverComputerMenuAndDesktopsSubMenu(){
        //Object for actions methods that performs click and hold at the location of elements
        Actions actions = new Actions(driver);
        //Getting location of the given element for computer menu
        WebElement computerMenuElement = driver.findElement(_computerMenu);
        //Getting color code of Computer from menu before hovering
        String computerTextColor = computerMenuElement.getCssValue("color");
        //Getting the Hex code of the color
        String hexCode = Color.fromString(computerTextColor).asHex();
        System.out.println("Computer menu text color before hovering: " + computerTextColor);
        System.out.println("HexCode: " + hexCode);
        //Hover mouse over computer menu
        actions.moveToElement(computerMenuElement).perform();
        //Getting the color of Computer menu after hovering
        String afterHoverComputerTextCode = computerMenuElement.getCssValue("color");
        //Getting the Hex code of the color
        String afterHoverHexCode = Color.fromString(afterHoverComputerTextCode).asHex();
        System.out.println("Computer menu text color after hovering: " + afterHoverComputerTextCode);
        System.out.println("HexCode: "+ afterHoverHexCode);
        //To check before and after hovering the element has different color
        Assert.assertNotEquals(computerTextColor,afterHoverHexCode,"Expected color matched");
        //Getting location of the given element for desktops submenu
        WebElement desktopsSubMenuElement = driver.findElement(_desktopsSubMenu);
        String desktopsSubMenuColor = desktopsSubMenuElement.getCssValue("background-color");
        String hexCodeDesktops = Color.fromString(desktopsSubMenuColor).asHex();
        System.out.println("Desktops submenu background color before hovering: " + desktopsSubMenuColor);
        System.out.println("HexCode: " + hexCodeDesktops);
        //Hover mouse over desktops submenu
        actions.moveToElement(desktopsSubMenuElement).perform();
        String afterHoveringDesktopsSubMenu = desktopsSubMenuElement.getCssValue("color");
        String hexCodeAfterHovering = Color.fromString(afterHoveringDesktopsSubMenu).asHex();
        System.out.println("Desktops submenu background color after hovering: " + afterHoveringDesktopsSubMenu);
        System.out.println("HexCode: " + hexCodeAfterHovering);
        Assert.assertNotEquals(desktopsSubMenuColor,afterHoveringDesktopsSubMenu,"Background color matched");
    }
}
