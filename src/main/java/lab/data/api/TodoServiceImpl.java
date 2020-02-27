package lab.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceImpl implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fight");
	}

}
