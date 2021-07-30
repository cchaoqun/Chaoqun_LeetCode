package JZOffer.review;

/**剑指 Offer 61. 扑克牌中的顺子
 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。



 示例 1:

 输入: [1,2,3,4,5]
 输出: True


 示例 2:

 输入: [0,0,1,2,5]
 输出: True


 限制：

 数组长度为 5

 数组的数取值为 [0, 13] .
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/30-14:21
 */

public class jz61 {
    public boolean isStraight(int[] nums) {
        /**
         5张牌中最小的min和最大的max的差应该<=4 (不考虑0) 且没有重复
         有0的情况只有0重复
         如果出现了除了0之外的重复则不行
         */
        int min = 14;
        int max = 1;
        int[] visited = new int[14];
        for(int i:nums){
            if(i==0){
                continue;
            }
            //除了0以外的重复一定不行
            if(visited[i]==1){
                return false;
            }
            visited[i] = 1;
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        //最大最小差可以<=4 因为0可以补上左右差的部分以及中间的部分
        return max-min<=4;

    }
}
