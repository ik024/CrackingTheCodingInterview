package javacode.chapter1;

public class IsUnique_1_1 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUnique("abcdefghijklmnopqrstuvwxyz"));
    }

}
class Solution {

    /**
     * Using bit vector
     * assumning string contains only a-z
     * explanation - https://stackoverflow.com/questions/42182730/understanding-bit-vector-usage-in-finding-unique-character-in-a-string
     * @param str
     * @return
     */
    public boolean isUnique(String str) {
        //2^32 = 4294967296
        long checker = 0;

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int val = 0;
            if (c <= 'Z' )  val = c - 'A';
            else val = c - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                //setting the bit in checker to 1
                checker |= (1 << val);
            }
        }
        return true;
    }

}
