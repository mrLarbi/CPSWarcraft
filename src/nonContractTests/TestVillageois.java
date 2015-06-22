package nonContractTests;

import implementations.VillageoisImpl;

import org.junit.Before;

import contractTests.AbstractVillageoisTest;

public class TestVillageois extends AbstractVillageoisTest {
		
	@Before 
	public void beforeTesting() {
		villageois = new VillageoisImpl();
	}
}