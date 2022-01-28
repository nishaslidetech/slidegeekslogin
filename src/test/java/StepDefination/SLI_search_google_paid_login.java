package StepDefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class SLI_search_google_paid_login extends BaseClass {
	@Given("User is home page_viii$")
	public void user_is_home_page_viii() throws Throwable {

		BaseClass.ClearGoggleCache();
		driver.get(AppURL);
		log.info("It's opening the website URL");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BaseClass.ClearBrowserCache();
	}

	@Then("Enter keyword in search field_viii$")
	public void enter_keyword_in_search_field_viii() throws Throwable {
		WebElement search_field = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
		search_field.sendKeys("HR");
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);
			Thread.sleep(1000);
			boolean pop_up_Value = driver.findElement(By.xpath("//ul[@id='sli_autocomplete']")).isDisplayed();
			System.out.println("pop-up is displayed  " + pop_up_Value);

			// assertTrue(pop_up_Value == false);
		} catch (AWTException e) {
		}

	}

	@Then("user will clicks on the sign in with Google button_viii$")
	public void user_will_clicks_on_the_sign_in_with_google_button_viii() {
		// Click on Sign in with Google Account
		WebElement Sign_in_with_google = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fa fa-google']")));
		js.executeScript("arguments[0].click();", Sign_in_with_google);
		// Sign_in_with_google.click();
	}

	@Then("user enters the username and password_viii$")
	public void user_enters_the_username_and_password_viii() throws Throwable {

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

				g_email.sendKeys("nisha.dhiman@slidetech.in");
				Thread.sleep(3000);

				WebElement g_login_btn1 = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector("#identifierNext > div > button > span")));
				;
				g_login_btn1.click();

				Thread.sleep(3000);

				WebElement g_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")));

				g_pass.sendKeys("Nisha@123");

				Thread.sleep(3000);
				WebElement g_login_btn2 = wait.until(
						ExpectedConditions.elementToBeClickable(By.cssSelector("#passwordNext > div > button > span")));

				g_login_btn2.click();

				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(5000);
	}

	@Then("user verify the page_viii$")
	public void user_verify_the_page_viii() {

		/*
		 * // Verify the subscription page String subscriptionText =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//h3[@class='base']"))) .getText(); System.out.println("subscriptionText = "
		 * + subscriptionText);
		 * 
		 * //Assert.
		 * assertTrue("user is not on the subscription page after login with facebbok paid credentials"
		 * ,subscriptionText.contains(TextMessage));
		 */ }

	@Then("enter Keyword in search field_viii$")
	public void enter_Keyword_in_search_field_viii() throws Throwable {
		Thread.sleep(4000);
		WebElement search_field = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
		search_field.sendKeys("Management");
		Thread.sleep(1000);
		//search_field.sendKeys("gement");
		Thread.sleep(3000);
	}

	@Then("user selects and download the PPT_viii$")
	public void user_selects_and_download_the_ppt_viii() throws Throwable {
		try {
			WebElement select_ppt = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='productList']//div[1]//a[1]//div[1]//img[1]")));
			select_ppt.click();
			Thread.sleep(3000);

			WebElement download_Ppt = BaseClass.elementToBeClickable(By.linkText("Download this Presentation"));
			js.executeScript("arguments[0].scrollIntoView();", download_Ppt);
			js.executeScript("arguments[0].click();", download_Ppt);

		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on the Logout page_viii$")
	public void user_clicks_on_the_logout_page_viii() throws Throwable {
		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}

	}

}
