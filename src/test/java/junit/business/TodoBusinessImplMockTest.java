package junit.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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

		/* given */
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		/* when */
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		/* then */
		assertThat(filteredTodos.size(), is(2));
	}

}
