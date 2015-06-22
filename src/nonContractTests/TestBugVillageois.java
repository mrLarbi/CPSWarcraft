package nonContractTests;

import implementationsBug.VillageoisImplBug;
import org.junit.Before;
import contractTests.AbstractVillageoisTest;

public class TestBugVillageois extends AbstractVillageoisTest {

	@Before 
	public void beforeTesting() {
		villageois = new VillageoisImplBug();
	}
}