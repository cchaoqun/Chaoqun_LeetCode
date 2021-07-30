package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-16:20
 */

public class jz56_II {
    public int singleNumber(int[] nums) {
        /**
         统计所有位上的1的个数, 保存到32大小的数组中
         将每个num对应位上的数+到数组对应的位置
         每个位置%3得到的就是出现一次的那个数的二进制表示
         */
        int[] bits = new int[32];
        for(int num : nums){
            for(int i=0; i<32; i++){
                bits[31-i] += num & 1;
                num>>>=1;
            }
        }
        int res = 0, mod = 3;
        for(int i=0; i<=31; i++){
            res<<=1;
            int cur = bits[i]%mod;
            res |= cur;
        }
        return res;

    }
}
