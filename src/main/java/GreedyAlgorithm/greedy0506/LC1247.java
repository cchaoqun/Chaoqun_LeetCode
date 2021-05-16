package GreedyAlgorithm.greedy0506;

/**
 * 1247. 交换字符使得字符串相同
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * 示例 2：
 *
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 * 示例 3：
 *
 * 输入：s1 = "xx", s2 = "xy"
 * 输出：-1
 * 示例 4：
 *
 * 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'。
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/6-22:14
 */

public class LC1247 {

    public int minimumSwap(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int xy = 0;
        int yx = 0;
        for(int i=0; i<arr1.length; i++){
            //对应位置字符相同不需要交换
            if(arr1[i]==arr2[i]){
                continue;
            }
            //arr1[i]='x' arr2[i]='y' 组成了一对 xy
            if(arr1[1]==120){
                xy++;
            }else{
                //arr1[i]='y' arr2[i]='x' 组成了一对 yx
                yx++;
            }
        }
        /**
         * 假设 有M组xy N组yx
         * M+N一定为偶数 否则一共存在奇数个x 和 y 无法两两交换
         * MN 一定同奇同偶
         * MN 都是偶数 则 对应两组 xy 在两个字符串中情况为 arr1=xx arr2=yy, 需要 交换arr1[0] arr2[1] 得到 yx yx
         *      同理yx  yy xx 交换了以后以后变成 xy xy  需要 (M+N)/2
         * MN 都是奇数 各取出一组 xy 和 yx 变成 yy xx 再变成xy xy 需要两步
         *  剩下 M-1 N-1为偶数组 xy yx 需要交换 (M-1)/2 (N-1)/2 + 2
          */
        return ((xy+yx)&1)==1? -1: (xy+1)/2 + (yx+1)/2;
    }
}
