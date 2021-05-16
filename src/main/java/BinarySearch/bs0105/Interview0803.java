package BinarySearch.bs0105;

/*
 * @Description: 面试题 08.03. 魔术索引
 *
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 14:46
 */
public class Interview0803 {
    public static void main(String[] args) {
        int[] nums = {12296169, 14481887, 19365401, 71948694, 101256536, 137449705, 147615033, 169095970, 182939974, 183054331, 191033174, 200069688, 210281043, 211549396, 227193353, 252408327, 263757832, 268669870, 271916258, 293898012, 322628245, 329246885, 348479255, 405807814, 431800160, 449369511, 477566467, 481431749, 481880069, 487953610, 509211052, 520721303, 527744664, 550058864, 571603718, 571617555, 579098239, 582152388, 645340207, 681566032, 685774515, 706348591, 708774328, 717815831, 721421995, 724666698, 745560058, 746289154, 769651867, 781893631, 789714924, 807615645, 882508445, 884260053, 916797901, 920985226, 924045345, 932899253, 950715182, 987825772, 1015158842, 1016121780, 1065377233, 1072449577};
        int res = findMagicIndex(nums);
        System.out.println(res);
    }

    //暴力遍历
    public static int findMagicIndex(int[] nums) {
        for(int i=0; i<nums.length; ){
            if(nums[i] == i){
                return i;
            }
            //利用序列有序,跳过中间不需要比较的元素
            if(nums[i]>i){
                i = nums[i];
            }else{
                i++;
            }
        }
        return -1;
    }




    //分治,先在左边找.没有再在右边找
//    public static int findMagicIndex(int[] nums){
//        return getAnswer(nums,0,nums.length-1);
//    }
//
//    public static int getAnswer(int[] nums, int left, int right){
//        if(left>right){
//            return -1;
//        }
//        int mid = (left+right)/2;
//        int leftAnswer = getAnswer(nums,0,mid-1);
//        if(leftAnswer != -1){
//            return leftAnswer;
//        }else if(nums[mid] == mid){
//            return mid;
//        }
//        return getAnswer(nums,mid+1,right);
//    }

    //过滤不需要的元素
//    public static int findMagicIndex(int[] nums){
//        int flag = 0;
//        while(flag<nums.length){
//            if(nums[flag] == flag){
//                return flag;
//            }else if(nums[flag] > flag){
//                flag = nums[flag];
//            }else{
//                flag++;
//            }
//        }
//        return -1;
//    }
}
