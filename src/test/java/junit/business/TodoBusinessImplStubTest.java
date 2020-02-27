package junit.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import lab.business.TodoServiceBusinessImpl;
import lab.data.api.TodoService;
import lab.data.api.TodoServiceImpl;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {

		TodoService todoService = new TodoServiceImpl();
		TodoServiceBusinessImpl todobusineeImpl = new TodoServiceBusinessImpl(todoService);
		List<String> filteredTodos = todobusineeImpl.retrieveTodosRelatedToSpring("dummy");

		assertEquals(2, filteredTodos.size());
	}

}
