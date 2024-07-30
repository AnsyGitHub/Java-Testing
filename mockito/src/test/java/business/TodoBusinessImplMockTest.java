package business;

import com.business.TodoBusinessImpl;
import com.data.api.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Mock
    TodoBusinessImpl todoBusiness;

    @Mock
    TodoService todoService;

    @BeforeEach
    public void setup(){
        todoService = mock(TodoService.class);
        todoBusiness = new TodoBusinessImpl(todoService);
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

    //BDD
    @Test
    public void testDeleteTodosNotRelatedToSpring() {
        //Given (setup)
        given(todoService.retrieveTodos("Ans"))
                .willReturn(Arrays.asList(
                        "My Spring App",
                        "Learn Spring",
                        "I like the way you move"
                        )
                );

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Ans");

        //Then
        verify(todoService).deleteTodos("I like the way you move");
        verify(todoService,never()).deleteTodos("Learn Spring");
        verify(todoService, times(1)).deleteTodos("I like the way you move");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_argumentCaptor(){
        given(todoService.retrieveTodos("Ans"))
                .willReturn(Arrays.asList(
                                "My Spring App",
                                "Learn Spring",
                                "I like the way you move"
                        )
                );

        todoBusiness.deleteTodosNotRelatedToSpring("Ans");

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(todoService).deleteTodos(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue()).isEqualTo("I like the way you move");
    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_multipleArgumentCaptor(){
        given(todoService.retrieveTodos("Ans"))
                .willReturn(Arrays.asList(
                                "My App",
                                "Learn Spring",
                                "I like the way you move"
                        )
                );

        todoBusiness.deleteTodosNotRelatedToSpring("Ans");

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(todoService, times(2)).deleteTodos(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getAllValues().size()).isEqualTo(2);
    }
}
