package ru.stqa.pft.github.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GithubProfileTests extends TestBase {

  @BeforeMethod
  public void login() throws InterruptedException {
    app.getAuthorizationHelper().login("IrinaZibby", "8WE2V2m2");
    app.getAuthorizationHelper().goToProfile();
  }


  @Test
  public void testRepoCreation() throws InterruptedException {//создание репозитория
    app.getAuthorizationHelper().repoPage();
    TimeUnit.MILLISECONDS.sleep(500);
    int before = app.getAuthorizationHelper().getRepoCount();
    app.getAuthorizationHelper().createRep("testRepo");
    app.getAuthorizationHelper().returnToRepoPage();
    int after = app.getAuthorizationHelper().getRepoCount();
    Assert.assertEquals(after, before + 1);//проверка, что репозиторий создан
  }

  @Test
  public void testRepoDeletion() throws InterruptedException {//удаление репозитория
    app.getAuthorizationHelper().repoPage();
    TimeUnit.MILLISECONDS.sleep(500);
    int before = app.getAuthorizationHelper().getRepoCount();
    app.getAuthorizationHelper().deleteRep("IrinaZibby/testRepo");
    app.getAuthorizationHelper().goToProfile();
    app.getAuthorizationHelper().repoPage();
    int after = app.getAuthorizationHelper().getRepoCount();
    Assert.assertEquals(after, before - 1);//репозиторий удален


  }
}


