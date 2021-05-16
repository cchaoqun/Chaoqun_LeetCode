package GreedyAlgorithm.greedy0428;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 *
 * 注意：
 *
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *
 *
 * 示例 1：
 *
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 *
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 *
 *
 * 提示：
 *
 * 1 <= commands.length <= 104
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 104
 * -3 * 104 <= xi, yi <= 3 * 104
 * 答案保证小于 231
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/28-17:18
 */

public class LC874 {
    public static void main(String[] args) {
        int[] commands = {-2,8,3,7,-1};
        int[][] obstacles = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        int max = robotSim(commands, obstacles);
        System.out.println(max);

    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        //将障碍物变成字符串放入set判断到达的位置是否为障碍物

        Set<String> ob = new HashSet<>();
        for(int i=0; i<obstacles.length; i++){
            //格式为 "x,y"
            ob.add(obstacles[i][0]+","+obstacles[i][1]);
        }
        //0 北
        //1 西
        //2 南
        //3 东
        int[][] direction = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        //-2 (index+1)%4
        //-1 (index-1+4)%4
        //代表当前机器人的位置
        int[] pos = new int[2];
        //当前的方向
        int dire = 0;
        //最大距离
        int maxDis = 0;
        for(int i=0; i<commands.length; i++){
            //当前指令
            int cur = commands[i];
            //当前指令为改变方向
            if(cur<0){
                //遇到-2向左转90 direction[0-3] = 北 西 南 东 向左为dire+1 % 4
                //遇到-1向右转90 direction[0-3] = 北 西 南 东 向右为dire+3 % 4
                dire = cur==-2?(dire+1)%4 : (dire-1+4)%4;
            }else{
                //需要在X或Y对应坐标的改变
                int offsetX = direction[dire][0]*cur;
                int offsetY = direction[dire][1]*cur;
                //每走一步的大小 -1 || 1
                int move = 0;
                //需要走的步数 为offset的绝对值
                int count = 0;
                //X改变
                if(offsetX!=0){
                    //-1 || 1
                    move = offsetX/(Math.abs(offsetX));
                    //需要走多少个move
                    count = Math.abs(offsetX);
                    while(count>0){
                        //走一步
                        pos[0]+=move;
                        //如果当前位置为障碍物退回去一步
                        if(ob.contains(pos[0]+","+pos[1])){
                            pos[0]-=move;
                            break;
                        }
                        count--;
                    }
                }else{
                    //同理Y改变
                    move = offsetY/(Math.abs(offsetY));
                    count = Math.abs(offsetY);
                    while(count>0){
                        pos[1]+=move;
                        if(ob.contains(pos[0]+","+pos[1])){
                            pos[1]-=move;
                            break;
                        }
                        count--;
                    }
                }
            }
            //每个指令结束更新最大值
            maxDis = Math.max(maxDis, pos[0]*pos[0]+pos[1]*pos[1]);
        }
        return maxDis;
    }
}
