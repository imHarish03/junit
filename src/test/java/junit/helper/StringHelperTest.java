package junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void test() {
		// fail("Not yet implemented");

		StringHelper helper = new StringHelper();
		assertEquals("HRIA", helper.truncateAInFirst2Positions("HARIA"));
		assertEquals("RIA", helper.truncateAInFirst2Positions("YARIA"));
	}

}
