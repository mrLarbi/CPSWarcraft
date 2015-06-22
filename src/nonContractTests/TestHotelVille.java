package nonContractTests;

import implementations.HotelVilleImpl;

import org.junit.Before;

import contractTests.AbstractHotelVilleTest;

public class TestHotelVille extends AbstractHotelVilleTest {

	@Before 
	public void beforeTesting() {
		hotelVille = new HotelVilleImpl();
	}
}
