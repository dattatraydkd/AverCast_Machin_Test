package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CromaTest {

	public int jAmount = 0;
	WebDriver driver;

	public CromaTest(WebDriver objDriver) {
		this.driver = objDriver;
		PageFactory.initElements(driver, this);
	}

	String SearchItem = "Samsung Galaxy Z Fold 2 (256GB ROM, 12GB RAM, Mystic Bronze)";
	@FindBy(xpath = "//input[@id='search']")
	WebElement CromaSearchBox;
	@FindBy(xpath = "//span[@class='amount']")
	WebElement CromaValue;

//@FindBy (id="priceblock_ourprice") WebElement SearchItemPrice;
	public int CromaSearch(String url) {
		try {

			driver.get(url);
			Thread.sleep(5000);

			CromaSearchBox.sendKeys(SearchItem);
			CromaSearchBox.sendKeys(Keys.ENTER);
			String sCromavalueamt = CromaValue.getText();
			String sFinalCromaValue = sCromavalueamt.replaceAll("₹", "").replaceAll(",", "");
			String SAmount = sFinalCromaValue.split("\\.")[0];

			jAmount = Integer.parseInt(SAmount);
			// System.out.println(jAmount);

		}

		catch (Exception e) {

			System.out.println(e);
		}
		return jAmount;

	}
}
