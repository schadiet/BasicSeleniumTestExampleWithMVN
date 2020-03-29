package de.codingsolo.selenium.tests;

import static org.assertj.core.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.selenium.pages.GasMileageCalculatorPage;

public class TestGasMileAgeCalculationStandardFireFox {
	
	WebDriver driver;
	public final String url= "https://www.calculator.net/gas-mileage-calculator.html";

	@Before
	public void beforeCalculationTest() throws Exception {
		System.out.println("Vor dem GasMileAge Calculation Test");
		System.setProperty("webdriver.gecko.driver", "./drivers/firefox/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@After
	public void afterCalclulationTest() throws Exception {
		System.out.println("Nach dem GasMileAge Calculation Test");
		driver.close();
//		driver.quit();
	}
	
	@Test
	public void testCalculationTest() throws Exception {
		System.out.println("Test der GasMileAge Calculation");
		
		// ARRANGE
		GasMileageCalculatorPage gasMileagePage = new GasMileageCalculatorPage(driver);
		gasMileagePage.setOdometerNow("1500");
		gasMileagePage.setOdometerBefore("1000");
		gasMileagePage.setGasAdded("50");
		gasMileagePage.setGasPrice("1.40");
		
		// ACT
		gasMileagePage.executeCalculation();
		
		// ASSERT 
		String result = gasMileagePage.getResult();
//		System.out.println(result);
		
		
		assertThat(result).contains("10 km/L or 10 L/100 km");
		
	}
	
	
}
