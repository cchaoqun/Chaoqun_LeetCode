package DynamicProgram.dp0324;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Description: 638. 大礼包
在LeetCode商店中， 有许多在售的物品。

然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。

现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。

每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。

任意大礼包可无限次购买。

示例 1:

输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
输出: 14
解释:
有A和B两种物品，价格分别为¥2和¥5。
大礼包1，你可以以¥5的价格购买3A和0B。
大礼包2， 你可以以¥10的价格购买1A和2B。
你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
示例 2:

输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
输出: 11
解释:
A，B，C的价格分别为¥2，¥3，¥4.
你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
说明:

最多6种物品， 100种大礼包。
每种物品，你最多只需要购买6个。
你不可以购买超出待购清单的物品，即使更便宜。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/24 19:48
 */
public class LC638 {

    /**
     *
     * @param price 每种商品对应的价格
     * @param special 大礼包.
     * @param needs 每中商品所需要的数量
     * @return
     */
    //List<Integer> 对应某种商品数量的需要, Integer 对应需求的最小花费
    Map<List<Integer>, Integer> map;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //缓存,记忆化搜索
        map= new HashMap<>();
        return dfs(price, special, needs);
    }

    /**
     * needs逐渐减少
     * @param price
     * @param special
     * @param needs
     * @return
     */
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        //如果当前这种需求已经求过,直接返回花费,
        //每种需求对应的最小花费都是一样的
        if(map.containsKey(needs)){
            return map.get(needs);
        }

        //考虑不需要大礼包,全部以每种商品的原价购买所需要的花费
        int res = 0;
        //商品种数
        int kinds = price.size();
        for(int i=0; i<kinds; ++i){
            res += price.get(i)*needs.get(i);
        }
        //对于每种礼包
        for(List<Integer> bag : special){
            //当前状态下每种商品所需要的数量
            List<Integer> curNeed = new ArrayList<>(needs);
            //遍历大礼包的每个商品所含有的数量
            int j;
            for(j=0; j<kinds; ++j){
                //当前第j个商品所需的数量-大礼包含有的数量
                int diff = curNeed.get(j)-bag.get(j);
                //如果大礼包中商品j的数量多余所需的,不符合要求
                if(diff<0){
                    break;
                }
                //对于j而言,符合要求,剩下j商品的需求为diff
                curNeed.set(j, diff);
            }
            //如果当前大礼包满足要求,即没有哪个商品j的数量多余需求量
            if(j==kinds){
                //如果选择当前大礼包,则对应的花费为
                //比较全部以原价购买和购买大礼包的花费中的较小者
                //当前大礼包的价格 bag.get(kinds)+
                //剩余所需商品的花费
                res = Math.min(res, bag.get(kinds)+dfs(price,special, curNeed));
                //将当前需求为needs情况下的最小花费放入map
                map.put(needs, res);
            }
        }
        return res;
    }
}
