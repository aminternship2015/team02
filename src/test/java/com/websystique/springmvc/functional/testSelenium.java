package com.websystique.springmvc.functional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testSelenium {

	private WebDriver driver;
	private String baseUrlLogin;
	private String baseUrlRegistration;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrlLogin = "http://localhost:9080/SpringHibernateExample/login";
		baseUrlRegistration = "http://localhost:9080/SpringHibernateExample/new";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void SingIn() {
		driver.get(baseUrlLogin);
		WebElement username4Login = driver.findElement(By.id("username"));
		username4Login.sendKeys("bunny");
		WebElement pass4Login = driver.findElement(By.id("password"));
		pass4Login.sendKeys("bunny");
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();
	}

	@Test
	public void SignUp_Failed() {
		driver.get(baseUrlRegistration);
		driver.findElement(By.linkText("SIGN UP")).click();
		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement avatar = driver.findElement(By.id("avatar"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement submit = driver.findElement(By.id("register"));
		name.clear();
		name.sendKeys("useryy");
		username.clear();
		username.sendKeys("useryy");
		password.clear();
		password.sendKeys("useryy");
		email.clear();
		email.sendKeys("ttt");
		avatar.clear();
		avatar.sendKeys("C:\\Users\\mcolomina\\Desktop\\trash\\slash-dessin1.jpg");
		submit.click();
		assertEquals(driver.getTitle(), "Sign Up | Twitter");

	}

	@Test
	public void testRegistrationSuccesfully() throws Exception {
		// Generate random email
		Random r = new Random();
		int randomNumber = r.nextInt(99999 + 1);
		String generatedUserEmail = "test" + randomNumber + "@mail.com";

		driver.get(baseUrlRegistration);

		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement avatar = driver.findElement(By.id("avatar"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement submit = driver.findElement(By.id("register"));

		name.clear();
		name.sendKeys("useryyy");
		username.clear();
		username.sendKeys("useryyy");
		password.clear();
		password.sendKeys("useryyy");
		email.clear();
		email.sendKeys(generatedUserEmail);
		avatar.clear();
		avatar.sendKeys("C:\\Users\\mcolomina\\Desktop\\trash\\slash-dessin1.jpg");
		submit.click();
		assertEquals(driver.getTitle(), "Sign Up | Twitter");
	}

	@Test
	public void testPostTweet() {
		String testTweet = "TEST_TWEET";
		String actualTweet = "";
		SingIn();
		WebElement textArea = driver.findElement(By.id("postText"));
		textArea.click();
		textArea.sendKeys(testTweet);
		WebElement submitButton = driver.findElement(By.id("submitButtonTweet"));
		submitButton.click();
		List<WebElement> allPostedTweets = new ArrayList<WebElement>();
		allPostedTweets = driver.findElements(By.tagName("p"));
		for (WebElement el : allPostedTweets) {
			if (el.getText().equals(testTweet))
				actualTweet = el.getText();
		}
		assertEquals(testTweet, actualTweet);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
