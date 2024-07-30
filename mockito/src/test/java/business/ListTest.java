package business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Mock
    List<String> mockList;

    @BeforeEach
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test1() {
        List<?> listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }

    @Test
    public void test2(){
        when(mockList.get(anyInt())).thenReturn("Ans");
        assertEquals("Ans", mockList.get(1));
    }
}
