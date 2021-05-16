package NumList.List0126;

import java.util.*;

/*
 * @Description: 18. 四数之和
 *
给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，
使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。
*
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/26 21:26
 */
public class LC18 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> list = fourSum(nums,0);

        System.out.println(list);
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n<4){
            return list;
        }
        //对数组进行排序
        Arrays.sort(nums);
        for(int a=0; a<n-3; ++a){
            //保证当前的a对应元素与上一个不同
            if(a>0 && nums[a]==nums[a-1]){
                continue;
            }
            //提前截枝
            //当前a确定后四数之和一定大于target
            if(nums[a]+nums[a+1]+nums[a+2]+nums[a+3]>target){
                //结束当前循环
                break;
            }
            //当前a确定后四数之和一定小于target
            if(nums[a]+nums[n-3]+nums[n-2]+nums[n-1]<target){
                //进入下一次循环
                continue;
            }

            //剩余三数之和的目标
            int temp = target - nums[a];
            for(int b=a+1; b<n-2; ++b){
                //保证当前的b对应元素与上一个不同b
                if(b>a+1 && nums[b]==nums[b-1]){
                    continue;
                }
                //提前截枝
                //当前b确定后三数之和一定大于temp
                if(nums[b]+nums[b+1]+nums[b+2]>temp){
                    //结束当前循环
                    break;
                }
                //当前b确定后三数之和一定小于temp
                if(nums[b]+nums[n-2]+nums[n-1]<temp){
                    //进入下一次循环
                    continue;
                }
                //在[b+1,n-1]之间利用两个指针寻找可能的组合
                int c = b+1;
                int d = n-1;
                while(c<d){
                    //当前三数之和
                    int curSum = nums[b]+nums[c]+nums[d];
                    if(curSum == temp){
                        //找到符合的组合,添加到list
                        list.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        //将两个指针移动到下一个不相等的地方
                        while(c<d && nums[c] == nums[c+1]){
                            c++;
                        }
                        c++;
                        while(c<d && nums[d]==nums[d-1]){
                            d--;
                        }
                        d--;

                    }else if(curSum < temp){
                        //如果当前三数之和小于目标-nums[a], b指针右移增大总和
                        c++;
                    }else{
                        //如果当前三数之和大于目标-nums[a], d指针左移减小总和
                        d--;
                    }
                }
            }
        }
        return list;
    }
}
