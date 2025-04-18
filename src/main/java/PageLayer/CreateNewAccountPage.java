package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClass;

public class CreateNewAccountPage extends BaseClass {

	//create OR by using @FindBy annotation
	
	@FindBy(name="register[email]")
	private WebElement mail ;
	
	@FindBy(name="register[first_name]")
	private WebElement gname;
	
	@FindBy(name="register[last_name]")
	private WebElement lname;
	
	@FindBy(name="register[address1]")
	private WebElement add1;
	
	@FindBy(name="register[address2]")
	private WebElement add2;
	
	@FindBy(name="register[city]")
	private WebElement city;
	
	@FindBy(name="register[postal_code]")
	private WebElement pcode;
	
	@FindBy(name="register[country]")
	private WebElement country;
	
	@FindBy(name="register[licence_agreement_n_policy]")
	private WebElement cbox;
	
	
	//initialize the OR by using PageFactory.initElements()method in the constuctor
	
	public CreateNewAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//create associated methods for each and every OR without passing test data
	
	public void createNewUserFunctionality(String Email,String Gname,String lastname,String Address1,String Adress2,String City,String postalcode,String nation)
	{
		mail.sendKeys(Email);
		gname.sendKeys(Gname);
		lname.sendKeys(lastname);
		add1.sendKeys(Address1);
		add2.sendKeys(Adress2);
		city.sendKeys(City);
		pcode.sendKeys(postalcode);
		Select sel =new Select(country);
		sel.selectByVisibleText(nation);
		cbox.click();
	}
	
	
	
	
	
}
