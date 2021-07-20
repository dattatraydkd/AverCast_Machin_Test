package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazoneTest {

	public int jAmzonAmount = 0;
	WebDriver driver;

	public AmazoneTest(WebDriver objDriver) {
		this.driver = objDriver;
		PageFactory.initElements(driver, this);
	}

	String SearchItem = "Samsung Galaxy Z Fold 2";
	@FindBy(id = "twotabsearchtextbox")
	WebElement AmazoneSearchBox;
	@FindBy(id = "nav-search-submit-button")
	WebElement SearchButton;
	@FindBy(id = "priceblock_ourprice")
	WebElement SearchItemPrice;

	public int AmazoneSearch(String url) {
		try {
			driver.get(url);
			AmazoneSearchBox.sendKeys(SearchItem);
			SearchButton.click();
			List<WebElement> SearchItemsOnPage = driver
					.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			List<WebElement> value = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			for (int i = 0; i < SearchItemsOnPage.size(); i++)

			{
				String sCartItemName = SearchItemsOnPage.get(i).getText();
				if (sCartItemName.contains("Samsung Galaxy Z Fold2")) {
					String sItemValue = value.get(i).getText();

					String Value = sItemValue.replaceAll(",", "");
					jAmzonAmount = Integer.parseInt(Value);
					// System.out.println(jAmzonAmount);
					break;
				}

			}

		}

		catch (Exception e) {

			System.out.println(e);
		}

		return jAmzonAmount;

	}
}
