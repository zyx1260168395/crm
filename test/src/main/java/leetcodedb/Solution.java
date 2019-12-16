package leetcodedb;

import com.sun.media.sound.SoftTuning;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Zyx
 * @date 2019/12/15 22:27
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][]grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(s.maxIncreaseKeepingSkyline(grid));

    }

    //输入：
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //输出: 7
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 >= m && j + 1 >= n) {
                    continue;
                }
                if (i + 1 >= m) {
                    grid[i][j] += grid[i][j + 1];
                } else if (j + 1 >= n) {
                    grid[i][j] += grid[i + 1][j];
                } else {
                    grid[i][j] += grid[i][j + 1] < grid[i + 1][j]?grid[i][j + 1]:grid[i + 1][j];
                }
            }
        }
        return grid[0][0];
    }


    //[ [3, 0, 8, 4],
    //  [2, 4, 5, 7],
    //  [9, 2, 6, 3],
    //  [0, 3, 1, 0] ]
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] mmax = new int[m];
        int[] nmax = new int[n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mmax[i] == 0) {
                    for (int k = 0; k < m; k++) {
                        if (grid[i][k] > mmax[i]) {
                            mmax[i] = grid[i][k];
                        }
                    }
                }
                if (nmax[j] == 0) {
                    for (int k = 0; k < n; k++) {
                        if (grid[k][j] > nmax[j]) {
                            nmax[j] = grid[k][j];
                        }
                    }
                }
                res += Math.min(mmax[i], nmax[j]) - grid[i][j];
            }
        }
        return res;
    }
}

class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
