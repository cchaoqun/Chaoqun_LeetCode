package DynamicProgram.dp0314;
/*
 * @Description: 338. 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * @param null
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/14 20:46
 */
public class LC338 {

//    public int[] countBits(int num) {
//        //dp[i] = number of 1 in number i
//        int[] dp = new int[num+1];
//        dp[0] = 0;
//        for(int i=1; i<num+1; i++){
//            //前一个数为偶数
//            if((i-1)%2 == 0){
//                dp[i] = dp[i-1] + 1;
//            }else{
//                //前一个数为奇数
//                dp[i] = dp[i-1];
//                int pre = i-1;
//                //pre最后一位为1
//                while(((pre)&1)==1){
//                    //1的个数减一
//                    --dp[i];
//                    //pre右移一位
//                    pre >>= 1;
//                }
//                //pre&1 == 0, pre最后一位为0, 此时加上当前数字应该在前一位的基础上加上的1
//                ++dp[i];
//            }
//        }
//        return dp;
//    }

    public int[] countBits(int num){
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i=1; i<num+1; ++i){
            //如果i为even i的最后一位一定是0 则 i>>1不丢失1 并且i&1=0, 因为i最后一位为0
            //  实际上i=even dp[i] = dp[i>>1]
            //如果i为odd i的最后一位一定是1 i>>1丢失了一个 i&1=1
            //  实际上i=even dp[i] = dp[i>>1] + (i&1)
            //所以两种情况可以合并到一种公式
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }

//    public int[] countBits(int num){
//        int[] dp = new int[num+1];
//        dp[0] = 0;
//        for(int i=1; i<num+1; ++i){
//            //y = i&(i-1) 为i去掉了最后一个1后的数字, 在+1就是i所拥有的1的个数
//            dp[i] = dp[(i&(i-1))]+1;
//        }
//        return dp;
//    }
}
