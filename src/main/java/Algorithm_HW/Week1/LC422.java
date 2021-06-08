package Algorithm_HW.Week1;

import java.util.List;

/**422. 有效的单词方块
 给你一个单词序列，判断其是否形成了一个有效的单词方块。

 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。

 注意：

 给定的单词数大于等于 1 且不超过 500。
 单词长度大于等于 1 且不超过 500。
 每个单词只包含小写英文字母 a-z。


 示例 1：

 输入：
 [
 "abcd",
 "bnrt",
 "crmy",
 "dtye"
 ]

 输出：
 true

 解释：
 第 1 行和第 1 列都是 "abcd"。
 第 2 行和第 2 列都是 "bnrt"。
 第 3 行和第 3 列都是 "crmy"。
 第 4 行和第 4 列都是 "dtye"。

 因此，这是一个有效的单词方块。


 示例 2：

 输入：
 [
 "abcd",
 "bnrt",
 "crm",
 "dt"
 ]

 输出：
 true

 解释：
 第 1 行和第 1 列都是 "abcd"。
 第 2 行和第 2 列都是 "bnrt"。
 第 3 行和第 3 列都是 "crm"。
 第 4 行和第 4 列都是 "dt"。

 因此，这是一个有效的单词方块。


 示例 3：

 输入：
 [
 "ball",
 "area",
 "read",
 "lady"
 ]

 输出：
 false

 解释：
 第 3 行是 "read" ，然而第 3 列是 "lead"。

 因此，这 不是 一个有效的单词方块。

 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/1-15:51
 */

public class LC422 {
    public boolean validWordSquare(List<String> words) {
        /*
        有效的单词方块 对应的二维矩阵以主对角线对称
        arr[i][j] = arr[j][i]

         */
        //遍历每个字符串
        for(int i=0; i<words.size(); i++){
            //当前字符串
            String cur = words.get(i);
            //遍历每个字符
            for(int j=0; j<cur.length(); j++){
                //当前字符等价于在二维数组中的 [i][j] 位置
                //主对角的位置为 [j][i] 等价于words.get(j).chaAt(i)
                //需要保证下标不越界即
                // j<words.size() &&i<words.get(j).length()
                if(j>=words.size() || i>=words.get(j).length()){
                    //下标越界的情况
                    return false;
                }
                //对称位置字符不相等的情况
                if(cur.charAt(j)!=words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;

    }
}
