package Automationpracrice;

import Automationpracrice.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Stepdefs {

    public static final String XPATH_WOMEN_CATALOG = "//a[(@title = 'Women')]";
    HomePage homePage = new HomePage();
    private WebDriver chromeDriver;
    private final String GOOGLE_HOME = "https:\\www.google.com";
    private final String HOME_URL = "http://automationpractice.com/index.php";
    private final String TITLE_ERROR_MESSAGE = "The title is not ";
    private final String LOGO_ERROR_MESSAGE = "The logo is not displayed";
    private final String CSS_DRESSES_SUBCATEGORY = "div.subcategory-image>a.img[title=Dresses]";
    private final String CSS_CASUAL_DRESSES_SUBCATEGORY = "h5>a.subcategory-name[href=\"http://automationpractice.com/index.php?id_category=11&controller=category\"]";
    private Actions actions;

    @Before
    public void setUp() {
        chromeDriver  = new ChromeDriver();
        actions = new Actions(chromeDriver);
        chromeDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //chromeDriver.quit();
    }

    @Given("^I open google home page$")
    public void i_open_google_home_page() {
        chromeDriver.get(GOOGLE_HOME);
    }

    @When("^I open automationpractice\\.com page$")
    public void i_open_automationpractice_com_page() {
        chromeDriver.get(HOME_URL);
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void the_page_title_should_be(String expectedTitle) {
        assertThat(TITLE_ERROR_MESSAGE + expectedTitle, homePage.getPageTitle(), is(expectedTitle));
    }

    @Then("^the logo should be displayed$")
    public void the_logo_should_be_displayed() {
        assertThat(LOGO_ERROR_MESSAGE, homePage.isLogoDisplayed(), is(true));
    }

    ///////////////////////////////////////////////////////////////////////////////////
    @Given("^I am at the home page$")
    public void i_am_at_the_home_page() {
        i_open_automationpractice_com_page();
    }

    @When("^I go to the Women catalog page$")
    public void i_go_to_the_Women_catalog_page() {
        chromeDriver.findElement(By.xpath(XPATH_WOMEN_CATALOG)).click();
    }

    @When("^I click on Dresses subcategory$")
    public void i_click_on_Dresses_subcategory() {
//        chromeDriver.findElement(By.xpath("//li[2]/h5/a[@class='subcategory-name']")).click();
        chromeDriver.findElement(By.cssSelector(CSS_DRESSES_SUBCATEGORY)).click();
    }

    @When("^I choose Summer Dresses subcategory$")
    public void i_choose_Casual_Dresses_subcategory() {
//        chromeDriver.findElement(By.xpath("//li[3]/div/a[@title='Summer Dresses']")).click();
        chromeDriver.findElement(By.cssSelector(CSS_CASUAL_DRESSES_SUBCATEGORY)).click();
    }

    @When("^move mouse on product$")
    public void move_mouse_on_product() {
//        WebElement image = chromeDriver.findElement(By.xpath("//li[2]//img[@class='replace-2x img-responsive']"));
//        actions.moveToElement(image).perform();
        chromeDriver.findElement(By.xpath("//li[2]/descendant::div[@class='product-image-container']")).click(); // если открывать попап

    }

    @When("^add product to the cart$")
    public void add_product_to_the_cart() {
//        chromeDriver.findElement(By.xpath("//div[@class='box-cart-bottom']//span")).click();
        WebElement iFrame = chromeDriver.findElement(By.cssSelector("iframe.fancybox-iframe"));
        chromeDriver.switchTo().frame(iFrame);
        chromeDriver.findElement(By.cssSelector("button.exclusive[type=submit]")).click();      //   ??? не работает, если кликать с попапа
    }

    @When("^open the cart$")
    public void open_the_cart() {

    }

    @Then("^the product displays in the cart$")
    public void the_product_displays_in_the_cart() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}