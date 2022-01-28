package StepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Setupclass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Facebook_existing_paid_login extends BaseClass {
	WebElement most_popular_Ppts;

	@Given("User is home pagei$")
	public void user_is_home_pagei() throws Throwable {
		BaseClass.ClearfacebookCache();
		driver.get(AppURL);
		log.info("It's opening the website URL");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BaseClass.ClearBrowserCache();
	}

	@Then("user clicks on the Popular PPTsi$")
	public void user_clicks_on_the_popular_pp_tsi() {

		most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();
	}

	@Then("User try to Download the ppti$")
	public void user_try_to_Download_the_ppti() throws InterruptedException {

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
			WebElement Sign_in_with_facebook = BaseClass
					.elementToBeClickable(By.xpath("//ul[@class='social_links']//i[@class='icon fa fa-facebook']"));
			Thread.sleep(1000);
			Sign_in_with_facebook.click();
			System.out.println("facebook button clicked");
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on Login pagei$")
	public void user_is_on_login_pagei() throws InterruptedException {
		log.info("Hi! I am on Home page");
		System.out.println("Hi! I am on Home page");
	}

	@Then("user Enters the username and passwordi$")
	public void user_Enters_the_username_and_passwordi() throws Throwable {

		driver.manage().window().maximize();
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(4000);

				WebElement fb_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
				fb_email.clear();
				fb_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);
				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));

				fb_pass.clear();
				fb_pass.sendKeys("himanshi@123");
				Thread.sleep(3000);
				try {
					if (!driver.findElements(By.xpath("//input[@value='Log In']")).isEmpty()) {
						driver.findElement(By.xpath("//input[@value='Log In']")).click();
					} else {
						WebElement fb_login = wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginbutton']")));

						fb_login.click();
						Thread.sleep(3000);
					}
				} catch (NoSuchElementException e) {

				}
				// to verify the continue button
				// button[normalize-space()='Yes, Continue']

			}
		}
		driver.switchTo().window(currentWindow);
	}

	@Then("user downloads the PPTi$")
	public void user_downloads_the_ppti() throws Throwable {
		Thread.sleep(4000);
		driver.get(
				"https://www.slidegeeks.com/business/product/emerging-marketplace-strategies-growth-ppt-powerpoint-presentation-complete-deck");
		WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
		js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
		download_Ppt.click();

		if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
			WebElement close_popup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

			close_popup.click();
		}
	}

	@Then("user clicks on the Logout pagei$")
	public void user_clicks_on_the_logout_pagei() throws InterruptedException {
		try {
			Thread.sleep(4000);
			WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}

	}


}