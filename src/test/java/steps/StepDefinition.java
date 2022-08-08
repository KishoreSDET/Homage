package steps;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.BaseClass;
import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass{
	
	public static WebDriverWait wait;
	
	/*@Given("User launches Chrome browser")
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@And("User loads the application with {string}")
	public void launchApp(String Url)
	{
		driver.get(Url);
	} */

	
	@And("user selects country as {string}")
	public void selectCountry(String country)
	{
		driver.findElement(By.xpath("//label[text()='Please select location']/parent::div/div")).click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Singapore - Singapore']")));
		driver.findElement(By.xpath("//li[text()='Singapore - Singapore']")).click();
	}
	
	
	@And("User enters first name as {string}")
	public void enterFirstName(String firstName)
	{
		driver.findElement(By.id("firstName")).sendKeys(firstName);
	}
	
	@And("User enters last name as {string}")
	public void enterLastName(String lastName)
	{
		driver.findElement(By.id("lastName")).sendKeys(lastName);
	}
	
	/*@Then("Fullname field in Declaration section should be auto-filled with first & last name")
	public void verifyFullNameInDeclaration()
	{
		String firstName="Test1";
		String lastName="User";
		String fullName= firstName+" "+lastName;
		if(driver.findElement(By.id("declarationName")).getText().trim().equals(fullName)) {
			
			System.out.println("Fullname is auto-populated correctly in Declaration section");
		}
		else
		{
			System.out.println("Fullname is not auto-populated correctly in Declaration section");
		}
	
	}*/
	
	@And("User enters email as {string}")
	public void enterEmail(String email)
	{
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	@And("User enters phone number as {string}")
	public void enterPhone(String phoneNumber)
	{
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	}
	
	
	@And("User enters date of birth as {string}")
	public void enterDateofbirth(String dob)
	{
		driver.findElement(By.id("dob")).clear();
		driver.findElement(By.id("dob")).sendKeys(dob);
	}
	
	
	@And("User enters nationality as {string}")
	public void selectNationality(String nationality)
	{
		wait = new WebDriverWait(driver,30);
		driver.findElement(By.id("nationality")).click();
		wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Singapore Citizen']"))));
		driver.findElement(By.xpath("//li[text()='"+nationality+"']")).click();
	}
	
	
	@When("User selects experience as {string}")
	public void forExperienced(String isExperienced)
	{
		driver.findElement(By.xpath("//span[text()='Do you have professional healthcare experience? ']/parent::span/div/button[text()='"+isExperienced+"']")).click();
	}
	
	
	@Then("years of experience and role sections should be displayed")
	public void isExperienceAndRolesVisible()
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='How many years of professional healthcare experience do you have?']/parent::div"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Which of these roles apply to you?']/parent::span/following-sibling::div"))));
		boolean experienceSection= driver.findElement(By.xpath("//span[text()='How many years of professional healthcare experience do you have?']/parent::div")).isDisplayed();
		boolean rolesSection=driver.findElement(By.xpath("//span[text()='Which of these roles apply to you?']/parent::span/following-sibling::div")).isDisplayed();
		
		if(experienceSection==true && rolesSection==true)
		{
			System.out.println("Both experience and roles section are expanded for experienced healthcare professional");
		}
		
		else
		{
			System.out.println("Experience and roles section are not expanded for experienced healthcare professional");
		}
		
	}
	
	
	@And("User selects years of experience as {string}")
	public void selectExperienceLevel(String expLevel)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/h3[text()='Less than 1']")));
		driver.findElement(By.xpath("//button/h3[text()='"+expLevel+"']")).click();
		
	}
	
	
	@And("User selects role as {string}")
	public void selectRole(String role)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/div/h3/span[text()='Doctor']")));
		driver.findElement(By.xpath("//button/div/h3/span[text()='"+role+"']")).click();
	}
	
	
	@And("User selects job Opportunities as {string}")
	public void selectJobOpportunities(String jobOpp)
	{
		driver.findElement(By.xpath("//div/b[text()='"+jobOpp+"']")).click();
		
	}
	
	
	@And("User selects engagement type as {string}")
	public void selectEngagementTypes(String engType)
	{
		driver.findElement(By.xpath("//div/b[text()='"+engType+"']")).click();
	}
	
	
	@And("User selects background check information as {string}")
	public void selectBackgroundCheck(String isConvicted)
	{
		driver.findElement(By.xpath("//span[@id='backgroundCheck']/following-sibling::div/button[text()='"+isConvicted+"']")).click();
	}
	
	
	@And("user enters referral code as {string}")
	public void enterReferralCode(String refCode)
	{
		driver.findElement(By.id("referral")).sendKeys(refCode);
	}
	
	
	@And("User selects source of information as {string}")
	public void selectSourceofInformation(String source)
	{
		wait = new WebDriverWait(driver,30);
		driver.findElement(By.id("source")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Job boards (LinkedIn, Indeed, etc)']")));
		driver.findElement(By.xpath("//li[text()='"+source+"']")).click();
	}
	
	
	@And("User checks the declaration")
	public void checksDeclaration()
	{
		driver.findElement(By.xpath("//span[text()='I understand that an electronic signature has the same legal effect and can be enforced in the same way as a written signature.']/parent::div/i")).click();
	}
	
	
	@When("User clicks on submit button")
	public void clickSubmitApplication()
	{
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit Application']")));
		driver.findElement(By.xpath("//button[text()='Submit Application']")).click();
	}
	
	
	
	
	@Then("User sees the success message")
	public void VerifyApplicationSubmissionSuccessMessage()
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Your application has been submitted!']"))));
		boolean successMessage=driver.findElement(By.xpath("//h1[text()='Your application has been submitted!']")).isDisplayed();
		
		Assert.assertTrue(successMessage);
		
		/*if(successMessage)
			System.out.println("Application submitted successfully");
		else
			System.out.println("Application not submitted successfully");*/
	}
	
	
	
	@But("Error message should be displayed")
	public void verifyErrorMessage()
	{
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='client-snackbar'][text()='An account with the same email address already exists. Please contact support at apply@homage.co to continue your application.']")));
		boolean errorMsg=driver.findElement(By.xpath("//span[@id='client-snackbar'][text()='An account with the same email address already exists. Please contact support at apply@homage.co to continue your application.']")).isDisplayed();
		
		Assert.assertTrue(errorMsg);
		/*if(errorMsg)
		
			System.out.println("Application is not successful due to the duplication error");
		else
			System.out.println("Application is successful");*/
		
	}
	
	
	
}
