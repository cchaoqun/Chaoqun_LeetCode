package Sort.sort0528;

/**1640. 能否连接形成数组
 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。

 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。



 示例 1：

 输入：arr = [85], pieces = [[85]]
 输出：true
 示例 2：

 输入：arr = [15,88], pieces = [[88],[15]]
 输出：true
 解释：依次连接 [15] 和 [88]
 示例 3：

 输入：arr = [49,18,16], pieces = [[16,18,49]]
 输出：false
 解释：即便数字相符，也不能重新排列 pieces[0]
 示例 4：

 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 输出：true
 解释：依次连接 [91]、[4,64] 和 [78]
 示例 5：

 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 输出：false


 提示：

 1 <= pieces.length <= arr.length <= 100
 sum(pieces[i].length) == arr.length
 1 <= pieces[i].length <= arr.length
 1 <= arr[i], pieces[i][j] <= 100
 arr 中的整数 互不相同
 pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/28-12:55
 */

public class LC1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] map = new int[101];
        //将arr[i]的下标 放在map[arr[i]]
        for(int i=0; i<arr.length; i++){
            map[arr[i]] = i;
        }
        int len = 0;
        //遍历每个数组
        for(int[] cur:pieces){
            //当前数组的长度
            len = cur.length;
            //当前数组第一个数字
            int start = cur[0];
            //当前第一个数字在arr中的下标
            int index = map[start];
            //在arr中从index开始遍历len个数字 查看是否全部和cur[]中的数字匹配
            int i=index;
            //这里判断条件还要加上下标不越界
            for(; i<index+len && i<arr.length; i++){
                if(arr[i]!=cur[i-index]){
                    return false;
                }
            }
            //如果没有遍历到len个数字 说明已经到达arr的尾部, 同样不能完成
            if(i<index+len){
                return false;
            }
        }
        return true;
    }
}
