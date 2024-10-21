import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试用例设计的总体原则:
 * 1. 等价类划分: 将输入数据划分为有效等价类和无效等价类,确保覆盖各种情况。
 * 2. 边界值分析: 测试边界条件,如最小/最大人数,无不喜欢关系,所有人互相不喜欢等。
 * 3. 错误推测: 根据经验设计一些可能导致程序出错的特殊输入。
 * 4. 场景测试: 模拟实际应用中可能出现的各种场景。
 */
public class L2022211901_9_Test {

    /**
     * 测试目的: 验证示例1的正确性
     * 测试用例: n = 4, dislikes = {{1,2},{1,3},{2,4}}
     * 预期结果: true (可以分成两组)
     */
    @Test
    public void testPossibleBipartition_Example1() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的: 验证示例2的正确性
     * 测试用例: n = 3, dislikes = {{1,2},{1,3},{2,3}}
     * 预期结果: false (无法分成两组)
     */
    @Test
    public void testPossibleBipartition_Example2() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1,2},{1,3},{2,3}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的: 验证示例3的正确性
     * 测试用例: n = 5, dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}}
     * 预期结果: false (无法分成两组)
     */
    @Test
    public void testPossibleBipartition_Example3() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的: 验证没有不喜欢关系时的情况
     * 测试用例: n = 5, dislikes = {}
     * 预期结果: true (可以任意分组)
     */
    @Test
    public void testPossibleBipartition_NoDislike() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的: 验证所有人都互相不喜欢的情况
     * 测试用例: n = 4, dislikes = {{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}
     * 预期结果: false (无法分成两组)
     */
    @Test
    public void testPossibleBipartition_AllDislike() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }
}