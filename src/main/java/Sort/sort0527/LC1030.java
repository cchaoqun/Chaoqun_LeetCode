package Sort.sort0527;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/27-13:09
 */

public class LC1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows*cols][1];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                res[i*cols+j] = new int[]{i,j};
            }
        }
        Arrays.sort(res, (o1, o2)->(abso(o1,rCenter, cCenter)-abso(o2, rCenter, cCenter)));
        return res;
    }

    public int abso(int[] arr, int r, int c){
        return Math.abs(arr[0]-r)+Math.abs(arr[1]-c);
    }
}

class LC1030_M2{
    //桶排序
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        /*
        0<=rCenter<=rows-1 横向最大距离为 Math.max(rCenter-0, rows-1-rCenter)
        0<=cCenter<=cols-1 纵向最大距离为 Math.max(cCenter-0, cols-1-cCenter)
         */
        int maxDis = Math.max(rCenter, rows-1-rCenter) + Math.max(cCenter, cols-1-cCenter);
        List<List<int[]>> buckets = new ArrayList<>();
        //每个对应的距离创建一个桶(List<int[]>) 存放到指定点相同的数组
        for(int i=0; i<=maxDis; i++){
            buckets.add(new ArrayList<>());
        }
        //遍历每个数组, 相同距离放到对应的桶中
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int[] curArr = {i,j};
                int cur = abso(curArr, rCenter, cCenter);
                buckets.get(cur).add(curArr);
            }
        }
        //一共有rows*cols个数组
        int[][] res = new int[cols*rows][];
        int index = 0;
        //依次取出所有的数组放入结果数组
        for(List<int[]> cur:buckets){
            for(int[] arr:cur){
                res[index++] = arr;
            }
        }
        return res;
    }
    //计算距离
    public int abso(int[] arr, int r, int c){
        return Math.abs(arr[0]-r)+Math.abs(arr[1]-c);
    }
}

class LC1030_M3{
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter){
        int[][] res = new int[rows*cols][2];
        int[] offset = {-1,1};
        int cnt = 0;
        int dist = 0;
        //只关心是否已经遍历所有的坐标, 距离不关心
        while(cnt<rows*cols){
            //dist每次增加1, 每次将dist分成rowDist+colDist, 总和不变, 分别占不同的分量
            //rowDist=0 || colDist=0 只有一种可能因为, row+-0 相同
            for(int rowDist=0; rowDist<=dist; rowDist++){
                int colDist = dist-rowDist;
                //因为取得距离的绝对值, 可能为(row+rowDis)-row 也可能是 row-(row-rowDist)
                for(int i=0; i<2; i++){
                    int row = rCenter+offset[i]*rowDist;
                    for(int j=0; j<2; j++){
                        int col = cCenter+offset[j]*colDist;
                        //在范围内, 不越界 row+col = dist
                        if(inArea(rows, cols, row, col)){
                            res[cnt][0] = row;
                            res[cnt][1] = col;
                            cnt++;
                        }
                        if(colDist==0){
                            break;
                        }
                    }
                    if(rowDist==0){
                        break;
                    }
                }
            }
            //距离增加1
            ++dist;
        }
        return res;
    }

    public boolean inArea(int rows, int cols, int i, int j){
        return 0<=i && i<rows && 0<=j && j<cols;
    }
}































