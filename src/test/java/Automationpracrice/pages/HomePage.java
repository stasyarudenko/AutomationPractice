package Automationpracrice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Setting {

    //WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//img[contains(@class, 'logo img-responsive')]")
    WebElement logo;

    public String getPageTitle() {
        String homeTitle = driver.getTitle();
        return homeTitle;
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

}
