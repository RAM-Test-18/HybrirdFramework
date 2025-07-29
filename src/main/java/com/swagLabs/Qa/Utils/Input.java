package com.swagLabs.Qa.Utils;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input {

	private static int IMPLICIT_WAIT = 180;

	private static int PAGELOAD_WAT = 300;

	private static int LOAD = 30;

	private static boolean m_Task_Passed = true;

	private static boolean m_Task_Failed = false;

	private static boolean m_Task_Result = false;

	private static String mBrowserName;

	private static WebDriver mdriver;

	private static WebDriverWait mwait;

	protected static String mainWindow;

	public static String timeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(":", "_");

	}

	public static Boolean setExcelPath(String excelFullPath) {
		m_Task_Result = m_Task_Failed;
		if (excelFullPath != null) {
			Excel._excelPath = excelFullPath;
			m_Task_Result = m_Task_Passed;
		}

		return Boolean.valueOf(m_Task_Result);

	}

	public static Boolean setting_Up_BrowserName(String browserName) {
		m_Task_Result = m_Task_Failed;

		if (browserName != null)
			mBrowserName = browserName;
		m_Task_Result = m_Task_Passed;
		return Boolean.valueOf(m_Task_Result);
	}

	public static Boolean urlNavigation(String baseURL) throws InterruptedException {
		m_Task_Result = m_Task_Passed;

		if (mBrowserName.equals("Chrome") || mBrowserName.equalsIgnoreCase("Google Chrome")) {
			mdriver = new ChromeDriver();
			System.out.println(timeStamp().toString() + ": Chrome Browser is Selected.");
			m_Task_Result = m_Task_Passed;
		} else if (mBrowserName.equals("Edge") || mBrowserName.equalsIgnoreCase("Microsoft Edge")) {
			mdriver = new EdgeDriver();
			System.out.println(timeStamp().toString() + ": Edge Browser is Selected.");
			m_Task_Result = m_Task_Passed;

		} else if (mBrowserName.equals("Firefox") || mBrowserName.equalsIgnoreCase("Mozilla Firefox")) {
			mdriver = new FirefoxDriver();
			System.out.println(timeStamp().toString() + " : Firefox Browser is Selected.");
			m_Task_Result = m_Task_Passed;
		} else {
			m_Task_Result = m_Task_Failed;
		}

		if (m_Task_Result) {
			mwait = new WebDriverWait(mdriver, Duration.ofSeconds(IMPLICIT_WAIT));
			mainWindow = mdriver.getWindowHandle();
			mdriver.manage().window().maximize();
			mdriver.get(baseURL);
			mdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
			mdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
			do {

			} while (!waitForPageToLoad(LOAD).booleanValue());
		} else {
			System.out.println("Browser Seletion is Failed.");
		}

		return m_Task_Result;
	}

	public static Boolean waitForPageToLoad(int timeInSeconds) throws InterruptedException {
		m_Task_Result = m_Task_Failed;
		JavascriptExecutor js = (JavascriptExecutor) Input.getDriver();
		String jsCommand = "return document.readyState";
		js.executeScript(jsCommand, new Object[0]).toString().equals("complete");
		m_Task_Result = m_Task_Passed;

		for (int i = 0; i < timeInSeconds; i++) {

			TimeUnit.SECONDS.sleep(3L);

			if (js.executeScript(jsCommand, new Object[0]).toString().equals("complete")) {
				break;
			}
		}

		return Boolean.valueOf(m_Task_Result);

	}

	public static void waitUntilElementVisible(By elementToWait) {
		if (elementToWait != null) {
			WebElement visibleElement = mdriver.findElement(elementToWait);
			mwait.until(ExpectedConditions.visibilityOf(visibleElement));
		}
	}

	public static WebDriver getDriver() {
		return mdriver;
	}

	public static void scrollToElement(By scrollElement) {
		if (scrollElement != null) {
			JavascriptExecutor jse = (JavascriptExecutor) Input.getDriver();
			WebElement scrollEle = Input.getDriver().findElement(scrollElement);
			jse.executeScript("arguments[0].scrollIntoView(true);", scrollEle);
		}

	}

	public static void textEnter(By textToEnetrElement, String messageToPass) {
		if (textToEnetrElement != null && messageToPass != null)
			mdriver.findElement(textToEnetrElement).sendKeys(new CharSequence[] { messageToPass });
	}

	public static void clickOn(By clickElement, String typeOfClick) {
		if (clickElement != null && typeOfClick != null) {
			if (typeOfClick.equalsIgnoreCase("click")) {
				mdriver.findElement(clickElement).click();
			} else if (typeOfClick.equalsIgnoreCase("right click")) {
				Actions actions = new Actions(Input.getDriver());
				WebElement rightClickElement = mdriver.findElement(clickElement);
				actions.contextClick(rightClickElement).perform();
			} else if (typeOfClick.equalsIgnoreCase("double click")) {
				Actions actions = new Actions(Input.getDriver());
				WebElement doubleClickElement = mdriver.findElement(clickElement);
				actions.doubleClick(doubleClickElement).build().perform();
			}
		}

	}

	public static void mouseHover(By hoverElement) {
		if (hoverElement != null) {
			Actions actions = new Actions(Input.getDriver());
			WebElement hoverEle = mdriver.findElement(hoverElement);
			actions.moveToElement(hoverEle).perform();
		}

	}

	public static String getElementText(By elementText) {
		String cellData = null;
		if (elementText != null)
			cellData = mdriver.findElement(elementText).getText();
		return cellData;
	}

	public static void takeScreenShot(String methodName) {

	}

	public static void flowsheet_Actions(By selectPatientFS, By moveToStatusBar, By selectAction)
			throws InterruptedException {
		if (selectPatientFS != null) {
			Input.clickOn(selectPatientFS, "click");
		}
		if (moveToStatusBar != null) {
			Input.mouseHover(selectAction);
		}
		if (selectAction != null) {
			Input.clickOn(selectAction, "click");
		}
	}

	public static int CountS(By webElement) {
		String _records = Input.getElementText(webElement);
		String[] _records1 = _records.split("\\s");
		int count = 0;

		for (count = 0; count < _records1.length; count++) {
			if (_records1[count + 1].contains("record(s)")) {
				break;
			}
		}
		return Integer.parseInt(_records1[count]);
	}

	public static int TextPerPage(By fsWebElement) {
		String _flowsheets = Input.getElementText(fsWebElement); //// 1 - 25 of 51 record(s)
		String[] _records1 = _flowsheets.split("\\s");
		int count = 0;

		for (count = 0; count < _records1.length; count++) {
			if (_records1[count + 1].contains("of")) {
				break;
			}
		}
		return Integer.parseInt(_records1[count]);
	}

}
