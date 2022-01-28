package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Setupclass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Normal_paid_login extends BaseClass {

	@Given("User is home page_vi$")
	public void user_is_home_page_vi() throws InterruptedException {

		driver.get(AppURL);
		log.info("It's opening the website URL");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("user click on the Popular PPTs_vi$")
	public void user_click_on_the_popular_PPts_vi() {
		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
	}

	@Then("User try to download the ppt_vi$")
	public void user_try_to_download_the_ppt_vi() throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebElement select_Ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='box-top']//img[@title='Emerging Marketplace Strategies Growth Ppt PowerPoint Presentation Complete Deck']")));
			js.executeScript("arguments[0].scrollIntoView();", select_Ppt);
			select_Ppt.click();

			WebElement download_Ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			System.out.println("user is on Login page");
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login page_vi$")
	public void user_is_on_login_page_vi() {
		log.info("Hi! I am on Home page");
	}

	@Then("user enters the username and password_vi$")
	public void user_enters_the_username_and_password_vi() throws Throwable {
		try {
			WebElement email = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
			email.sendKeys("sumit.kumar@slidetech.in");

			WebElement password_field = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			password_field.sendKeys("redhat2090");
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on Login button_vi$")
	public void user_clicks_on_login_button_vi() throws Throwable {
		try {
			WebElement login_btn = BaseClass.elementToBeClickable(By.xpath("//input[@name='Submit']"));
			// js.executeScript("arguments[0].click();", login_btn );
			login_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user downloads the PPT_vi$")
	public void user_downloads_the_ppt_vi() throws Throwable {
		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
		try {
			Thread.sleep(2000);
			WebElement select_Ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='box-top']//img[@title='Emerging Marketplace Strategies Growth Ppt PowerPoint Presentation Complete Deck']")));
			js.executeScript("arguments[0].scrollIntoView();", select_Ppt);
			select_Ppt.click();

			WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			System.out.println("user is on Login page");
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
		if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
			WebElement close_popup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

			close_popup.click();
		}

	}

	@Then("user clicks on the Logout page_vi$")
	public void user_clicks_on_the_logout_page() throws InterruptedException {
		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}
	}

}
