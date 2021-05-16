package GreedyAlgorithm.greedy0429;

import java.util.ArrayList;
import java.util.List;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 *
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 *
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 *
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 *
 *
 *
 * 示例 1：
 *
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 *
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 *
 *
 * 提示：
 *
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/29-16:58
 */

public class LC1769 {
    public int[] minOperations(String boxes) {
        char[] box = boxes.toCharArray();
        //保存所有1所在字符串中的下标
        List<Integer> list = new ArrayList<>();
        //获取所有1所在的位置下标
        for(int i=0; i<box.length; i++){
            if(box[i]=='1'){
                list.add(i);
            }
        }
        int[] answer = new int[box.length];
        for(int i=0; i<box.length; i++){
            //计算每个1移动到当前位置所需的步数
            for(int j=0; j<list.size(); j++){
                answer[i]+=Math.abs(list.get(j)-i);
            }
        }
        return answer;
    }
}

class LC1769_M2{
    public int[] minOperations(String boxes){
        int[] answer = new int[boxes.length()];
        //第一个盒子左边盒子有球(包括盒子自己)的数量
        int left = 0;
        //第一个盒子右边盒子有球的数量
        int right = 0;
        //第一个盒子的操作数
        int total = 0;
        if(boxes.charAt(0)=='1'){
            left++;
        }
        for(int i=1; i<boxes.length(); i++){
            if(boxes.charAt(i)=='1'){
                //0位置右边有球盒子的数量
                right++;
                //0位置右边每个有球盒子到0位置的操作数=i-0=i
                total += i;
            }
        }
        //第一个盒子的操作数
        answer[0] = total;
        //根据前一个盒子的操作数, 计算下一个盒子的操作数
        for (int i = 1; i < boxes.length(); i++) {
            //当前盒子相比于之前盒子
            //i-1个盒子左边的球都需要在移动到i-1位置后,再向右移动一个位置才能到i位置
            //i-1个盒子右边的球都需要向右移动一个位置
            total = total+left-right;
            if(boxes.charAt(i)=='1'){
                //当前位置为'1', 左边盒子数量+1, 右边盒子数量-1
                left++;
                right--;
            }
            answer[i] = total;
        }
        return answer;
    }
}
