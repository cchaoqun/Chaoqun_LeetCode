package Tree.tree0425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/25-21:21
 */

public class LC1443 {
    //拿到左右苹果所需走的边数
    int edgeCount;
    //标记当前结点是否已经被访问过, 取得两个苹果共同的边可以只计算一次
    boolean[] visited;
    //reverseEdge[i] 表示i的父节点
    int[] reverseEdge;
    public void buildReverseEdge(List<List<Integer>> allEdge, int val){
        //获取所有指向val或者被val指向的结点
        for(int pairVal:allEdge.get(val)){
            //如果当前结点不是0 并且还没被reverse过
            if(pairVal!=0 && reverseEdge[pairVal]==-1){
                //当前结点的父节点为val因为是跟val相关的结点
                //并且初始是从0出发的, 所以顺这个方向构建边
                //所有相反指向的都改变方向
                reverseEdge[pairVal] = val;
                //递归的构建所有边
                buildReverseEdge(allEdge, pairVal);
            }
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.edgeCount = 0;
        this.visited = new boolean[n];
        //allEdge.get(i) = 所有i的父节点和子节点
        List<List<Integer>> allEdge = new ArrayList<>();
        //初始化
        for(int i=0; i<n; i++){
            allEdge.add(new ArrayList<Integer>());
        }
        //获取所有结点的父节点和子节点
        for(int[] i:edges){
            allEdge.get(i[0]).add(i[1]);
            allEdge.get(i[1]).add(i[0]);
        }
        //初始化翻转之后的数组
        reverseEdge = new int[n];
        Arrays.fill(reverseEdge, -1);
        reverseEdge[0] = 0;
        //构建以0为根结点的树
        buildReverseEdge(allEdge, 0);
        //找到苹果结点, 并从苹果结点开始往根结点走,
        visited[0] = true;
        for(int i=1; i<n; i++){
            if(hasApple.get(i)){
                dfs(i);
            }
        }
        //返回不重复的路径中含有的边数*2
        return (edgeCount<<1);
    }

    //从结点i走到到根结点, 同时更新edgeCount和visited数组
    void dfs(int i){
        //遇到一件访问过的结点, 说明从该节点到根结点的路径已经被另一个苹果使用过,
        //可以共享当前结点到根结点的路线
        if(!visited[i]){
            edgeCount++;
            visited[i] = true;
            dfs(reverseEdge[i]);
        }
    }
}
