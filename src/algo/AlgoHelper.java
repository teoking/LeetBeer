package algo;

import java.io.PrintStream;
import java.util.List;

public class AlgoHelper {

    private final static PrintStream out = System.out;

    public static void println(String format, Object...args) {
        out.println(String.format(format, args));
    }

    public static void println(String msg) {
        out.println(msg);
    }

    public static void println(int val) {
        out.println(val);
    }

    public static void println(List<?> list) {
        for (Object o : list) {
            if (o instanceof List) {
                println((List<?>) o);
            } else {
                println(o.toString());
            }
        }
    }

    public static void measure(long t) { out.println("Cost ~ " + (System.currentTimeMillis() - t));
    }
}
