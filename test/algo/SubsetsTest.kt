package algo

import org.junit.Test

class SubsetsTest {

    @Test
    fun test() {
        val solution = Subsets()
        val nums1 = intArrayOf(0, 1, 2)
        solution.subsets(nums1).forEach {
            print("[")
            it.forEach { i->
                print("$i, ")
            }
            print("]")
            println()
        }
    }

}