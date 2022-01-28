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

public class Facebook_free_login extends BaseClass {

	@Given("User is home page_ii")
	public void user_is_home_page_ii() throws Throwable {
		BaseClass.ClearfacebookCache();

		driver.get(AppURL);
		log.info("It's opening the website URL");
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BaseClass.ClearBrowserCache();
	}

	@Then("user click on the Free PPts under free stuff_ii")
	public void user_click_on_the_free_ppts_under_free_stuff_ii() {
		try {
			WebElement free_Slides = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FREE SLIDES")));
			free_Slides.click();

		} catch (NoSuchElementException e) {

		}

	}

	@Then("User try to download the free ppts_ii")
	public void user_try_to_download_the_free_ppts_ii() throws Throwable {

		try {
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[normalize-space()='Download Free Skills Free PowerPoint Slide']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();

			WebElement download_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
			js.executeScript("arguments[0].scrollIntoView();", download_ppt);
			download_ppt.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user is on home page page and click on facebbook button_ii")
	public void user_is_on_home_page_page_and_click_on_facebbook_button_ii() throws InterruptedException {
		// Thread.sleep(3000);
		try {
			WebElement Sign_in_with_facebook = BaseClass
					.elementToBeClickable(By.xpath("//ul[@class='social_links']//i[@class='icon fa fa-facebook']"));
			Thread.sleep(1000);
			Sign_in_with_facebook.click();
			System.out.println("facebook button clicked");
		} catch (InterruptedException e) {
		}
	}

	@Then("user enters the free username and password_ii")
	public void user_enters_the_free_username_and_password_ii() throws Throwable {
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
				fb_email.sendKeys("ritapahwa08@gmail.com");
				Thread.sleep(3000);
				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));

				fb_pass.clear();
				fb_pass.sendKeys("Qwerty@1");
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
		Thread.sleep(3000);
	}

	@Then("user downloads the free PPT_ii")
	public void user_downloads_the_free_ppt_ii() throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebElement free_Slides = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FREE SLIDES")));
			free_Slides.click();

			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[normalize-space()='Download Free Skills Free PowerPoint Slide']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();

			WebElement download_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Download this Presentation")));
			js.executeScript("arguments[0].scrollIntoView();", download_ppt);
			download_ppt.click();
			Thread.sleep(3000);
			// if any pop-up visible
			if (!driver.findElements(By.xpath("//a[@class='mfp-close roundlink']")).isEmpty()) {
				WebElement close_popup = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mfp-close roundlink']")));

				close_popup.click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("user clicks on the logout page_ii")
	public void user_clicks_on_the_logout_page_ii() throws Throwable {
		try {
			Thread.sleep(4000);
			WebElement logout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
			js.executeScript("arguments[0].click();", logout);
		} catch (NoSuchElementException e) {

		}
	}

}
