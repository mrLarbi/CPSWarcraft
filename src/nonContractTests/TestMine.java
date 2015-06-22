package nonContractTests;

import implementations.MineImpl;

import org.junit.Before;

import contractTests.AbstractMineTest;

public class TestMine extends AbstractMineTest {

	@Before 
	public void beforeTesting() {
		mine = new MineImpl();
	}
}
