package junit.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayList = spy(ArrayList.class);
		assertEquals(0, arrayList.size());

		//stub(arrayList.size()).toReturn(5);

		arrayList.add("Hari");
		assertEquals(1, arrayList.size());
	}

}
