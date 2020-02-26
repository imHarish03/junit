package junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	StringHelper helper;

	@Before
	public void before() {
		helper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		assertEquals("HRIA", helper.truncateAInFirst2Positions("HARIA"));
	}

	@Test
	public void testTruncateAInFirst2Positions2() {
		assertEquals("YRIA", helper.truncateAInFirst2Positions("YARIA"));
	}

	// ABCD => false, ABAB => true, AB => true, A =>false
	@Test
	public void testAreFirstAndLastTwoCharactersAreSame_BasicNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
}
