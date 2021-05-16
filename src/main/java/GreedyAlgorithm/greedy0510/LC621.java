package GreedyAlgorithm.greedy0510;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 *
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 *
 *
 * 提示：
 *
 * 1 <= task.length <= 104
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-20:07
 */

public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for(char c : tasks){
            taskCount[c-'A']++;
        }

        //按照每个字符出现的次数从小到大排序
        Arrays.sort(taskCount);
        //出现最多的字符出现的次数
        int maxTimes = taskCount[25];
        //和出现最多的字符出现次数相同的字符个数
        int maxPresent = 1;
        for(int i=25; i>=1; i--){
            //统计和出现最多的字符出现次数相同的字符个数
            if(taskCount[i]==taskCount[i-1]){
                maxPresent++;
            }else{
                break;
            }
        }
        //出现最多的次数之间至少有n个字符或者有冷却时间,
        //让出现最多的这些字符依次排列在长度为n+1的一行, 然后剩余的用剩下的出现次数较少的字符或者冷却填充
        //不关心那些填充的字符和冷却, 因为出现最多的两个字符之间必须有n个其他的字符或冷却
        //并且出现最多的字符满足, 出现较少的次数的一定也满足
        //出现了maxTimes 就排列maxTimes行, 除去最后一行结束行, 上面有maxTimes-1行, 每行有n+1的长度
        //最后一行只出现出现最多次数的那些字符个数, 并且为这些字符最后一次出现,
        //格子的数量就是需要的时间
        int res = (maxTimes-1)*(n+1)+maxPresent;
        // res有可能小于,但是即便n=0, 最短的时间也是每个任务出现一次长度=数组的长度
        return Math.max(res, tasks.length);
    }
}


































