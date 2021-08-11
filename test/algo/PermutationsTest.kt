package algo

import org.junit.Test

class PermutationsTest {

    @Test
    fun test() {
        val solution = Permutations()
        solution.permute(intArrayOf(1, 2, 3)).forEach { it ->
            print("[ ")
            it.forEach { value ->
                print("$value, ")
            }
            print("]")
        }
    }

}