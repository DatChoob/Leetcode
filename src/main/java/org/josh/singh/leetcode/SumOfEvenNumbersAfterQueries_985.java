package org.josh.singh.leetcode;

/**
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 * <p>
 * <p>
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * <p>
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class SumOfEvenNumbersAfterQueries_985 {


    /**
     * Runtime: 4 ms, faster than 97.05% of Java online submissions for Sum of Even Numbers After Queries.
     * Memory Usage: 46.9 MB, less than 100.00% of Java online submissions for Sum of Even Numbers After Queries.
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] returnArray = new int[A.length];
        int currentEvenSum = 0;
        for (int i : A) {
            if (i % 2 == 0) currentEvenSum += i;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (A[query[1]] % 2 == 0) currentEvenSum -= A[query[1]];
            A[query[1]] += query[0];
            if (A[query[1]] % 2 == 0) currentEvenSum += A[query[1]];
            returnArray[i] = currentEvenSum;
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] results = new SumOfEvenNumbersAfterQueries_985().sumEvenAfterQueries(A, queries);
        for (int i : results)
            System.out.println(i);
    }

}
