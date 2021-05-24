package GreedyAlgorithm.greedy0524;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 *
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 *
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 *
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/24-22:29
 */

public class LC1657 {
    /**
     操作1: 字符的顺序不重要, 所有的字符可以按照任意顺序排列
     操作2: 哪个字符有多少次不重要, 任意出现的两个字符出现的次数可以互相交换
     问题抽象成:
     1.不存在字符串独有的字符, 即字符a出现在word1但是不出现在word2
     2.所有出现的字符的出现次数, 不考虑字符, 只考虑次数相同
     word1出现的次数为 1 3 4 5, 只要word2中统计各个字符出现次数按升序排列也为1,3,4,5即可

     */
    public boolean closeStrings(String word1, String word2) {
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        //统计字符出现次数
        for(char c:word1.toCharArray()){
            arr1[c-'a']++;
        }
        for(char c:word2.toCharArray()){
            arr2[c-'a']++;
        }
        //排除存在不同字符的情况
        for(int i=0; i<26; i++){
            if(arr1[i]==0 && arr2[i]>=1){
                return false;
            }
            if(arr2[i]==0 && arr1[i]>=1){
                return false;
            }

        }
        //按出现顺序升序排列
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //如果存在不同则return false;
        for(int i=25;i>=0; i--){
            //后面全部为0, 直接退出循环
            if(arr1[i]==0 && arr2[i]==0){
                break;
            }
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;


    }
}
