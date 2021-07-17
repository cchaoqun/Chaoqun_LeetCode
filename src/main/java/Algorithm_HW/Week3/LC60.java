package Algorithm_HW.Week3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-18:08
 */

public class LC60 {

    @Test
    public void test(){
        int n = 3;
        int k = 1;
        getPermutation(n,k);
    }

    int count;
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        //之前是否访问过
        boolean[] visited = new boolean[n+1];
        //这是第几个全排列
        count = 0;
        backtrack(res, path, visited, n, k);
        return res.get(0);
    }

    private void backtrack(List<String> res, StringBuilder path, boolean[] visited, int n, int k){
        //剪枝, 已经获得了第k个全排列
        if(res.size()>0){
            return;
        }
        //获得了一个全排列
        if(path.length()==n){
            //全排列的数量+1
            count++;
            //如果此时全排列的数量==k, 说明当前的全排列就是第k个
            if(count==k){
                res.add(path.toString());
            }
            return;
        }
        for(int i=1; i<=n; i++){
            //剪枝 说明已经得到了第k个全排列
            if(res.size()>0){
                return;
            }
            //当前位置可以放的是之前没有访问过的数
            if(visited[i]){
                continue;
            }
            //mark visited
            visited[i] = true;
            //当前元素加入到路径
            path.append(i);
            //去到下一层找下一个可以放的元素
            backtrack(res, path, visited, n, k);
            //回溯回来, 删除当前元素, 不选择当前元素
            path.deleteCharAt(path.length()-1);
            //mark unvisited
            visited[i] = false;
        }
    }
}


class LC60_M2{


    private boolean[] visited;
    private int[] fac;
    private int n;
    private int k;


    public String getPermutation(int n, int k){
        this.n = n;
        this.k = k;
        //获取阶乘数组
        getFactorial(n);
        visited = new boolean[n+1];
        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    /**
     *
     * @param index 当前已经选择了元素的个数, 对应剩下了n-1-index个数
     * @param path
     */
    private void dfs(int index, StringBuilder path){
        //index=n 代表之前已经选择了n个数
        if(index==n){
            return;
        }
        //当前选择了一个数后, 所有的分支数,
        // n-1 因为这一层会选择一个数,
        // index 是减去之前选择的数
        // 这样 本层选择了一个数后 剩下了 n-1-index个数, 这n-1-index个数构成的全排列是 (n-1-index)! = fac[n-1-index]
        int count = fac[n-1-index];
        for(int i=1; i<=n; i++){
            //之前访问过 跳过
            if(visited[i]){
                continue;
            }
            //剩下的还需要的全排列的元素个数 是 k
            // 如果当前分支的全排列个数<k 则这个分支可以跳过
            // 减去这个分支的所有全排列个数
            if(count<k){
                k -= count;
                continue;
            }

            path.append(i);
            visited[i] = true;
            dfs(index+1, path);
            //这里没有不选择这个选项, 我们不会回来 而是直接到达了叶子结点,
            // 我们每一层都选了那个保证 count>k的那个选项
            // 否则都跳过了
            return;

        }
    }


    private void getFactorial(int n){
        this.fac = new int[n+1];
        fac[0] = 1;
        for(int i=1; i<=n; i++){
            fac[i] = fac[i-1]*i;
        }
    }
}





























