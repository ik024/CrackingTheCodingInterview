package crackingthecodinginterview.kotlincode.chapter1

/**
 * Check if 2 string are permutation of each other
 *
 * Both the string should have
 * 1.same length
 * 2.same no of chars
 * 3.the ordering of the chars could be diff
 */
fun main() {
    val permutation = Permutation()
    println("is permutation: ${permutation.solve("mom", "omm")}")
    println("is permutation: ${permutation.solve1("mom", "omm")}")
}

private class Permutation {

    /**
     * Using IntArray
     *
     * Get length of both strings len1 and len2
     * If len1 != len2 return false
     * else if lengths are the same
     *      Create charArray1 and charArray2 of size = 256
     *      -The ascii value of the char will act as the index to the charArray
     *
     *      Iterate charArray 0..len1
     *          Get ascii value of char at i in str1 and str2, ascii1 and ascii2
     *          Increment the count in charArray1 and charArray2 based on ascii1 and ascii2 index
     *
     *      Check for the number of occurrence of each char
     *          if all matches return true
     *          else return false
     *
     * Time complexity O(n)
     */
    fun solve(str1: String, str2: String): Boolean {
        val size = 256
        val len1 = str1.length
        val len2 = str2.length

        if (len1 != len2) return false

        val charArray1 = IntArray(size)
        val charArray2 = IntArray(size)

        for (i in 0 until len1) {
            val c1 = str1[i]
            val c2 = str2[i]
            val index1 = c1.toInt()
            val index2 = c2.toInt()
            charArray1[index1] = charArray1[index1]+1
            charArray2[index2] = charArray2[index2]+1
        }

        for (i in 0 until size) {
            if (charArray1[i] != charArray2[i])
                return false
        }

        return true
    }

    /**
     * Using sorting
     *
     * Get lengths of both the strings len1 and len2
     * if len1 != len2 return false
     * else if length are same
     *      convert each string to char array
     *      sort the chars
     *
     *      Iterate i 0..len1
     *          if all chars are same return true
     *          else return false
     *
     * Time complexity: O(nlogn)
     */
    fun solve1(str1: String, str2: String): Boolean {
        val len1 = str1.length
        val len2 = str2.length

        if (len1 != len2) return false

        val charArray1 = str1.toCharArray()
        val charArray2 = str2.toCharArray()

        charArray1.sort()
        charArray2.sort()

        for (i in 0 until len1) {
            if (charArray1[i] != charArray2[i]) return false
        }

        return true
    }
}