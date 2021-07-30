package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-21:13
 */

public class jz39 {
    public int majorityElement(int[] nums) {
        int vote = 1;
        int cand = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]==cand){
                vote++;
            }else if(vote==0){
                cand = nums[i];
                vote = 1;
            }else if(nums[i]!=cand){
                vote--;
            }

        }
        return cand;
    }
}
