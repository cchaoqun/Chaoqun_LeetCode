package DepthFirstSearch.dfs0112;

import java.util.*;

/*
 * @Description: 207. 课程表
你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，
我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
*
示例 1:
输入: 2, [[1,0]]
输出: true
解释:总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
*
示例 2:
输入: 2, [[1,0],[0,1]]
输出: false
解释:总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；
并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

提示：
输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <=numCourses <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 9:40
 */
public class LC207 {
    public static void main(String[] args) {
        int[][] course = new int[][]{
                {3,0}, {3,1}, {4,1}, {4,2}, {5,3}, {5,4}
        };
        boolean res = canFinish(6, course);
        System.out.println(res);
    }

    //拓扑排序
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //保存每个结点的入度的数组,每个下标对应一门课,下标对应元素为这门课的入度
        int[] inDegree = new int[numCourses];
        //课程之间的依赖关系,对于每门课,后续依赖这门课的课程有哪些
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //通过先决条件,初始化入度数组与依赖关系map
        for(int[] relate:prerequisites){
            //relate[1] -> relate[0] [1]在[0]之前上
            int curr = relate[1];
            int next = relate[0];
            //更新入度
            inDegree[next]++;
            //更新依赖关系map
            if(!adj.containsKey(curr)){
                adj.put(curr,new ArrayList<>());
            }
            //将next放入adj中以curr为Key的value的List<Integer>中
            adj.get(curr).add(next);
        }
        //遍历入度数组
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                //将入度为0的课程入队
                queue.offer(i);
            }
        }
        //当队列不为空
        //记录出队的课程个数
        int count = 0;
        while(!queue.isEmpty()){
            //出队一个课程
            int temp = queue.poll();
            count++;
            //遍历该课程的后续课程
            if(!adj.containsKey(temp)){
                continue;
            }
            //更新依赖该课程的课程入度-1
            for(int course:adj.get(temp)){
                inDegree[course]--;
                //判断该课程的入度是否为减为0,减为0则入队
                if(inDegree[course]==0){
                    queue.offer(course);
                }
            }
        }
        return count==numCourses;
//        //遍历入度数组,如果还存在入度!=0的课程,则return false
//        for(int i=0; i<inDegree.length; i++){
//            if(inDegree[i]!=0){
//                return false;
//            }
//        }
//        return true;
    }
}
