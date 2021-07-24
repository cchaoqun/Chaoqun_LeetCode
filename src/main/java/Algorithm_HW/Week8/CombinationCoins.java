package Algorithm_HW.Week8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/** number of different conis (1,5,10, 15, 25), all possible ways to pay for a target
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-12:01
 *
 *

 *
 *
 *
 *
 */

public class CombinationCoins {

    @Test
    public void test(){
        int[] coins = new int[]{1,2,5,10, 25};
        int target = 10;
        List<List<Integer>> res = getPermutation(coins, target);
        System.out.println(res);
    }

    /**
     * 每层加一种硬币
     * @param coins
     * @param target
     * @return
     */
    public List<List<Integer>> getPermutation(int[] coins, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(coins==null || coins.length==0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        int index = 0;
//        backtrackOneKindPerLevel(coins, target, index, path, res);
//        backtrackOneCoinPerLevel(coins, target, index, path, res);
        backtrackAllCoinPerLevel(coins, target, index, path, res);
        return res;
    }

    /**
     *
     * @param coins
     * @param target
     * @param index 当前层加的硬币在coins数组中的索引
     * @param path 当前已经加的硬币的集合
     * @param res   所有可能的情况的解


    这种解法我们对于每层的硬币都是考虑先不选 再在保证不超过target的情况下 选1,2,3,4...个coins[index]
    所以解的顺序是先考虑coins[]后面的情况再考虑前面出现的元素
    [[10],
    [5, 5],
    [2, 2, 2, 2, 2],
    [1, 2, 2, 5],
    [1, 1, 2, 2, 2, 2],
    [1, 1, 1, 2, 5],
    [1, 1, 1, 1, 2, 2, 2],
    [1, 1, 1, 1, 1, 5],
    [1, 1, 1, 1, 1, 1, 2, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
     */
    private void backtrackOneKindPerLevel(int[] coins, int target, int index, List<Integer> path, List<List<Integer>> res){
        //所有的硬币已经收集完了
        if(index== coins.length){
            //所有硬币的和刚好等于target就是一个解
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            //无论如何都return
            return;
        }
        //当前加的是coins[index] 所有的加法有count种 count*coins[index]<=target
        for(int count=0; count*coins[index]<=target; count++){
            //加count个coins[index]到path
            for(int i=0; i<count; i++){
                path.add(coins[index]);
            }
            //下一层
            backtrackOneKindPerLevel(coins, target-count*coins[index], index+1, path, res);
            //回到这一层删除掉之前加的count个coins[index]
            for(int i=0; i<count; i++){
                path.remove(path.size()-1);
            }

        }

    }

    /**
     *
     * @param coins
     * @param target
     * @param index 对于coins[]中index位置的coin 每一层选择加或不加, 加了下一层还可以加, 不加下一层不能加之前加过的coin
     * @param path
     * @param res
    解的结果按照coins[]中出现的顺序[排列, 验证了我们总是选择完了一种硬币以后就不再考虑这个硬币了
    [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 2, 2],
    [1, 1, 1, 1, 1, 5],
    [1, 1, 1, 1, 2, 2, 2],
    [1, 1, 1, 2, 5],
    [1, 1, 2, 2, 2, 2],
    [1, 2, 2, 5],
    [2, 2, 2, 2, 2],
    [5, 5],
    [10]]
     */
    private void backtrackOneCoinPerLevel(int[] coins, int target, int index, List<Integer> path, List<List<Integer>> res){
        //所有的硬币已经收集完了
        if(index== coins.length){
            //所有硬币的和刚好等于target就是一个解
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            //无论如何都return
            return;
        }

        //选择加coins[index]之前需要确认当前的target大于选择的coins[index]
        if(target-coins[index]>=0){
            // 加 coins[index]
            path.add(coins[index]);
            // target-coins[index] : 总数+coins[index] 剩余目标-coins[index]
            // index: 这一层选了coins[index] 下一层还可以选, 这个硬币还没选完
            backtrackOneCoinPerLevel(coins, target-coins[index], index, path, res);
            path.remove(path.size()-1);
        }
        // 不加 coins[index] 代表这个硬币已经选完了 后面都不能再选了
        backtrackOneCoinPerLevel(coins, target, index+1, path, res);
    }

    /**
     *
     * @param coins
     * @param target
     * @param index 代表这一层从index开始考虑每个coin不是选或不选 而是只要能选就选, 每层只考虑当前层可以选的元素能加的都加进去
     *              index代表的是一个挡板, 包括挡板在内后面的元素对我都是可见的但是index之前的都被板隔起来了就不能再选了
     * @param path
     * @param res
    这里每层都考虑[index:]范围内的元素, 每个元素只要可以加都加进去, 并且下一层还可以加,
    但是如果这个元素不加, 我们只是考虑这一层后面还可以加的元素,
    所以对于每个元素没有不加这个选项, 能加就加进去然后进入下一层 下一层还可以加这个元素
                                如果不能加, 就考虑当前层的其他元素
    所以本质上也是吧一个元素加完了以后开始考虑下一个元素
    这里的收集解的条件是target==0 而不是 index==coins.length
        因为我们只考虑了coins数组范围内可以考虑的元素 选择coins[i] 下一层index还是等于i
                                                coins[i] 不能选 我们继续考虑这一层下一个可以考虑的元素coins[i+1] 但是i始终<coins.length
    [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1, 1, 1, 2],
    [1, 1, 1, 1, 1, 1, 2, 2],
    [1, 1, 1, 1, 1, 5],
    [1, 1, 1, 1, 2, 2, 2],
    [1, 1, 1, 2, 5],
    [1, 1, 2, 2, 2, 2],
    [1, 2, 2, 5],
    [2, 2, 2, 2, 2],
    [5, 5],
    [10]]
     */
    private void backtrackAllCoinPerLevel(int[] coins, int target, int index, List<Integer> path, List<List<Integer>> res){
        //所有硬币的和刚好等于target就是一个解,
        if(target==0){
            res.add(new ArrayList<>(path));
            //无论如何都return
            return;
        }
        //这一层考虑的是包括index在内的所有 [index:]范围内的元素
        for(int i=index; i< coins.length; i++){
            //保证可选
            if(target-coins[i]>=0){
                //coins[i] 只要能选就选
                path.add(coins[i]);
                // target-coins[index] : 总数+coins[i] 剩余目标-coins[i]
                // index: i 这一层选了coins[i] 下一层还可以选, 这个硬币还没选完
                backtrackAllCoinPerLevel(coins, target-coins[i], i, path, res);
                path.remove(path.size()-1);
            }
        }
    }

}
