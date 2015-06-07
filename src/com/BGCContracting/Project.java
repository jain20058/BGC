package com.BGCContracting;

import org.testng.Assert;

import com.BGCContracting.base.Page;

public class Project extends Page{
	
	public void NavigateProject(){
		ClickXpath("Admin");
		ClickXpath("Projects");
		ClickXpath("FirstProject");
	}
	
	public void VerifyProjectPage(){
		if(IsElementPresentXpath("ProjectName")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	

	public void AddSubProject(String ProjectName) {
		ClickXpath("AddSubProject");
		InputXpath(OR.getProperty("ThirdSubProjectName"), ProjectName);
	}
	
	
	public void SaveSubProject(){
		ClickXpath("SaveSubProjectButton");
	}
	
	public void VerifyValidSubProject(){
		if(IsElementPresentXpath("ThirdSubProjectName")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}		
	}
	
	public void VerifyInValidSubProject(){
		if(IsTextPresent(CONFIG.getProperty("InvalidProjectNameError"))){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
		
	public void DeleteSubProject(){
		ClickXpath("DeleteSubProject");
	}
	
	public void AddCrew(){
		ClickXpath("AddCrewFirst");
	}
	
	public void EditCrewName(String NewCrewName){
		ClearFieldXpath(OR.getProperty("CrewName"));
		InputXpath(OR.getProperty("CrewName"), NewCrewName);
	}
	
	public void SaveCrew(){
		ClickXpath("SaveCrew");
	}
	
	public void VerifyCrew(){
		if(IsElementPresentXpath("VerifyCrew")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void DeleteCrew(){
		ClickXpath("VerifyCrew");
		ClickXpath("DeleteCrew");
	}
	
	public void VerifyInvalidCrewName(){
		if(IsTextPresent(CONFIG.getProperty("InvalidCrewError"))){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void CancelAddCrew(){
		ClickXpath("CancelCrew");
	}

}
