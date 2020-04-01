package intv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertNumbersTest {

    @Test
    public void testConvert() {
        ConvertNumbers conv = new ConvertNumbers();
        assertEquals("123.1", conv.convert(123.1));
        assertEquals("1,234.1", conv.convert(1234.1));
        assertEquals("0.0", conv.convert(0.0));
    }
}