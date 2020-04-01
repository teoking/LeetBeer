package lang;

import algo.AlgoHelper;
import intv.ConvertNumbers;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class ConvertNumbersTest {

    @Test
    public void testHashTable() {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("ate", 0);
        table.put("tea", 0);
        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            AlgoHelper.println(key + " hash=" + key.hashCode());
        }
    }
}