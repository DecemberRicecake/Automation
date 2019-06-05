package ui.mobile_web.lp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YixinPage {

	@FindBy(how=How.XPATH, using="//*[@id=\"UserCity\"]")
	public static WebElement city;

	@FindBy(how=How.XPATH, using="//*[@id=\"UserName\"]")
	public static WebElement username;

	@FindBy(how=How.XPATH, using="//*[@id=\"phone\"]")
	public static WebElement mobile;

	@FindBy(how=How.XPATH, using="//*[@id=\"yixin\"]/div[1]/p")
	public static WebElement submit;

	@FindBy(how=How.XPATH, using="//*[@id=\"yzm\"]")
	public static WebElement imgCode;

	@FindBy(how=How.XPATH, using="//*[@id=\"msg\"]")
	public static WebElement smsCode;

	public static class CityPage {
		@FindBy(how=How.XPATH, using="//*[@id=\"yixin\"]/div[7]/div/ul[1]/li[3]/a")
		public static WebElement citychild;
	}
}

