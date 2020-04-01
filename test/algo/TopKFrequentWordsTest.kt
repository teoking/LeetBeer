package algo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertEquals

class TopKFrequentWordsTest {

    @Test
    fun testTopKFrequent() {
        val s = TopKFrequentWords()
        val words1 = arrayOf("i", "love", "leetcode", "i", "love", "coding")
        val expect1 = arrayListOf("i", "love")
        assertEquals(expect1, s.topKFrequent(words1, 2))

        val words2 = arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
        val expect2 = arrayListOf("the", "is", "sunny", "day")
        assertEquals(expect2, s.topKFrequent(words2, 4))

        val words3 = arrayOf("a","aa","aaa")
        val expect3 = arrayListOf("a", "aa")
        assertEquals(expect3, s.topKFrequent(words3, 2))
    }
}