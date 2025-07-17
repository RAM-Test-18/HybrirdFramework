package com.swagLabs.Qa.Base;

import com.swagLabs.Qa.Utils.Excel;
import com.swagLabs.Qa.Utils.Input;

public class BaseClass {

	
	
	// Common Element to Use 
	
	protected static boolean g_Task_Passed =true;
	
	protected static boolean g_Task_Failed =false;
	
	protected static boolean g_Task_Result =false;
	
	protected static String USER_DIR = System.getProperty("user.dir");
	
	protected static String EXCEL_PATH = "/Configuration_DataFile/testData.xlsx";
	
	protected static boolean EXCEL_DIRECTORY = Input.setExcelPath(USER_DIR+EXCEL_PATH);

	protected static String inventoryPageTitle ="Swag Labs123";
	
	protected static String thanksForOrderText = "THANK YOU FOR YOUR ORDER";
	
	protected static String click ="click";
	
	protected static String bName ="Edge";
	
	protected static String browserURL ="https://www.saucedemo.com/v1/";
	
	
	protected static String browserURL_New = Excel.getDataFromExcel(0,2,0);
	
	protected static String userName_New = Excel.getDataFromExcel(0,2,1);
	
	protected static String password_New = Excel.getDataFromExcel(0,2,2);
	
	protected static String  [] loginElementText = {userName_New,password_New};
	
	
}
