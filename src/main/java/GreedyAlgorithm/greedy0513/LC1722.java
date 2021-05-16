package GreedyAlgorithm.greedy0513;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-21:58
 */

public class LC1722 {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps){
        int ans = 0;
        int n = source.length;
        int len = allowedSwaps.length;
        UnionFind uf = new UnionFind(n);
        //数组的每一层的两个元素都是相互连接的,需要将两个元素变成在一个集合
        for(int[] swap:allowedSwaps){
            uf.union(swap[0], swap[1]);
        }

        //记录target[]每个元素对应的下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            //target[i]对应的LinkedList不存在, 新建一个并且这个方法返回这个新建的LinkedList
            //如果存在直接返回map.get(target[i])的LinkedList
            //target[i]对应的下标i添加进来
            map.computeIfAbsent(target[i], k->new LinkedList<>()).add(i);
        }

        //遍历每一个source[i]
        for(int i=0; i<n; i++){
            //target[]数组中不包括source[i]这个元素一定会造成一个距离
            if(!map.containsKey(source[i])){
                ans++;
                continue;

            }
            //获取source[i]元素在target数组中的下标
            List<Integer> list = map.get(source[i]);
            Iterator<Integer> iterator = list.iterator();
            boolean flag = false;
            //遍历source[i]在target数组中的每个下标index
            while(iterator.hasNext()){
                int index = iterator.next();
                //如果index和i属于一个集合,
                // 说明i和index可以互相连通,并且可以交换使得source[index] = source[i] = target[index]
                //这样使得相同位置元素值相同的个数增加了一个
                if(uf.connected(i,index)){
                    iterator.remove();
                    flag = true;
                    break;
                }
            }
            //source[i]存在于target数组但是不能交换source[i]找到一个对应的target[index]相等
            //所以当前的source[i]造成了距离增加
            if(!flag){
                ans++;
            }
        }

        return ans;

    }

    private static class UnionFind{
        //保存每个元素的根结点
        private int[] parent;
        //保存每个结点的秩(以当前结点为根的数的高度)
        private int[] rank;
        //单独的集合的个数
        private int count;

        public UnionFind(int n){
            count = n;
            parent = new int[n];
            //初始化每个元素都是自身的父节点,即每个结点单独成集合
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            rank = new int[n];
        }

        //路径压缩
        public int find(int x){
            //找到当前x对应的父节点
            if(x==parent[x]){
                return x;
            }
            //返回x对应的根结点
            return parent[x] = find(parent[x]);
        }

        //按秩合并
        //合并x,y两个元素对应的集合
        public void union(int x, int y){
            //找到两个集合对应的根结点
            int rootX = find(x);
            int rootY = find(y);
            //两个元素有相同的根结点说明在同一个集合, 不需要合并
            if(rootX==rootY){
                return;
            }
            //比较两个元素的秩
            if(rank[x]>rank[y]){
                //y的秩小于x, 将x的根结点变成y的根结点
                parent[rootY] = rootX;
            }else{
                //x的秩小于y, 将y的根结点变成x的根结点
                parent[rootX] = rootY;
            }
            //因为上面rank[x]=rank[y]的情况, 也将y根结点变成x根结点的根结点
            //这样的情况下, y的秩需要+1,
            //因为x的树高度为rank[x]接在y根结点下面比原来y树剩余的层数多1
            if(rank[x]==rank[y]){
                rank[y]++;
            }
            //单独的集合数量-1
            count--;
        }
        public int count(){
            return count;
        }
        public boolean connected(int x, int y){
            return find(x)==find(y);
        }

    }
}
