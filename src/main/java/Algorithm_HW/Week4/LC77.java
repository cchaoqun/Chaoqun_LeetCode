package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-16:42
 */

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int start, int n, int k){
        //已经是一个全排列了
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //这里是一个优化, 如果当前path中已经添加了的数,+ 剩余可以用的数 < k 那么就剪枝
        if(path.size()+n-start+1<k){
            return;
        }
        //每次从start开始 往后找可以的k个数的组合, 保证了不重复
        for(int i=start; i<=n; i++){
            //选择
            path.add(i);
            //下一个数从 i+1开始 因为每个数只能用一次
            backtrack(res, path, i+1, n, k);
            //不选择
            path.remove(path.size()-1);
        }
    }
}
