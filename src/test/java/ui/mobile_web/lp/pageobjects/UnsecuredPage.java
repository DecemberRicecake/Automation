package ui.mobile_web.lp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UnsecuredPage {

	@FindBy(how=How.XPATH, using="//*[@id=\"UserName\"]")
	public static WebElement username;

	@FindBy(how=How.XPATH, using="//*[@id=\"phone\"]")
	public static WebElement mobile;

	@FindBy(how=How.XPATH, using="//*[@id=\"yzm\"]")
	public static WebElement imgCode;

	@FindBy(how=How.XPATH, using="//*[@id=\"msg\"]")
	public static WebElement smsCode;

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[2]/li[1]")
	public static WebElement identity;

	public static class IdentityPage {
		@FindBy(how=How.XPATH, using="//*[@id=\"sixhave-pop\"]/ul/li[1]")
		public static WebElement identity;
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[2]/li[2]")
	public static WebElement salary;

	public static class SalaryPage {
		@FindBy(how=How.XPATH, using="//*[@id=\"sixhave-pop\"]/ul/li[3]")
		public static WebElement salary;
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[2]/li[3]")
	public static WebElement socialsecurityfund;

	public static class SocialSecuritySFundPage {
		@FindBy(how=How.XPATH, using="//*[@id=\"sixhave-pop\"]/ul/li[2]")
		public static WebElement socialsecurityfund;
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[3]/li[1]/span/i[2]")
	public static WebElement havehouse;

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[3]/li[2]/span/i[2]")
	public static WebElement havecar;

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[1]/ul[3]/li[3]/span/i[2]")
	public static WebElement insuranceinfo;

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/p")
	public static WebElement submit;

	@FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/div[5]/div/ul[1]/li[4]/a")
	public static WebElement city;

    @FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/header/div/span")
    public static WebElement cityname;

    @FindBy(how=How.XPATH, using="//*[@id=\"unsecured\"]/header/div/i")
    public static WebElement citylabel;
}

