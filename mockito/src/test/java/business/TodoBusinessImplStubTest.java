package business;

import com.business.TodoBusinessImpl;
import com.data.api.TodoService;
import data.api.TodoServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {


    TodoBusinessImpl todoBusiness;

    @BeforeEach
    public void setup(){
        TodoService todoService = new TodoServiceStub();
        this.todoBusiness = new TodoBusinessImpl(todoService);
    }

    @Test
    public void testRetrieveTodosWithSpring_UsingAStub(){
        List<String> filteredWords = todoBusiness.retrieveTodosRelatedToSpring("Ans");
        assertEquals(2, filteredWords.size());
        assertEquals(Arrays.asList("My Spring App", "Learn Spring"), filteredWords);
    }

}
