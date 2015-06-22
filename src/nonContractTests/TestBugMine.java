package nonContractTests;

import contractTests.AbstractMineTest;
import implementationsBug.MineImplBug;
import org.junit.Before;

public class TestBugMine extends AbstractMineTest {

	@Before 
	public void beforeTesting() {
		mine = new MineImplBug();
	}
}
