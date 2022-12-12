package com.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.LoginPagePom;
import com.Utility.BaseClass;
import com.Utility.Library;

public class Verify extends BaseClass {

	public static LoginPagePom login;
    public static WebDriverWait wait;
	
	@Test(priority=0)
	public void Verify_fields() {
		
		//Verifying the fields are empty or not
		
		login=PageFactory.initElements(driver,LoginPagePom.class);
	     String input_data1=login.getusername().getText();
	     if(input_data1.isEmpty()) {
	    	 System.out.println("username field is empty");
	     }
	     else {
	    	 System.out.println(input_data1);
	     }
	     
	     
	     String input_data2=login.getpassword().getText();
	     if(input_data2.isEmpty()) {
	    	 System.out.println("password field is empty");
	     }
	     else {
	    	 System.out.println(input_data2);
	     }

	}
	
	
	@Test(priority=1)
	public void verify_Login_functionality() {
		
		// Sending values to fields
		
		login=PageFactory.initElements(driver,LoginPagePom.class);
		Library.Custom_Sendkeys(login.getusername(),"Admin");
		Library.Custom_Sendkeys(login.getpassword(),"admin123");
		Library.Custom_Click(login.btn_login());
		
		// checking logout is visible or not 
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		WebElement logout_btn=driver.findElement(By.xpath("//a[text()='Logout']"));
		wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(logout_btn));
		if(logout_btn.getText().equals("Logout")) {
			System.out.println("Logout is visible");
		}
		else {
			 System.out.println("not visible");
		}
		
	}
	
	
	@Test(priority=2)
	public void verify_punching_functionality() throws Exception {
		
		 //sending deatils for successful login
		login=PageFactory.initElements(driver,LoginPagePom.class);
		 Library.Custom_Sendkeys(login.getusername(),"Admin");
		 Library.Custom_Sendkeys(login.getpassword(),"admin123");
		 Library.Custom_Click(login.btn_login());
		   
		//verifying punch in/punch out
		 driver.findElement(By.xpath("//span[text()='Time']")).click();
		 driver.findElement(By.xpath("(//li[@class='oxd-topbar-body-nav-tab --parent'])[1]")).click();
		 driver.findElement(By.xpath("//a[text()='Punch In/Out']")).click();
				
		//getting date and time of system
		 Date date =new Date();
		 System.out.println("system_Date: "+date);
		 Timestamp ts=new Timestamp(date.getTime());
		 System.out.println("ts: "+ts); 
		 
		 String DateFormat = "yyyy-MM-dd hh:mm a"; 
		 SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		 String formatter=format.format(ts);
		 System.out.println(formatter.replace("pm","PM")); 
	
		 WebElement punchdate=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		 wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOf(punchdate));
	     String punchIN_date=punchdate.getAttribute("value");		 
		 System.out.println("punchIN_date:"+punchIN_date);
		
		 String punchIN_time=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).getAttribute("value");
		 System.out.println("punchIN_time:"+punchIN_time); 
		 
		 String date_time=punchIN_date+" "+punchIN_time;
		 System.out.println("date_time:"+date_time.trim());
		 
		 System.out.println(formatter.equalsIgnoreCase(date_time));
		 //Assert.assertEquals(formatter,date_time);
		   
		 WebElement IN=driver.findElement(By.xpath("//button[text()=' In ']"));
		 IN.click();	
		 
		 
		 
		  //getting date and time of system
		 Date date1 =new Date();
		 System.out.println("system_Date: "+date1);
		 Timestamp ts1=new Timestamp(date1.getTime());
		 System.out.println("ts1: "+ts1); 
		 
		 String strDateFormat = "yyyy-MM-dd hh:mm a"; 
		 SimpleDateFormat format1 = new SimpleDateFormat(strDateFormat);
		 String formatter1=format1.format(ts1);
		 System.out.println(formatter1.replace("pm","PM")); 
		
		 WebElement punch_date=driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']"));
		 wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOf(punch_date));
		 String punchOut_date=punch_date.getAttribute("value");
		 System.out.println("punchOut_date:"+punchOut_date);
		 
		 String punchOut_time=driver.findElement(By.xpath("//input[@placeholder='hh:mm']")).getAttribute("value");
		 System.out.println("punchOut_time:"+punchOut_time);
		 
		 String date_time1=punchOut_date+" "+punchOut_time;
		 System.out.println("date_time1:"+date_time1.trim());
		 
		 
		 System.out.println(formatter1.equalsIgnoreCase(date_time1));
		 //Assert.assertEquals(formatter1,date_time1);
		 
		 WebElement Out=driver.findElement(By.xpath("//button[text()=' Out ']"));
		 Out.click();
		
	}
	
	
	@Test(priority=4)
	public void verify_launch_buttons() {
		
		 Actions act=new Actions(driver);
		
		 login=PageFactory.initElements(driver,LoginPagePom.class);
		 Library.Custom_Sendkeys(login.getusername(),"Admin");
		 Library.Custom_Sendkeys(login.getpassword(),"admin123");
		 Library.Custom_Click(login.btn_login());
		
		   
		 WebElement btn1= driver.findElement(By.xpath("(//button[@type='button'])[7]"));
		 System.out.println(btn1.getAccessibleName());
		 act.moveToElement(btn1);
		 System.out.println(btn1.isDisplayed());
		   
		   
		 WebElement btn2= driver.findElement(By.xpath("(//button[@type='button'])[8]"));
		 System.out.println(btn2.getAccessibleName());
		 act.moveToElement(btn2);
		 System.out.println(btn2.isDisplayed());
		   
		   
		 WebElement btn3= driver.findElement(By.xpath("(//button[@type='button'])[9]"));
		 System.out.println(btn3.getAccessibleName());
		 act.moveToElement(btn3);
		 System.out.println(btn3.isDisplayed());
		   
		   
		 WebElement btn4= driver.findElement(By.xpath("(//button[@type='button'])[10]"));
		 System.out.println(btn4.getAccessibleName());
		 act.moveToElement(btn4);
		 System.out.println(btn4.isDisplayed());
		   
		   
		 WebElement btn5= driver.findElement(By.xpath("(//button[@type='button'])[11]"));
		 System.out.println(btn5.getAccessibleName());
		 act.moveToElement(btn5);
		 System.out.println(btn5.isDisplayed());
		   
		 WebElement btn6= driver.findElement(By.xpath("(//button[@type='button'])[12]"));
		 System.out.println(btn6.getAccessibleName());
		 act.moveToElement(btn6);
		 System.out.println(btn6.isDisplayed());
		   
		   
		   
	}
	
	
}
