package com.heroGeneralPHQForms.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hero.config.ActionDriver;
import com.hero.config.StartBrowser;
import com.hero.pageObjects.RegistorPage;
import com.hero.utilities.getUtil;

public class TC_RegWonttCoverage_007 extends StartBrowser{

	@Test
	public void verifyRegWithDoNotWantCoverage() throws Exception
	{
       /* launch Chrome and direct it to the Base URL */
        StartBrowser.test = StartBrowser.test.createNode(" Personal Health Questionnaire(PHQ) Registration  ");
        ActionDriver aDriver = new ActionDriver();
        aDriver.navigateToApplicationGeneralPHQ();
        RegistorPage reg = new RegistorPage(driver); 
        
		//Test Steps:-
		reg.clickOnRegistorLink("Registor", 10);
		reg.clickOnStartReg("Start", 15);
		
		/* Go to PHQ_Registration Step1 - Identification */
		StartBrowser.test = StartBrowser.test
				.createNode(" Go to Personal Health Questionnaire Registration Step1 Identification ");

		//Test Steps:-
		reg.setFirstName("Hero", 10, "First Name");
		reg.setLastName("Index", 5, "Last Name");
		reg.setSuffix("Sr", 5, "Suffix Name");
		reg.setMobNumber("(991)176-2626", 5, "Mobile No");
		reg.setDateHire("07/07/2000", 6, "Gate Hire");
		reg.clickOnHethInsNo("No", 5);       //health insurance plan --> No
		reg.selWonttCovrg("Do not want coverage", 10);
		reg.clickOnNext(" Next ", 10);
		Thread.sleep(10000);
		reg.setWaivingDOB("07/07/1990", 5, "D.O.B");
		
		/* Go to PHQ_Registration Step5 -5. Signature and Submission   */
		StartBrowser.test = StartBrowser.test
				.createNode(" Go to PHQ_Registration Step5 - Signature and Submission  ");
		
		reg.clickOnElecSign("Electronics Signature", 20);
		reg.clickOnSubmitbtn("Submit", 20);
		
		
		/*Result*/
		System.out.println("Brajes.............");
		String expectedOutput = "Your Submission has been received";
          Thread.sleep(15000);
		String actualOutput = reg.verifyRegSubmis("verifySubmsText", 5);
				
		if (actualOutput.contentEquals(expectedOutput)) // Expected & actual Verify
		{
			Assert.assertTrue(true);
		} else {
			getUtil.TakeScreenOnTestFail(" testFailSnapCapture ");
			Assert.assertTrue(false);
		}
	}}