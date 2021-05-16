package HashTable.hashtable0212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @Description: 187. 重复的DNA序列
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。



示例 1：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]


提示：

0 <= s.length <= 105
s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 20:53
 */
public class LC187 {

    //暴力
    public List<String> findRepeatedDnaSequences(String s) {
        //HashSet存储没有重复的字符串
        HashSet<String> set = new HashSet<>();
        //存储重复的字符的结合
        HashSet<String> res = new HashSet<>();
        for(int i=0; i+9<s.length(); ++i){
            String cur = s.substring(i,i+10);
            if(set.contains(cur)){
                res.add(cur);
            }else{
                set.add(cur);
            }
        }
        return new ArrayList<>(res);
    }

    //*********************未学会*********************
    //Rabin-Karp 算法 = 使用旋转哈希算法实现常数窗口切片。
    //位操作 = 使用掩码实现常数窗口切片。
}
