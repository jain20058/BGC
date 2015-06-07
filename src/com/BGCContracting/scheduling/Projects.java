package com.BGCContracting.scheduling;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BGCContracting.*;


public class Projects extends SchedulingMode{

	LoginPage lp = new LoginPage();
	Project po = new Project();

	@BeforeTest
	public void LaunchBrowser(){
		lp.OpenWebsite();
	}

	//Add A new Sub Project
	@Test(priority=7)
	public void AddValidSubProject() throws InterruptedException{
		System.out.println("Add A new Sub Project");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		po.NavigateProject();
		po.VerifyProjectPage();
		po.AddSubProject(CONFIG.getProperty("SubProjectName"));
		po.SaveSubProject();
		po.NavigateProject();
		po.VerifyValidSubProject();
		po.DeleteSubProject();
		Thread.sleep(2000);
		po.SaveSubProject();
		lp.LogOut();
	}
	
	//Add Invalid Sub Project
	@Test(priority=8)
	public void AddInValidSubProject(){
		System.out.println("Add Invalid Sub Project");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		po.NavigateProject();
		po.VerifyProjectPage();
		po.AddSubProject(CONFIG.getProperty("InvalidSubProjectName"));
		po.SaveSubProject();
		po.VerifyInValidSubProject();
		lp.LogOut();
	}
	
	
	//Add Valid Crew
	@Test(priority=9)
	public void AddValidCrew(){
		System.out.println("Add Valid Crew");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		po.NavigateProject();
		po.VerifyProjectPage();
		po.AddCrew();
		po.EditCrewName(CONFIG.getProperty("NewCewName"));
		po.SaveCrew();
		po.NavigateProject();
		po.VerifyCrew();
		po.DeleteCrew();
		po.SaveSubProject();
		lp.LogOut();
	}
	
	//Add Invalid Crew
	@Test(priority=10)
	public void AddInvalidCrew() throws InterruptedException{
		System.out.println("Add Invalid Crew");
		lp.DoLogin(CONFIG.getProperty("Default_Username"), CONFIG.getProperty("Default_Password"));
		lp.SuccessfulLogin();
		po.NavigateProject();
		po.VerifyProjectPage();
		po.AddCrew();
		po.EditCrewName(CONFIG.getProperty("Null"));
		Thread.sleep(5000);
		po.SaveCrew();
		po.VerifyInvalidCrewName();
		po.CancelAddCrew();
		Thread.sleep(5000);
		lp.LogOut();
		lp.CloseBrowser();
	}
}
