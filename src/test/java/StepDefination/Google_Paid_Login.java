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

public class Google_Paid_Login extends BaseClass {
	@Given("^User is on Home pagev$")
	public void user_is_on_Home_pagev() throws Throwable {
		BaseClass.ClearGoggleCache();
		driver.get(AppURL);
		try {
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			BaseClass.ClearBrowserCache();
			// Click on Sign in with Google Account
			WebElement Sign_in_with_google = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fa fa-google']")));
			Sign_in_with_google.click();

			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
			System.out.println("message = " + e.getMessage());
		}
	}

	@Given("user enters the Username and Passwordv$")
	public void user_enters_the_username_and_passwordv() throws InterruptedException {

		driver.manage().window().maximize();

		// Store the CurrentWindow for future reference
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		// Switch To Popup Window

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(5000);

				if (!driver.findElements(By.xpath("//div[@class='BHzsHc']")).isEmpty()) {
					WebElement another_btn = BaseClass
							.elementToBeClickable(By.xpath("//div[text()='Use another account']"));
					another_btn.click();
				}

				WebElement g_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")));
				Thread.sleep(3000);
				g_email.sendKeys("nisha.dhiman@slidetech.in");
				Thread.sleep(3000);

				WebElement g_login_btn1 = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector("#identifierNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn1.click();

				Thread.sleep(3000);

				WebElement g_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")));
				Thread.sleep(3000);
				g_pass.sendKeys("Nisha@123");

				Thread.sleep(3000);
				WebElement g_login_btn2 = wait.until(
						ExpectedConditions.elementToBeClickable(By.cssSelector("#passwordNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn2.click();

				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(4000);
	}

	@Then("user clicks on Login button and verify the pagev$")
	public void user_clicks_on_login_button_and_verify_the_pagev() throws InterruptedException {

		/*
		 * // Verify the subscription page String subscriptionText =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//h3[@class='base']"))) .getText(); System.out.println("subscriptionText = "
		 * + subscriptionText);
		 */
	}

	@Then("user downloads the PPTv$")
	public void user_downloads_the_pptv() throws InterruptedException {
		Thread.sleep(4000);
		WebElement most_popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MOST POPULAR")));
		most_popular_Ppts.click();

		try {
			WebElement select_Ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Strategy Evolution Template Ppt PowerPoint Presentation Introduction']")));
			js.executeScript("arguments[0].scrollIntoView();", select_Ppt);
			select_Ppt.click();

			WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			download_Ppt.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on the Logout pagev$")
	public void user_clicks_on_the_logout_pagev() throws InterruptedException {
		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}
	}
}