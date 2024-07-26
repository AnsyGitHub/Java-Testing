package helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelperParameterizedTest{

    private StringHelper helper;

    @BeforeEach
    public void setup() {
        helper = new StringHelper();
    }

    @ParameterizedTest
    @MethodSource("provideTestParameters")
    public void testTruncateAInFirst2Positions_AInFirst2Positions(String input, String expected){
        assertEquals(expected, helper.truncateAInFirst2Positions(input));
    }

    static Stream<Arguments> provideTestParameters() {
        return Stream.of(
                Arguments.of("AACD", "CD"),
                Arguments.of("ACD", "CD")
        );
    }

}
