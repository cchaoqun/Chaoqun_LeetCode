package Algorithm_HW.Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/8-23:52
 */

public class LC1424 {
    //BFS
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        /*
        BFS
        matrix[i][j] = nums.get(i).get(j);
        相同对角线的特点为 i+j 相等 对角线的值依次+1 [0,1,2,3,4,...nums.size()-1]
        起始点 row=0 col=0
        相邻的下一个点为 下面的[row+1, col], 右面的[row, col+1]
        只有每一轮的第一个点会把相邻的两个坐标都放入队列
        其余的只放入 在同一行的下一个元素即 [row, col+1]
        这样避免了判断是否重复
        if(col<nums.get(row).length()) queue.offer(int[]{row, col});
        */
        //总的元素个数
        int total = 0;
        int m = nums.size();
        for(int i=0; i<m; i++){
            total += nums.get(i).size();
        }
        //最后的结果数组
        int[] res = new int[total];
        int index = 0;
        //int[]保存了对应点的下标 nums.get(pos[0]).get(pos[1])
        Queue<int[]> queue = new LinkedList<>();
        //初始顶点入队
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            //row col坐标点
            int row = -1;
            int col = -1;
            //这一个对角线的坐标个数
            int size = queue.size();
            //出队当前对角线的第一个坐标
            int[] pos = queue.poll();
            //对应的值放入结果数组
            res[index++] = nums.get(pos[0]).get(pos[1]);
            //每一轮的第一个元素两个相邻的坐标(下面 && 右边的)都放入
            //下面的
            row = pos[0]+1;
            col = pos[1];
            //保证这个坐标对应的元素存在
            if(row<m && col<nums.get(row).size()){
                //[pos[0]+1, pos[1]]
                queue.offer(new int[]{row, col});
            }
            //右面的
            row = pos[0];
            col = pos[1]+1;
            if(col<nums.get(row).size()){
                //[pos[0], pos[1]+1]
                queue.offer(new int[]{row, col});
            }
            //当前对角线的第一个元素已经遍历完了
            size--;
            //剩余的坐标只将右边的坐标入队(如果存在)
            while(size>0){
                int[] cur = queue.poll();
                //当前坐标对应元素放入结果数组
                res[index++] = nums.get(cur[0]).get(cur[1]);
                //剩余元素只考虑同行的右边的一个元素
                row = cur[0];
                col = cur[1]+1;
                //[cur[0], cur[1]+1]
                if(col<nums.get(row).size()){
                    queue.offer(new int[]{row,col});
                }
                size--;
            }
        }
        return res;
    }
}

class LC1424_M2{
    //桶排序思想
    public int[] findDiagonalOrder(List<List<Integer>> nums){
        /*
        List<List<Integer>> list = new ArrayList<>();
        list.get(k) i+j=k的元素应该放入list中的第k个位置的list中
        遍历一遍nums
            记录元素的总数
            记录i+j的最大值 为一共需要在list中加入多少个list
        逆序遍历nums
        对于每一个元素 val = nums.get(i).get(j) i+j 的值 应该放入 list.get(i+j).add(val)
        最后顺序遍历一遍list依次放入res[]数组即可
         */
        List<List<Integer>> list = new ArrayList<>();
        int total = 0;
        int maxPos = 0;
        int m = nums.size();

        for(int i=0; i<m; i++){
            //获取元素个数总数
            total += nums.get(i).size();
            //获取最大的对角的坐标和
            maxPos = Math.max(maxPos, i+nums.get(i).size()-1);
        }
        //初始化list
        for(int i=0; i<=maxPos; i++){
            //对角线最大坐标和为 maxPos, 需要存在list.get(maxPos)
            list.add(new ArrayList<>());
        }
        //将所有元素放入对应的位置
        //逆序遍历
        for(int i=m-1; i>=0; i--){
            //这样遍历到的每个元素都会按顺序加入到对应坐标和对应的list中的位置
            for(int j=0; j<nums.get(i).size(); j++){
                //坐标和为 i+j的元素放入list.get(i+j)的下一个位置
                list.get(i+j).add(nums.get(i).get(j));
            }
        }
        //从小到大遍历每个位置对应的list 按顺序将元素放入数组
        int index = 0;
        int[] res = new int[total];
        for(int i=0; i<=maxPos; i++){
            //这里的i就是坐标和为i的所有元素集合
            for(int j=0; j<list.get(i).size(); j++){
                res[index++] = list.get(i).get(j);
            }
        }
        return res;
    }
}




























