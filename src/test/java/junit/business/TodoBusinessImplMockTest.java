package junit.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import lab.business.TodoServiceBusinessImpl;
import lab.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void test() {

		TodoService mockTodoService = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fight");

		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(todos);

		TodoServiceBusinessImpl todobusinessImpl = new TodoServiceBusinessImpl(mockTodoService);
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		TodoService mockTodoService = mock(TodoService.class);
		TodoServiceBusinessImpl todobusinessImpl = new TodoServiceBusinessImpl(mockTodoService);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fight");

		/* given -set up */
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		/* when - actual method call */
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		/* then - assert call */
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {

		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		TodoServiceBusinessImpl todoBusinessImpl = new TodoServiceBusinessImpl(todoService);

		when(todoService.retrieveTodos("Hari")).thenReturn(allTodos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Hari");

		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.atLeastOnce()).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}

}
