package org.josh.singh.leetcode;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * <p>
 * Example 1:
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * <p>
 * Note:
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class DecodedStringAtIndex_880 {

    public String decodeAtIndex(String S, int K) {
        String decoded = "";
        for (Character c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                decoded = duplicateCurrentDecodedString(decoded, Character.getNumericValue(c));
            } else {
                decoded += c + "";
            }
        }
        return decoded.charAt(K - 1) + "";
    }

    private String duplicateCurrentDecodedString(String decoded, int parseInt) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < parseInt; i++) {
            b.append(decoded);
        }
        return b.toString();
    }

}
