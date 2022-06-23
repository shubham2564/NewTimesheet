package StepDefinition;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LogInSteps {
	
	String home_page;
	String email;
	String password;
	
	public static WebDriver driver = null;
	
	
	
	@Given("Read data from excel")
	public void Read_data_from_excel() throws Exception {
	File src= new File("C:\\Users\\Shubham\\Downloads\\automation.xlsx");
	FileInputStream fis=new FileInputStream(src);


	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet1= wb.getSheetAt(0);
	home_page = sheet1.getRow(1).getCell(0).getStringCellValue();
	email = sheet1.getRow(1).getCell(1).getStringCellValue();
	password = sheet1.getRow(1).getCell(2).getStringCellValue();
	
	Thread.sleep(2000);
	
	
	
	
	
	wb.close();
	
	}
	
	
	
	
	@And("browser is open")
	public void browser_is_open() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shubham\\new5\\New_Timehsheet\\src\\test\\resources\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		

	}
	
	@And("user is on login page")
	public void user_is_on_login_page(){
		
		driver.navigate().to(home_page);
		
		
	}

	@When("user enters id")
	public void user_enters_id() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(email);
		

	}
	@And("user clicks signin")
	public void user_clicks_signin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit' and @id='idSIButton9']")).click();
	}
	

	@And("user enters password")
	public void user_enters_password() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys(password);

	}
	@And("user again clicks signin")
	public void user_again_clicks_signin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();

	}

	@And("user is on home page")
	public void user_is_on_home_page() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[contains(text(),'Call')]")).click();
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//*[@id=\'idSIButton9\']")).click();
		Thread.sleep(5000);
		
		
		
	}
	
}
