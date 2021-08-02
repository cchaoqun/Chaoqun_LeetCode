package Interview;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/31-10:55
 */

public class I0101 {
    public boolean isUnique(String astr) {
        /**
         每一个字符代表32位上的一个位, 出现了就标为1
         先将当前字符-'a'代表从低位到高位的pos
         这个位代表 1<<(curChar - 'a')
         将这个数与mask & 运算, 如果得到的不是0, 说明这个位上是1 代表这个字符出现了 所以 重复
         如果是0 说明这个位置上之前没出现过, 将mask^(1<<(curChar-'a'))等于将这个1放到mask对应的位置上
         如果遍历完没有return false 说明没有重复

         O()
         遍历一遍字符, O(n)
         对于每个字符 计算了对应的位置 O(1)
         & 运算, O(1)
         ^ 运算, O(1)
         O(n)
         */
        int mask = 0;
        for(char c : astr.toCharArray()){
            int cur = c-'a';
            if((mask & (1<<cur))!=0){
                return false;
            }
            mask ^= (1<<cur);
        }
        return true;
    }
}
