package scripts;
import org.testng.annotations.Test;
import Pages.AmazoneTest;
import Pages.CromaTest;
import utility.Base;

public class AvercastTest extends Base{
	
	@Test
	public void AvercastTest() throws InterruptedException
	{
		AmazoneTest objAmazoneTest= new AmazoneTest(driver);
		objAmazoneTest.AmazoneSearch("https://www.amazon.in");
		
		CromaTest objCromaTest= new CromaTest(driver);
		objCromaTest.CromaSearch("https://www.croma.com/");
		
		if(objCromaTest.jAmount < objAmazoneTest.jAmzonAmount)		
		{
			System.out.println("Lesser Value:-"+objCromaTest.jAmount);
		}
		else 
		{
			System.out.println("Lesser Value:-"+objAmazoneTest.jAmzonAmount);
			
		}
	}

}
