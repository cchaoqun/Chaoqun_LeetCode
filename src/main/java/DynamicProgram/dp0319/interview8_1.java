package DynamicProgram.dp0319;
/*
 * @Description: 面试题 08.01. 三步问题
三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

示例1:

 输入：n = 3
 输出：4
 说明: 有四种走法
示例2:

 输入：n = 5
 输出：13
提示:

n范围在[1, 1000000]之间
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/19 19:36
 */
public class interview8_1 {

    public int waysToStep(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        //前三阶台阶
        int n1 = 1;
        //前两阶台阶
        int n2 = 2;
        //前一阶台阶
        int n3 = 4;
        //当前台阶
        int n4 = 1;
        for(int i=3; i<n; ++i){
            //每两个相加的数都可能溢出
            //当前台阶可能从前3阶台阶任意一阶台阶跳过来
            n4 = ((n1 + n2)%1000000007 + n3) % 1000000007;
            //滚动
            n1 = n2;
            n2 = n3;
            n3 = n4;
        }
        return n4;
    }
}
