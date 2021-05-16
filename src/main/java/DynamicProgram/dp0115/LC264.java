package DynamicProgram.dp0115;

/*
 * @Description: 264. 丑数 II
 *
编写一个程序，找出第 n 个丑数。
丑数就是质因数只包含2, 3, 5 的正整数。
*
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1是丑数。
n不超过1690。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 20:05
 */
public class LC264 {

    //dp
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        //定义2,3,5分别对应的指针,初始三个指针都指向1
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i=1; i<n; i++){
            //求出三个指针与对应的数相乘得到的最小值就是下一个丑数
            //例如: p2始终与2相乘
            ugly[i] = Math.min(Math.min(ugly[p2]*2,ugly[p3]*3),ugly[p5]*5);
            //哪个指针与对应数字相乘得到的是最小值,就将指针变成这个最小值
            //找出哪个指针需要改变
            if(ugly[i]==ugly[p2]*2){
                p2++;
            }
            if(ugly[i]==ugly[p3]*3){
                p3++;
            }
            if(ugly[i]==ugly[p5]*5){
                p5++;
            }
        }
        //循环结束,得到的就是第n个丑数
        return ugly[n-1];
    }
}
