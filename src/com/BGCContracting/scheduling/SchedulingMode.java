package com.BGCContracting.scheduling;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BGCContracting.*;
import com.BGCContracting.base.Page;

public class SchedulingMode extends Page{	 

	LoginPage lp = new LoginPage();
	SchedulingModeSearch SMS = new SchedulingModeSearch();

	@BeforeTest
	public void LaunchApplication(){
		lp.OpenWebsite(); 	
	}	

	//Login as an existing User	 
	@Test(priority=1) 
	public void DefaultUserlogin(){  
		System.out.println("Login as an existing User:");   		      
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		lp.LogOut();         
	}

	//Verify Search Result are displayed
	@Test(priority=2)
	public void VerifyValidSearchResult(){	
		System.out.println("Verify Search Result are displayed");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		SMS.NavigateSchedulingMode();
		//SMS.VerifySchedulingPage();
		SMS.Search(CONFIG.getProperty("ValidSearchText"));
		SMS.VerifyValidSearch("SchedulingModeSearchResult1","SchedulingModeSearchResult2", CONFIG.getProperty("ValidSearchResult"));
		lp.LogOut();
	}

	//Verify Invalid Search Result
	@Test(priority=3)
	public void VerifyInvalidSearchResult() {	
		System.out.println("Verify Invalid Search Result");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		SMS.NavigateSchedulingMode();
		//SMS.VerifySchedulingPage();
		SMS.Search(CONFIG.getProperty("InvalidSearchText"));
		SMS.VerifyInValidSearch(CONFIG.getProperty("InvalidSearchError"));
		lp.LogOut();
	}

	//Add Valid Schedule
	@Test(priority=4)
	public void AddValidSchedule() throws InterruptedException{	
		System.out.println("Add Valid Schedule");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		SMS.NavigateSchedulingMode();
		//SMS.VerifySchedulingPage();
		SMS.Search(CONFIG.getProperty("ValidSearchText"));
		SMS.VerifyValidSearch("SchedulingModeSearchResult1","SchedulingModeSearchResult2", CONFIG.getProperty("ValidSearchResult"));
		SMS.SelectSchedule();
		SMS.AddSchedulingShift(CONFIG.getProperty("ValidShift"));
		SMS.ClickDropdownShift();
		SMS.AddSchedulingDay(CONFIG.getProperty("ValidShift"), CONFIG.getProperty("ValidDay"));
		SMS.SaveScheduling();
		SMS.Search(CONFIG.getProperty("ValidSearchText"));
		SMS.VerifyValidSearch("SchedulingModeSearchResult1", "SchedulingModeSearchResult2", CONFIG.getProperty("ValidSearchResult"));
		SMS.SelectSchedule();
		SMS.VerifyValidScheduling();
		Thread.sleep(2000);
		SMS.DeleteSchedule();
		Thread.sleep(2000);
		SMS.SaveScheduling();
		lp.LogOut();
	}

	//Add Invalid shift Schedule
	@Test(priority=5)
	public void AddScheduleInvalidShift() throws InterruptedException{	
		System.out.println("Add Invalid shift Schedule");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		SMS.NavigateSchedulingMode();
		//SMS.VerifySchedulingPage();
		SMS.Search(CONFIG.getProperty("ValidSearchText"));
		SMS.VerifyValidSearch("SchedulingModeSearchResult1","SchedulingModeSearchResult2", CONFIG.getProperty("ValidSearchResult"));
		SMS.SelectSchedule();
		SMS.AddSchedulingShift(CONFIG.getProperty("InvalidShift"));
		SMS.AddSchedulingDay(CONFIG.getProperty("InvalidShift"), CONFIG.getProperty("ValidDay"));
		SMS.SaveScheduling();
		SMS.verifyInvalidShiftScheduling();
		lp.LogOut();
	}

	//Add Invalid day Schedule
	@Test(priority=6)
	public void AddScheduleInvalidDay() throws InterruptedException{	
		System.out.println("Add Invalid day Schedule");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		SMS.NavigateSchedulingMode();
		//SMS.VerifySchedulingPage();
		SMS.Search(CONFIG.getProperty("ValidSearchText"));
		SMS.VerifyValidSearch("SchedulingModeSearchResult1", "SchedulingModeSearchResult2", CONFIG.getProperty("ValidSearchResult"));
		SMS.SelectSchedule();
		SMS.AddSchedulingShift(CONFIG.getProperty("ValidShift"));
		SMS.ClickDropdownShift();
		SMS.AddSchedulingDay(CONFIG.getProperty("ValidShift"), CONFIG.getProperty("InvalidDay"));
		SMS.SaveScheduling();
		SMS.VerifyInvalidDayScheduling();
		lp.LogOut();
	}

} 