package String.str0205;
/*
 * @Description: 165. 比较版本号
给你两个版本号 version1 和 version2 ，请你比较它们。

版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。

比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

返回规则如下：

如果 version1 > version2 返回 1，
如果 version1 < version2 返回 -1，
除此之外返回 0。
 

示例 1：

输入：version1 = "1.01", version2 = "1.001"
输出：0
解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
示例 2：

输入：version1 = "1.0", version2 = "1.0.0"
输出：0
解释：version1 没有指定下标为 2 的修订号，即视为 "0"
示例 3：

输入：version1 = "0.1", version2 = "1.1"
输出：-1
解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
示例 4：

输入：version1 = "1.0.1", version2 = "1"
输出：1
示例 5：

输入：version1 = "7.5.2.4", version2 = "7.5.3"
输出：-1
 

提示：

1 <= version1.length, version2.length <= 500
version1 和 version2 仅包含数字和 '.'
version1 和 version2 都是 有效版本号
version1 和 version2 的所有修订号都可以存储在 32 位整数 中

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compare-version-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 11:51
 */
public class LC165 {

    public static void main(String[] args) {
        String version1 = "1.00.1", version2 = "1.0.2";
        int res = compareVersion(version1,version2);
        System.out.println(res);
    }
    public static int compareVersion(String version1, String version2) {
        char[] arr1 = version1.toCharArray();
        char[] arr2 = version2.toCharArray();
        int maxLen = Math.max(arr1.length,arr2.length);
        for(int i=0,j=0; i<maxLen && j<maxLen; ++i, ++j){
            //当前位置版本号
            int v1 = getNum(version1,i)[0];
            int v2 = getNum(version2,j)[0];
            //判断大小,如果等于则进入下一个版本号的比较
            if(v1<v2){
                return -1;
            }else if(v1>v2){
                return 1;
            }
            //获取下一个'.'的位置, 进入下一次循环后都相应++到达下一个版本号第一个数字的位置
            i = getNum(version1,i)[1];
            j = getNum(version2,j)[1];
        }
        return 0;
    }

    public static int[] getNum(String str, int index){
        //如果对于版本号长度短的,遍历完后应该用0作比较,同时索引仍然是index,这样保证遍历完字符串以后一直用0比较
        if(index>=str.length()){
            return new int[]{0,index};
        }
        int j = index;
        //获得当前位置版本号
        while(j<str.length() && str.charAt(j)!='.'){
            ++j;
        }
        //返回当前版本号,下一个'.'的下标
        //parseInt去除前导0
        return new int[]{Integer.parseInt(str.substring(index,j)),j};
    }

}
