package junit.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsCallMockListSizeMethod() {
		List simpleListMoct = mock(List.class);
		when(simpleListMoct.size()).thenReturn(2);

		assertEquals(2, simpleListMoct.size());
	}

	@Test
	public void letsCallMockListSize_ReturnMultipleValues() {
		List simpleListMoct = mock(List.class);
		when(simpleListMoct.size()).thenReturn(2).thenReturn(3);

		assertEquals(2, simpleListMoct.size());
		assertEquals(3, simpleListMoct.size());
	}

	@Test
	public void letsMockListGet() {
		List simpleListMoct = mock(List.class);
		when(simpleListMoct.get(anyInt())).thenReturn("Hari");

		assertEquals("Hari", simpleListMoct.get(0));
		assertEquals("Hari", simpleListMoct.get(2));
	}

	@Test(expected = RuntimeException.class)
	public void letsMockList_throwAnException() {
		List simpleListMoct = mock(List.class);
		when(simpleListMoct.get(anyInt())).thenThrow(RuntimeException.class);

		simpleListMoct.get(0);
	}

}
