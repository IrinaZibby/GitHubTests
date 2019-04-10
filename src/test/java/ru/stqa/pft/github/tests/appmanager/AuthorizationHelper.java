package ru.stqa.pft.github.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.github.tests.tests.TestBase;

import java.util.concurrent.TimeUnit;


public class AuthorizationHelper extends TestBase {

  WebDriver driver;

  AuthorizationHelper(WebDriver driver) {
    this.driver = driver;
  }

  boolean click(By locator) {
    driver.findElement(locator).click();
    return true;
  }

  void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void login(String username, String password) throws InterruptedException {
    type(By.id("login_field"), username);
    type(By.id("password"), password);
    click(By.xpath("//input[@value='Sign in']"));
  }


  public void goToProfile() {
    click(By.xpath("//span[@title='IrinaZibby']"));
    click(By.xpath("//a[@class='url fn']"));
  }

  public void createRep(String repositoryName) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 3);
    click(By.xpath("//a[contains(text(),'Repositories')]"));
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    click(By.xpath("//a[@class='btn btn-primary ml-3']"));
    type(By.cssSelector("#repository_name"), repositoryName);
    TimeUnit.MILLISECONDS.sleep(800);
    click(By.xpath("//button[contains(text(),'Create repository')]"));
    WebElement element1 = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-pjax='#js-repo-pjax-container']")));



  }

  public void deleteRep(String repositaryName) {
    click(By.xpath("//a[contains(text(),'Repositories')]"));
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    click(By.xpath("//a[contains(text(),'testRepo')]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quick setup'])[1]/preceding::a[1]"));
    click(By.xpath("//summary[contains(text(),'Delete this repository')]"));
    type(By.xpath("//form[@action='/IrinaZibby/testRepo/settings/delete']//input[@name='verify']"), repositaryName);
    click(By.xpath("//button[contains(text(),'I understand the consequences, delete this reposit')]"));
  }

  public void returnToRepoPage() {
    click(By.xpath("//a[@class='url fn']"));
    click(By.xpath("//a[contains(text(),'Repositories')]"));

  }

  public int getRepoCount() {
    return driver.findElements(By.xpath("//div[@class='col-9 d-inline-block']")).size();
  }

  public void repoPage() {
    click(By.xpath("//a[contains(text(),'Repositories')]"));
  }
}
