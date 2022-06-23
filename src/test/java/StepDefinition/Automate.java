package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Automate {
	
	String search_text;
	String a;
	
	LogInSteps logIn = new LogInSteps();
	
	@And("Again read data from excel")
	public void Again_read_data_from_excel() throws Exception {
	File src= new File("C:\\Users\\Shubham\\Downloads\\automation.xlsx");
	FileInputStream fis=new FileInputStream(src);


	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet1= wb.getSheetAt(0);
	search_text = sheet1.getRow(1).getCell(3).getStringCellValue();
	a = sheet1.getRow(1).getCell(4).getStringCellValue();
	
	Thread.sleep(2000);
	
	
	wb.close();
	
	}
	
	@And("fetch the user details")
	public void fetch_the_user_details() throws InterruptedException {
		Thread.sleep(5000);
		String userName = LogInSteps.driver.findElement(By.xpath("//*[@id=\"user-name\"]")).getText();
		System.out.println("User logged in : "+userName);
		System.out.println(" ");

	}
	@And("Search ESA Timesheet")
	public void Search_ESA_Timesheet() throws InterruptedException {
		Thread.sleep(3000);
		LogInSteps.driver.findElement(By.xpath("//*[@id=\"searchbox\"]")).sendKeys(search_text);
		Thread.sleep(3000);
		LogInSteps.driver.findElement(By.xpath("//*[@id=\"search-button\"]/span[2]")).click();
		Thread.sleep(10000);
		LogInSteps.driver.findElement(By.xpath("//span[contains(text(),'Timesheet')]/preceding-sibling::span[contains(text(),'ESA')]")).click();
		Thread.sleep(10000);
		
		String currentWindow =  LogInSteps.driver.getWindowHandle();
		Set<String> allWindows = LogInSteps.driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while(i.hasNext())
		{
			String childWindow  = i.next();
			if(!childWindow.equalsIgnoreCase(currentWindow))
			{
				LogInSteps.driver.switchTo().window(childWindow);
			}
		}
		Thread.sleep(5000);

	}
	@And("get the weeks details")
	public void get_the_weeks_details() {
		
		String week1 = LogInSteps.driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText();
		System.out.println(" ");
		String week2 = LogInSteps.driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$1']")).getText();
		System.out.println(" ");
		 
		System.out.println("Week first :" +week1);
		System.out.println("Week second :" +week2);
	}
	@And("Fill the details in timesheet")
	public void Fill_the_details_in_timesheet() throws InterruptedException {
		Thread.sleep(5000);
		LogInSteps.driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).click();
		Thread.sleep(10000);
		//driver.switchTo().frame(16);
		LogInSteps.driver.switchTo().frame("TargetContent");
		Thread.sleep(5000);
		LogInSteps.driver.findElement(By.id("TIME1$0")).sendKeys(a);
		Thread.sleep(5000);
		/*driver.findElement(By.id("TIME3$0")).sendKeys(prop.getProperty("WorkHours"));
		Thread.sleep(5000);
		driver.findElement(By.id("TIME4$0")).sendKeys(prop.getProperty("WorkHours"));
		Thread.sleep(5000);
		driver.findElement(By.id("TIME5$0")).sendKeys(prop.getProperty("WorkHours"));
		Thread.sleep(5000);
		driver.findElement(By.id("TIME6$0")).sendKeys(prop.getProperty("WorkHours"));
		Thread.sleep(5000);
		driver.findElement(By.id("TIME7$0")).sendKeys(prop.getProperty("WorkHours"));
		Thread.sleep(5000);
		driver.findElement(By.id("PB_UPDATE_2")).click();
		Thread.sleep(5000);*/
		
		LogInSteps.driver.navigate().back();
		Thread.sleep(5000);
		LogInSteps.driver.switchTo().defaultContent();

	}
	@Then("get the rest details")
	public void get_the_rest_details() throws InterruptedException {
		
		String status = LogInSteps.driver.findElement(By.id("CTS_TS_LAND_PER_CTS_TS_STATUS_LAND$1")).getText();
		System.out.println("Status of previously submitted timesheet : " +status);
		System.out.println(" ");
		
		Thread.sleep(5000);
		LogInSteps.driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$1']")).click();
		Thread.sleep(10000);
		LogInSteps.driver.switchTo().frame("TargetContent");
		Thread.sleep(5000);
		
		String totalHrs = LogInSteps.driver.findElement(By.id("EX_TM_DT_DLY_WK_TOTAL$0")).getText();
		System.out.println("Total hours updated : "+totalHrs);
		System.out.println(" ");
		Thread.sleep(5000);
		
		String managerName = LogInSteps.driver.findElement(By.id("PERSONAL_DATA_NAME$18$$1")).getText();
		System.out.println("Manager Name :" +managerName);
		System.out.println(" ");
		Thread.sleep(5000);
		

		LogInSteps.driver.navigate().back();
		Thread.sleep(5000);
		LogInSteps.driver.switchTo().defaultContent();
		
		
		LogInSteps.driver.close();
		LogInSteps.driver.quit();

	}

}
