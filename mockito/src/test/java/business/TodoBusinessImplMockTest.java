package business;

import com.business.TodoBusinessImpl;
import com.data.api.TodoService;
import data.api.TodoServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    TodoBusinessImpl todoBusiness;

    @Mock
    TodoService todoService;

    @BeforeEach
    public void setup(){
        todoService = mock(TodoService.class);
        this.todoBusiness = new TodoBusinessImpl(todoService);
    }
    @Test
    public void testRetrieveTodosWithSpring_UsingAStub(){
        when(todoService.retrieveTodos("Ans"))
                .thenReturn(Arrays.asList(
                                "My Spring App",
                                "Learn Spring",
                                "I like the way you move")
                );
        List<String> filteredWords = todoBusiness.retrieveTodosRelatedToSpring("Ans");
        assertEquals(2, filteredWords.size());
    }
}
