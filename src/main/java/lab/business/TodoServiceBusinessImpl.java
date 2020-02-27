package lab.business;

import java.util.ArrayList;
import java.util.List;

import lab.data.api.TodoService;

public class TodoServiceBusinessImpl {

	private TodoService todoService;

	public TodoServiceBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {

		List<String> filterTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filterTodos.add(todo);
			}
		}

		return filterTodos;
	}

}
