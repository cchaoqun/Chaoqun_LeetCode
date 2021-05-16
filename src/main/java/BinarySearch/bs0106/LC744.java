package BinarySearch.bs0106;
/*
 * @Description: 744. 寻找比目标字母大的最小字母
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
在比较时，字母是依序循环出现的。举个例子：
如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 15:54
 */
public class LC744 {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';
        char res = nextGreatestLetter(letters,target);
        System.out.println(res);
    }

//    public static char nextGreatestLetter(char[] letters, char target) {
//        int left = 0;
//        int right = letters.length;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            if(target == letters[mid]){
//                left = mid+1;
//            }else if(target < letters[mid]){
//                right = mid;
//            }else if(target > letters[mid]){
//                left = mid+1;
//            }
//        }
//        return letters[left%letters.length];
//    }

    public static char nextGreatestLetter(char[] letters, char target){
        if(letters[0]>target || letters[letters.length-1]<target){
            return letters[0];
        }
        int left = 0;
        int right = letters.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target>=letters[mid]){
                left = mid+1;
            }else{
                if(target>=letters[mid-1]){
                    return letters[mid];
                }else{
                    right = mid-1;
                }
            }
        }
        return ' ';


    }
}
