package junit.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import lab.business.TodoServiceBusinessImpl;
import lab.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

	@Mock
	private TodoService todoService;

	@InjectMocks
	private TodoServiceBusinessImpl todobusinessImpl;

	@Test
	public void test() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fight");

		when(todoService.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fight");

		/* given -set up */
		given(todoService.retrieveTodos("Dummy")).willReturn(todos);

		/* when - actual method call */
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		/* then - assert call */
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Hari")).thenReturn(allTodos);

		todobusinessImpl.deleteTodosNotRelatedToSpring("Hari");

		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.atLeastOnce()).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}

}
