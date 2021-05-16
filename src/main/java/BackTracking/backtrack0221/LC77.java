package BackTracking.backtrack0221;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 11:52
 */
public class LC77 {

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4,2);
        System.out.println(res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //元素是访问过
        boolean[] isVisited = new boolean[n];
        //递归
        dfs(n,k,1,res,path,isVisited);
        return res;
    }
    public static void dfs(int n, int k, int index, List<List<Integer>> res, List<Integer> path, boolean[] isVisited){
        //返回条件 path元素个数等于k
        if(path.size()==k){
            //返回一个path的拷贝,全过程path只有一份
            res.add(new ArrayList<>(path));
            return;
        }
        //如果当前路径中的元素个数 + 剩余可以添加的元素个数已经<k,后续不可能构成k个元素的组合,直接剪枝
        //*****************这样可以将效率从28ms --> 3 ms 优化效率提升50%*****************
        if(path.size()+n-index+1 < k){
            return;
        }
        //每一层起始点事上一次的后一个位置,保证不存在重复
        //*****************优化2 3ms --> 2ms 优化效率提升17%*****************
        //当前path已有的元素个数 path.size()
        //剩余可以搜索的元素n-i+1
        //还需要的个数 k-path.size()
        //剩余可以搜索的个数需要大于还需要的个数
        // n-i+1 >= k-path.size() ==> i<=n+1-(k-path.size())
        for(int i=index; i<=n+1-(k-path.size()); ++i){
            //当前元素未访问过
            if(!isVisited[i-1]){
                //当前元素添加到路径
                path.add(i);
                //当前元素设置成已经访问过
                isVisited[i-1] = true;
                //递归到下一层,起始位置为 i+1
                dfs(n,k, i+1,res,path,isVisited);
                //删除当前层加入的元素
                path.remove(path.size()-1);
                //当前元素置为未访问过
                isVisited[i-1] = false;
            }
        }
    }
}
