package BinarySearch.bs0108;

import java.util.Arrays;

/*
 * @Description: 174. 地下城游戏

一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由M x N 个房间组成的二维网格。
我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数
（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），
要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快到达公主，骑士决定每次只向右或向下移动一步。

编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，
则骑士的初始健康点数至少为 7。

-2 (K)	-3	    3
-5	   -10	    1
10	    30	   -5 (P)

说明:
骑士的健康点数没有上限。
任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dungeon-game
 * @param null
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 16:42
 */
public class Hard_LC174___ {
    public static void main(String[] args) {
        int[][] dungeon = new int[3][3];
        dungeon[0] = new int[]{-2,-3,3};
        dungeon[1] = new int[]{-5,-10,1};
        dungeon[2] = new int[]{10,30,-5};
        int res = calculateMinimumHP(dungeon);
//        System.out.println(res);
    }

    //
    /*
     * @Description: dp 从右下到左上
     * dp[i][j] 表示进入i,j位置需要的最小血量,
     * a表示原来的数组a[i][j]表示进入房间发生的血量交换
     * x表示进入i,j前的血量(其实就是dp[i][j])
     * 从最右下角的格子开始
     *  需要满足的条件
     *      1.x>=1 保证进入房间前有血量
     *      2.x+a[i][j]>=1 保证进入房间发生血量交换后血量仍然>=1
     *      3.x+a[i][j]>=min(dp[i+1][j], dp[i][j+1]) 保证进入当前房间后 进入下一步之前的血量满足两个选择之间小的那个
     *      4.总和来看,x=max(1,min(dp[i+1][j], dp[i][j+1]) - a[i][j])=dp[i][j]
     * 创建的dp矩阵大小为 m+1 n+1因为最右列和最下行的dp需要借助往右一列和往下一行的数据
     * 将无效的这些值赋值为Integer.max,这样这些选择一定大于另一个,一定不会被选到不影响
     * m,n-1 m-1,n这两个位置需要设置成1,因为在救到公主以后只需要血量>=1即可 实际已经没有下一步
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        //创建dp矩阵
        int[][] dp = new int[m+1][n+1];
        //将初始值全部赋值为Integer.MAX_VALUE
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        //将公主所在的位置的右边和下面一格设置成1
        dp[m-1][n] = 1;
        dp[m][n-1] = 1;
        //开始从右下角向左上角遍历为dp赋值
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                //下一步中所需的最小的血量    下         右
                int minNext = Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = Math.max(1,minNext-dungeon[i][j]);
            }
        }
        System.out.println("dp_Matrix");
        for(int[] row:dp){
            for(int ele:row){
                System.out.printf("%10d\t",ele);
            }
            System.out.println();
        }
        System.out.printf("起始点所需最小血量: %d\n",dp[0][0]);
        return dp[0][0];
    }
}
