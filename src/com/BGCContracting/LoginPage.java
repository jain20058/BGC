package com.BGCContracting;


import org.testng.Assert;

import com.BGCContracting.base.Page;

public class LoginPage extends Page {

	//passing the website url in the browser
	public void OpenWebsite(){	  
		driver.get(CONFIG.getProperty("Website_URL")); 		
	}	

	//Basic Login Function
	public void DoLogin(String userName,String password){
		//ClearField(OR.getProperty("USERNAME"));
		//ClearField(OR.getProperty("PASSWORD"));
		Input(OR.getProperty("USERNAME"),userName);
		InputXpath(OR.getProperty("PASSWORD"),password);
		ClickXpath("LOGIN_BUTTON");	   
	} 	

	//Verifying Successful Login
	public void SuccessfulLogin(){
		if(IsTextPresent(CONFIG.getProperty("Welcome_Text"))){
			Assert.assertTrue(true);			
		}
		else{			
			Assert.fail();				
		}
	}
	
	//LogOut
	public void LogOut(){
		ClickXpath("LogOut");
	}

	//Close Browser
	public void CloseBrowser(){
		driver.quit();
	}

}
