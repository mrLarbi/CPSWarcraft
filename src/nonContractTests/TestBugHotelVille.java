package nonContractTests;

import implementationsBug.HotelVilleImplBug;
import org.junit.Before;
import contractTests.AbstractHotelVilleTest;


public class TestBugHotelVille extends AbstractHotelVilleTest {

	@Before 
	public void beforeTesting() {
		hotelVille = new HotelVilleImplBug();
	}
}
