package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-13:29
 */

public class LC42 {
    //O(n)
    public int trap(int[] height) {
        int n = height.length;
        //height[i]左边的最大值 不包括当前元素
        int[] leftMax = new int[n];
        //height[i]右边的最大值 不包括当前元素
        int[] rightMax = new int[n];
        //获得每个位置对应的左边和右边的最大值
        //左右端点无需更新, 因为左右端点一定不可以获得雨水
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        //双指针分别指向左右第二个位置
        int p1 = 1;
        int p2 = n-2;
        int sum = 0;
        //当两个指针不交叉之前
        while(p1<=p2){
            //当前左指针左边的最大值
            int curLeft = leftMax[p1];
            //当前右指针右边的最大值
            int curRight = rightMax[p2];
            //每次只更新一个指针对应位置可以接到的雨水, 保证不重复
            //如果左边的最大值<=右边的最大值, 左边的最大值一定是可靠的, 就像木桶原理, 能接多少水取决于较短的
            if(curLeft <= curRight){
                sum += Math.max(0, curLeft-height[p1]);
                p1++;
            }else if(curRight <= curLeft){
                //同理右指针最大值较小, 右边的最大值是可靠的
                sum += Math.max(0, curRight - height[p2]);
                p2--;
            }

        }
        return sum;
    }
}

class LC42_M2{
    // O(1)
    public int trap(int[] height){
        int n = height.length;
        //动态更新左右的最大值
        int left = 0, right = n-1, leftMax = 0, rightMax = 0;
        int sum = 0;
        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax<rightMax){
                sum += leftMax-height[left];
                left++;
            }else{
                sum += rightMax-height[right];
                right--;
            }

        }
        return sum;
    }
}

































