package Math.math0211;
/*
 * @Description: 223. 矩形面积
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

每个矩形由其左下顶点和右上顶点坐标表示，如图所示。



示例:

输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
说明: 假设矩形面积不会超出 int 的范围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rectangle-area
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 12:12
 */
public class LC223 {



    //交点 EB CH
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //两个矩形的面积
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        //不相交的情况
        if(A>=G || C<=E || D<=F || B>=H){
            return area1+area2;
        }
        //求相交的点
        //左
        int x1 = Math.max(A,E);
        //下
        int y1 = Math.max(B,F);
        //右
        int x2 = Math.min(C,G);
        //上
        int y2 = Math.min(D,H);
        //相交面积
        int intersect = (x2-x1)*(y2-y1);
        return area1+area2-intersect;
    }
}
