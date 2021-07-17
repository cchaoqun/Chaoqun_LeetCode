package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/27-10:14
 */

public class Contest_0627_247 {

    @Test
    public void test(){
        int a = 1;
        int b = 2;
        int c = 3;
        int n1 = (a^b);
        int n2 = (a^c);
        int n3 = (b^c);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
        System.out.println("a^b = "+n1);
        System.out.println("a^n1 = "+(a^n1));
        System.out.println("a^b^b = "+(n1^b));
        System.out.println("a^c = "+n2);
        System.out.println("a^c^a = "+(n2^a));
        System.out.println("b^c = "+n3);
        System.out.println("b^c^c = "+(n3^c));
    }

    public long wonderfulSubstrings(String word) {
        //所有字符串的奇偶性
        int[] cnt = new int[1024];
        //我的理解是, 如果一开始刚好出现了两个相同的字符如 "aa", 这个时候 pre=0, 那么 cnt[pre] = cnt[0] = 1,
        // 这是第一次出现全是偶数的情况, 所以是1, 然后这次循环结束了, cnt[pre]++, 下次出现就是2了
        // 比如 ''aabb" 这个时候以全是偶数的情况就有两种 bb或者 aabb (aa前面已经统计过了)
        cnt[0] = 1;
        //前缀和
        int pre = 0;
        //结果
        long res = 0;
        //遍历所有的字符
        for(char c:word.toCharArray()){
            //当前字符 c-'a' 为对应的 0-9 的映射, 移动到对应的位置上
            // [9,8,7,6,5,4,3,2,1,0]
            // [j i h g f e d c b a] a-j 映射到 0-9
            // [0 0 0 0 0 0 0 0 0 0] 对应位置上为1的时候, 说明这个字符出现了奇数次
            pre ^= (1<<(c-'a'));
            //如果这个pre前缀和出现过, 说明当前和上一次出现这个pre之间的所有字符出现了 偶数次
            // 例如abb 第一次出现a pre = 0 ^ 1<<('a'-'a') = 1 这一轮解释前 cnt[pre] = 1
            // 到第二次出现b的时候, a对应的位置还是1因为后来没出现过a
            //                     bb 抵消了因为出现了偶数次
            // 所以当前的pre = 1, 这个是第二次出现pre = 1 所以 res += cnt[pre] 加的其实是 bb这个字符串对应出现的次数
            res += cnt[pre];
            //寻找两个前缀和，其异或结果的二进制数中恰好有一个 1 对应子串的各个字母的个数仅有一个为奇数
            //枚举当前前缀和的每个比特 即 1<<i (i 属于 [0:9])
            for(int i=0; i<10; i++){
                //我们要寻找的是 0-9只有一个位置上有1的数 即 1<<i (i 属于 [0:9])
                //我们希望的是 找到两个前缀和 pre 和 之前出现的一个前缀和(暂时用 x 代替),
                // 这两个前缀和异或的结果如果为 1<<i 那么 从x对应的前缀和到当前位置中间的字符串一定有且仅有一个位置是1 其他位置都是0
                // 因为 pre ^ x = 1<<i  而 我们现在知道 pre 和 1<<i 那么 x = (x^pre)^pre 两个pre 亦或抵消了
                //                                                括号里是 1<<i ^ pre
                res += cnt[pre^(1<<i)];//如果这个前缀和存在, 那么从那个前缀和到现在中间出现的子串就是我们希望找的只有一个字符出现了奇数次, 其他都是偶数次
            }
            //当前这个前缀和出现的次数+1, 下次再出现这个前缀和的时候, 获取对应的结果
            cnt[pre]++;
        }
        return res;
    }
}
