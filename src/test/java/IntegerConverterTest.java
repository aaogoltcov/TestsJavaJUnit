import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IntegerConverterTest {
  public IntegerConverter number;

  public static Stream<Arguments> testHexConverterArguments() {
    return Stream.of(
        Arguments.of(new IntegerConverter(10), "a"),
        Arguments.of(new IntegerConverter(20), "14"),
        Arguments.of(new IntegerConverter(30), "1e")
    );
  }

  @BeforeEach
  public void initTest() {
    this.number = new IntegerConverter(10);
  }

  @AfterEach
  public void finalizeTest() {
    this.number = null;
  }

  @Test
  public void testBinaryConverter() {
    // given
    final IntegerConverter original = this.number;
    final String expected = "1010";

    // when
    final String actual = original.toBinary();

    // assert
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testOctalConverter() {
    // given
    final IntegerConverter original = this.number;
    final String expected = "12";

    // when
    final String actual = original.toOctal();

    // assert
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testHexConverter() {
    // given
    final IntegerConverter original = this.number;
    final String expected = "a";

    // when
    final String actual = original.toHex();

    // assert
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testNullArgumentConverter() {
    // given
    final IntegerConverter original = null;

    // expect
    Assertions.assertThrowsExactly(NullPointerException.class, () -> original.toHex());
  }

  @ParameterizedTest
  @MethodSource("testHexConverterArguments")
  public void testHexConverterWithParameters(IntegerConverter original, String expected) {
    // when
    final String actual = original.toHex();

    // assert
    Assertions.assertEquals(expected, actual);
  }
}
