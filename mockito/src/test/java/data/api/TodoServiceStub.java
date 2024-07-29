package data.api;

import com.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user){
        return Arrays.asList("My Spring App", "Learn Spring", "I like the way you move");
    }
}
