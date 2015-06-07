package com.BGCContracting;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.BGCContracting.base.Page;

public class SchedulingModeSearch extends Page{
	
	public void NavigateSchedulingMode(){
		ClickXpath("Admin");
		ClickXpath("SchedulingMode");	
	}
	
	public void VerifySchedulingPage(){
		if(IsElementPresentXpath("DescriptionSearchTextXpath")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		if(IsElementPresentId("DescriptionSearchButtonId")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void Search(String SearchText){
		ClearFieldXpath(OR.getProperty("DescriptionSearchTextXpath"));
		InputXpath(OR.getProperty("DescriptionSearchTextXpath"), SearchText);
		ClickID("DescriptionSearchButtonId");
	}
	
	public void VerifyValidSearch(String SearchXpath1, String SearchXpath2, String SearchText){
		if(IsElementPresentXpath(SearchXpath1)==true){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		if(IsElementPresentXpath(SearchXpath2)==true){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		if(IsTextPresent(SearchText)){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void VerifyInValidSearch(String SearchText){
		if(IsTextPresent(SearchText)){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		
	}
	
	public void SelectSchedule(){
		ClickXpath("SchedulingModeSearchResult1");
	}
	
	public void ClickDropdownShift(){
		driver.findElement(By.xpath("html/body/ul[4]/li/a")).click();
	}
	
	public void AddSchedulingShift(String Shift) throws InterruptedException{
		ClickXpath("AddShift");
		String ShiftId=ReturnNameXpath(OR.getProperty("ShiftForth"));
		//String ShiftCSS ="input[name^="+ShiftName+"]";
		Input(ShiftId, Shift);
	}
	
	public void AddSchedulingDay(String Shift, String Day) throws InterruptedException{
		String ShiftId=ReturnNameXpath(OR.getProperty("ShiftForth"));
		//String ShiftCSS ="input[name^="+ShiftName+"]";
		//Input(ShiftId, Shift);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("html/body/ul[4]/li/a")).click();
		//driver.findElement(By.id(ShiftId)).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.id(ShiftId)).sendKeys(Keys.ENTER);
		//Thread.sleep(10000);
		String Name=ShiftId.substring(17,ShiftId.length()-5);
		String DayName=Name+"NoOfDays";
		String DaysCSS = "input[name^="+DayName+"]";
		InputCss(DaysCSS, Day);
	}
	
	public void SaveScheduling(){
		ClickXpath("SaveButton");
	}
	
	public void VerifyValidScheduling(){
		if(IsElementPresentXpath("ShiftForth")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	
		if(IsElementPresentXpath("ShiftDaysForth")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void verifyInvalidShiftScheduling(){
		if(IsTextPresent(CONFIG.getProperty("ShiftError"))){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void VerifyInvalidDayScheduling(){
		if(IsTextPresent(CONFIG.getProperty("DayError"))){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void DeleteSchedule(){
		ClickXpath("DeleteForthShift");
	}

	

}
