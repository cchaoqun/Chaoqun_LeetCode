package BinarySearch.bs0105;

/*
 * @Description: 面试题 10.05. 稀疏数组搜索
 *
稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
* 存在返回字符串下标,不存在返回-1
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 18:52
 */
public class Interview1005 {
    public static void main(String[] args) {
        String[] words = {"CitZMIXZKoFbxvOlaza", "hBlKXdKJfBD"};
        System.out.println(findString(words,"hBlKXdKJfBD"));
    }

    //HashMap存储非null元素下标和值,创建新的稀疏数组,遍历搜索
//    public static int findString(String[] words, String s) {
//        //记录非null元素个数
//        int count = 0;
//        //HashMap记录非null元素下标和值
//        HashMap<String,String> map = new HashMap<>();
//        //遍历字符串数组获得非null元素的个数和值
//        for(int i=0; i<words.length; i++){
//            if(words[i].length()!= 0){
//                count++;
//                map.put(i+"",words[i]);
//            }
//        }
//        String[][] sparseArr = new String[count][2];
//        int index = 0;
//        for(Map.Entry<String,String> entry:map.entrySet()){
//            sparseArr[index][0] = entry.getKey();
//            sparseArr[index][1] = entry.getValue();
//            index++;
//        }
//        for(int i=0; i<count; i++){
//            if(sparseArr[i][1].equals(s)){
//                return Integer.parseInt(sparseArr[i][0]);
//            }
//        }
//        return -1;
//    }

    //暴力
//    public static int findString(String[] words, String s) {
//        //记录非null元素个数
//        int count = 0;
//        //遍历字符串数组获得非null元素的个数和值
//        for(int i=0; i<words.length; i++){
//            if(words[i].length()!= 0){
//                count++;
//            }
//        }
//        String[][] sparseArr = new String[count][2];
//        int index = 0;
//        for(int i=0; i<words.length; i++){
//            if(words[i].length()!= 0){
//                sparseArr[index][0] = i+"";
//                sparseArr[index][1] = words[i];
//                index++;
//            }
//        }
//        for(int i=0; i<count; i++){
//            if(sparseArr[i][1].equals(s)){
//                return Integer.parseInt(sparseArr[i][0]);
//            }
//        }
//        return -1;
//    }

    //空间换时间
//    public static int findString(String[] words, String s) {
//        //记录非null元素个数
//        int count = 0;
//        String[][] sparseArr = new String[words.length][2];
//        //遍历字符串数组获得非null元素的个数和值
//        for(int i=0; i<words.length; i++){
//            if(words[i].length()!= 0){
//                sparseArr[count][0] = i+"";
//                sparseArr[count][1] = words[i];
//                count++;
//            }
//        }
//
//        for(int i=0; i<count; i++){
//            if(sparseArr[i][1].equals(s)){
//                return Integer.parseInt(sparseArr[i][0]);
//            }
//        }
//        return -1;
//    }

    //二分查找 递归
//    public static int findString(String[] words, String s){
//        int left = 0;
//        int right = words.length-1;
//        return find(words,left,right,s);
//    }
//    public static int find(String[] words, int left, int right, String s){
//        //左右缩减到第一个不为""的元素
//        while(left<right && words[left].equals("")){
//            left++;
//        }
//        while(left<right && words[right].equals("")){
//            right--;
//        }
//        //判断是否存在s
//        //如果 s<左端点 或者 >右端点字符串 则s不存在
//        if(s.compareTo(words[left])<0 || s.compareTo(words[right])>0){
//            return -1;
//        }
//
//        int mid = (left+right)/2;
//        String temp = words[mid];
//        //防止中间值为""
//        while(mid>left && words[mid].equals("")){
//            mid--;
//        }
//        if(words[mid].equals(s)){
//            return mid;
//        }
//        int co = s.compareTo(words[mid]);
//        if(co<0){
//            return find(words,left,mid-1,s);
//        }else{
//            return find(words,mid+1,right,s);
//        }
//    }

    //二分查找 非递归

    public static int findString(String[] words, String s){
        int left = 0;
        int right = words.length;
        while(left<right){
            int mid = (left+right)/2;
            int mid2 = mid;
            //向左将中间值移动到第一个非""的位置
            while(mid<right && words[mid].equals("")){
                mid++;
            }
            //左边全部为""
            if(mid==right){
                right = mid2;
                continue;
            }
            int temp = s.compareTo(words[mid]);
            if(temp==0){
                return mid;
            }else if(temp<0){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
