import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */
class Solution9 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 初始化并查集
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        // 构建邻接表
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair : dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        // 使用颜色数组来标记不同的组，0表示未染色
        int[] color = new int[n + 1];

        // 遍历每个节点，进行染色
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int c, int[] color, List<Integer>[] graph) {
        color[node] = c;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(neighbor, -c, color, graph)) {
                    return false;
                }
            } else if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

}