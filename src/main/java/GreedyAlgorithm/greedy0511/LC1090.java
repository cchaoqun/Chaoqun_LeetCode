package GreedyAlgorithm.greedy0511;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 * 我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。
 *
 * 我们从这些项中选出一个子集 S，这样一来：
 *
 * |S| <= num_wanted
 * 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。
 * 返回子集 S 的最大可能的 和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 *
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * 示例 4：
 *
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * 输出：24
 * 解释：选出的子集是第一项，第二项和第四项。
 *
 *
 * 提示：
 *
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i] <= 20000
 * 1 <= num_wanted, use_limit <= values.length
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/11-21:59
 */

public class LC1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int len = values.length;
        //res[i][0]=value[i]
        //res[i][1]=label[i]
        int[][] res = new int[len][2];
        for(int i=0; i<len; i++){
            res[i][0] = values[i];
            res[i][1] = labels[i];
        }
        //按照value的值从大到小排列
        Arrays.sort(res, new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                return n2[0]-n1[0];
            }
        });
        //统计每个已经用过的label出现的次数
        Map<Integer, Integer> labelCount = new HashMap<>();
        //已经用过的value个数
        int num = 0;
        //已经用过的value总和
        int sum = 0;
        for(int[] cur:res){
            //满足最大个数
            if(num>=num_wanted){
                break;
            }
            //当前value
            int curVal = cur[0];
            //当前label
            int curLab = cur[1];
            //当前label已经用过的次数
            int labUse = labelCount.getOrDefault(curLab,0);
            //还可以用
            if(labUse<use_limit){
                //使用个数
                num++;
                //总和
                sum+=curVal;
                //当前label对应使用的次数
                labelCount.put(curLab, labUse+1);
            }
        }
        return sum;

    }    
}


































