import org.junit.Assert.*
import org.junit.Test

class KataTest {
    @Test
    fun `should return 0 for an empty string`() {
        assertEquals(0, add(""))
    }

    @Test
    fun `should return the number if only one number exists`() {
        assertEquals(1, add("1"))
    }

    @Test
    fun `should return the sum for comma delimited numbers`() {
        assertEquals(3, add("1,2"))
    }

    @Test
    fun `should compute the sum for multiple comma delimited numbers`() {
        assertEquals(6, add("1,2,3"))
    }

    @Test
    fun `should compute the sum for comma and newline delimited numbers`() {
        assertEquals(6, add("1,2\n3"))
    }

    @Test
    fun `should compute the sum for a custom delimiter`() {
        assertEquals(6, add("//;\n1;2;3"))
    }

    @Test
    fun `should throw an error for negative numbers`() {
        try {
            add("1\n-2,-5")
            fail("Exception expected")
        }catch(e: Exception) {
            assertEquals("Negative numbers: -2,-5", e.message)
        }
    }

    @Test
    fun `should not include numbers larger than 1000 in the sum`() {
        assertEquals(4, add("1,1001\n3"))
    }

    @Test
    fun `should accept multi length delimiters`() {
        assertEquals(6, add("//[***]\n1***2***3"))
    }

    @Test
    fun `should accept multiple single custom delimiters`() {
        assertEquals(6, add("//[;][a]\n1;2a3"))
    }

    @Test
    fun `should accept mutliple multi length custom delimiters`() {
        assertEquals(6, add("//[&&&][!!]\n1&&&2!!3"))
    }

}