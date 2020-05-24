package algo

import org.junit.Test
import java.util.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UniquePathsTest {

    @Test
    fun test() {
        val solution = UniquePaths()
        assertEquals(3, solution.uniquePaths(3, 2))
        var result = 0
        val cost = measureTimeMillis {
            result = solution.uniquePaths(23, 12)
        }
        assertEquals(193536720, result)
        assertTrue {
            cost < 3000
        }
    }

}