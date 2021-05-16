package String.str0204;
/*
 * @Description: 28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 16:35
 */
public class LC28 {

    public int strStr(String haystack, String needle) {
        int n = needle.length();
        for (int i=0; i<(haystack.length()-n+1); i++){
            if(haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //双指针
//    public int strStr(String haystack, String needle){
//        int n = needle.length();
//        int m = haystack.length();
//        if(n==0){
//            return 0;
//        }
//        if(m<n){
//            return -1;
//        }
//        int ph = 0, pn = 0, count = 0;
//        while(ph<m-n+1){
//            while(pn<n && haystack.charAt(ph)==needle.charAt(pn)){
//                ph += 1;
//                pn += 1;
//                count += 1;
//            }
//            if(pn==n){
//                return ph-n;
//            }else{
//                ph = ph-count+1;
//                pn = 0;
//                count = 0;
//            }
//        }
//        return -1;
//    }

//    public int strStr(String haystack, String needle){
//        int[] next = kmpNext(needle);
//        return kmpSearch(haystack,needle,next);
//
//
//    }
//    //KMP搜索算法
//    public static int kmpSearch(String str1, String str2, int[] next){
//
//        for(int i=0,j=0; i<str1.length(); i++){
//            //需要处理str1.charAt(i) != str2.charAt(j) 调整j的大小
//            while(j>0 && str1.charAt(i) != str2.charAt(j)){
//                j = next[j-1];
//            }
//            //匹配到
//            if(str1.charAt(i) == str2.charAt(j)){
//
//                //匹配字符串指针后移一位
//                j++;
//            }
//            //判断匹配字符串指针与匹配字符串长度相等
//            if(j==str2.length()){
//                //匹配字符串在待匹配字符串中匹配的第一个下标
//                return i-j+1;
//            }
//        }
//        return -1;
//
//    }
//
//    //获取字符串的部分匹配表
//    public static int[] kmpNext(String str){
//        //创建用于存放部分匹配表的数组
//        int[] next = new int[str.length()];
//        //部分匹配第一个元素为0,因为一个字符的字符串没有前缀和后缀,不可能相同
//        next[0] = 0;
//        for(int i=1,j=0; i<str.length(); i++){
//            //当str.charAt(i) != str.charAt(j),需要从next[j-1]获取j
//            //直到发现str.charAt(i) == str.charAt(j)才退出
//            //??????????????????????????????????????????
//            while(j>0 && str.charAt(i) != str.charAt(j)){
//                j = next[j-1];
//            }
//            //str.charAt(i) == str.charAt(j)满足,部分匹配值+1
//            if(str.charAt(i) == str.charAt(j)){
//                j++;
//            }
//            next[i] = j;
//        }
//        return next;
//    }
}
