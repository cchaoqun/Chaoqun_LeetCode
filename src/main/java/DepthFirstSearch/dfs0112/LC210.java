package DepthFirstSearch.dfs0112;

import java.util.*;

/*
 * @Description: 210. 课程表 II
现在你总共有 n 门课需要选，记为0到n-1。
在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程1 ，
我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
*
示例1:
输入: 2, [[1,0]]
输出: [0,1]
解释:总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
*
示例2:
输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释:总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。
并且课程 1 和课程 2 都应该排在课程 0 之后。
因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。
*
说明:
输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
*
提示:
这个问题相当于查找一个循环是否存在于有向图中。
如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过BFS完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 11:11
 */
public class LC210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));

    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //入度数组,保存每门课程的入度
        //inDegree[i] 代表课程i的入度
        int inDegree[] = new int[numCourses];
        //课程依赖关系的HashMap<Integer,List<Integer>> <课程i，依赖课程i的课程集合>
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //通过先决条件初始化入度数组和课程依赖关系
        for(int[] relate:prerequisites){
            //当前课程,被依赖的课程
            int curr = relate[1];
            //依赖的课程 relate[1]->relate[0]
            int next = relate[0];
            //更新入度数组
            inDegree[next]++;
            //更新依赖关系
            if(!adj.containsKey(curr)){
                adj.put(curr,new ArrayList<>());
            }
            adj.get(curr).add(next);
        }
        //遍历入度数组
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                //将入度==0的课程入队
                queue.offer(i);
            }
        }
        //BFS
        //统计出队课程数
        int count = 0;
        //拓扑排序
        int[] res = new int[numCourses];
        while(!queue.isEmpty()){
            //出队
            int temp = queue.poll();
            res[count++] = temp;
            //最后一个课程没有后续课程,遍历到这则退出循环,否则后面会出现NullPonterException
            if(!adj.containsKey(temp)){
                continue;
            }
            //更新依赖该课程的后续数组的入度
            for(int course:adj.get(temp)){
                inDegree[course]--;
                //如果更新后的入度==0则入队
                if(inDegree[course]==0){
                    queue.offer(course);
                }
            }
        }
        if(count==numCourses){
            return res;
        }else{
            return (new int[]{});
        }

    }
}
