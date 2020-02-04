package crackingthecodinginterview.kotlincode.chapter1

/**
 * Check if the string contains all unique chars
 */
fun main() {

    val sol = IsUnique()
    println("using distinct method: ${sol.solve("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")}")
    println("using bit vector: ${sol.solve1("abcdefghijklmnopqrstuvwxyz")}")
    println("using bit vector: ${sol.solve2("abcdefghijklmnopqrstuvwxyz")}")
}

private class IsUnique {

    /**
     * Using bit vector
     *
     * Iterate through string to get a char c at a time
     *      get c's ascii value and subtract it 'a' ascii value to get the bit which needs to be set to 1
     *      if the bit is already set to 1 return false
     *      else set the bit to 1
     *
     * Time complexity O(n)
     */
    fun solve(str: String): Boolean {
        var checker: Int = 0
        for (i in str.indices) {
            val bit = str.get(i) - 'a'
            if (checker.and(1 shl bit) > 0) return false
            checker = checker.or(1 shl bit)
        }
        return true
    }

    /**
     * Using sorting
     *
     * Convert the string to charArray
     * Sort the charArray
     * Iterate through charArray 0..len-2
     *      compare i and i+1 index
     *      if equal return false
     * return true
     *
     * Time complexity: O(nlogn)
     */
    fun solve1(str: String): Boolean {
        val charArray = str.toCharArray()
        charArray.sort()
        for (i in 0..str.length-2) {
            if (charArray[i] == charArray[i+1])
                return false
        }
        return true
    }

    /**
     * Using distinct method (comparing lengths)
     *
     * Convert the string to charArray
     * Get list of all unique (ul) chars
     * return ul.size == string.length
     *
     * Time complexity: O(nlogn)
     */
    fun solve2(str: String): Boolean {
        return str.toCharArray().distinct().size == str.length
    }


}