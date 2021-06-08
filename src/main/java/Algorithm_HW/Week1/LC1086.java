package Algorithm_HW.Week1;

import java.util.Arrays;

/**1086. 前五科的均分
 给你一个不同学生的分数列表 items，其中 items[i] = [IDi, scorei] 表示 IDi 的学生的一科分数，你需要计算每个学生 最高的五科 成绩的 平均分。

 返回答案 result 以数对数组形式给出，其中 result[j] = [IDj, topFiveAveragej] 表示 IDj 的学生和他 最高的五科 成绩的 平均分。result 需要按 IDj  递增的 顺序排列 。

 学生 最高的五科 成绩的 平均分 的计算方法是将最高的五科分数相加，然后用 整数除法 除以 5 。



 示例 1：

 输入：items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 输出：[[1,87],[2,88]]
 解释：
 ID = 1 的学生分数为 91、92、60、65、87 和 100 。前五科的平均分 (100 + 92 + 91 + 87 + 65) / 5 = 87
 ID = 2 的学生分数为 93、97、77、100 和 76 。前五科的平均分 (100 + 97 + 93 + 77 + 76) / 5 = 88.6，但是由于使用整数除法，结果转换为 88
 示例 2：

 输入：items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
 输出：[[1,100],[7,100]]


 提示：

 1 <= items.length <= 1000
 items[i].length == 2
 1 <= IDi <= 1000
 0 <= scorei <= 100
 对于每个 IDi，至少 存在五个分数
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/1-14:54
 */

public class LC1086 {
    public int[][] highFive(int[][] items) {
        /*
        item[i] = [ID, score]
        res[i] = [IDi, AVG5(score)]
        按IDi升序排列
         */
        //按照ID升序排序, ID相同的按照分数降序排序
        Arrays.sort(items, (o1, o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        //代表当前已经计算了几个学生的最高分数的均分
        int index =0;
        //遍历二维数组
        for(int i=0; i<items.length; ){
            //当前学生的最高五门课程的均分
            int sum = 0;
            //选取当前学生最高的五门课的分数
            //即当前ID开始的第一门到第五门课的分数, 因为相同ID的课程按照分数从高到低排列
            for(int j=i; j<i+5; j++){
                sum += items[j][1];
            }
            //计算5门课的分数
            sum /= 5;
            //将当前计算的学生ID以及均分放入index的位置,
            //index每次都保存下一个应该放入二维数组的位置
            //使用原始数组,从0放入, 遍历结束index表示计算了多少个学生的均分
            //当前计算的学生ID
            items[index][0] = items[i][0];
            //当前计算的学生的最高的5门课的均分
            items[index][1] = sum;
            //下一个学生应该放入二维数组的位置
            index++;
            //找到下一个学生开始的位置
            int j = i;
            //下标在范围内, 并且ID等于当前学生的ID
            while(j<items.length && items[j][0] == items[i][0]){
                j++;
            }
            //如果已经遍历完代表当前学生为最后一个, 跳出循环
            if(j==items.length){
                break;
            }
            //更新下一个学生的第一个位置
            i = j;

        }
        return Arrays.copyOf(items,index);
    }
}
