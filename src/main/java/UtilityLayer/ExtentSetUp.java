package UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentSetUp extends BaseClass implements ITestListener{

	 ExtentReports extentreports;
	 ExtentSparkReporter extentsparkreporter;
	 ExtentTest extenttest;
	
	@Override
	public void onStart(ITestContext context) {
		
		//create ExtentReport/HTML report 
		
		 extentreports= new ExtentReports();
		 
		 //create SimpleDateFormat
		 
		 SimpleDateFormat simple= new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date= simple.format(new Date());
		
		String suitename =context.getSuite().getName();
		
		//now store extent report in desired location
		
		 extentsparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentHTMLReport\\"+suitename+date+".html");
		  extentreports.attachReporter(extentsparkreporter);
		 
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//create object of ExtentTest
		ExtentTest extenttest=extentreports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS,"Test case Pass name is"+result.getMethod().getMethodName());
		
		//write code for screenshot
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		
		//create simpledateformat object
		
		SimpleDateFormat simple= new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date=simple.format(new Date());
		
		String methodname=result.getMethod().getMethodName();
		
		//createb string path which is path where we store screenshot
		
		String path= System.getProperty("user.dir"+"\\PassScreenshotFolder\\"+methodname+date+".png");
		File dest= new File(path);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.log(Status.FAIL,"Test case Fail name is"+result.getMethod().getMethodName());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.SKIP,"Test case Skip name is"+result.getMethod().getMethodName());
		
	}


	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
	}
	
	

}
