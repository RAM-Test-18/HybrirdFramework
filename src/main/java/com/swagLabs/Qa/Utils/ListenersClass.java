package com.swagLabs.Qa.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class ListenersClass implements ITestListener {

	public void onTestStart(ITestResult result) 
	{
		System.out.println("========== NEW TEST STARTED ==========");
		System.out.println(String.valueOf(Input.timeStamp()) + " : { " + result.getName() + " }");
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(String.valueOf(Input.timeStamp()) + " : { " + result.getName() + " }\n");
		System.out.println("========== SUCCESSFULLY FINISHED ==========");
	}

	public void onTestFailure(ITestResult result) 
	{
		
		System.out.println(String.valueOf(Input.timeStamp()) + " : { " + result.getName() + " }\n");
		System.out.println("========== TEST FAILED ==========");
		byte[] srcFinal = ((TakesScreenshot)Input.getDriver()).getScreenshotAs(OutputType.BYTES);
		ChainTestListener.embed(srcFinal,"image/png");
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(String.valueOf(Input.timeStamp()) + " : { " + result.getName() + " }\n");
		System.out.println("========== TEST SKIPPED ==========");
	}

	public void onStart(ITestContext context) 
	{
		System.out.println(String.valueOf(Input.timeStamp()) + " : Test Execution Started.");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println(String.valueOf(Input.timeStamp()) + " : Test Execution Finished.");
	}

}
