package String.str0204;
/*
 * @Description: 67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 

提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 21:47
 */
public class LC67 {
    public static void main(String[] args) {
        String a = "11", b = "1001";
        String res = addBinary(a,b);
        System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        if(a.length()<b.length()){
            //保证a+b, b长度小于等于a
            return addBinary(b,a);
        }
        //高位补零
        int aLen = a.length(), bLen = b.length();
        if(aLen>bLen){
            while(aLen-bLen>0){
                b = "0"+b;
                bLen = b.length();
            }
        }
        //两个字符串长度相同
        int n = aLen;
        //建立两个字符串长度的和的数组存储每个位置两个字符串对应数字相加之和
        int[] arr = new int[n+1];
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int pa = n-1;
        while(pa>=0){
            //进行进位操作, arr[i]/2 的值进位,原来位置更新为arr[i]%2
            arr[pa+1] += (arrA[pa]-'0')+(arrB[pa]-'0');
            arr[pa] += arr[pa+1]/2;
            arr[pa+1] = arr[pa+1]%2;
            pa--;
        }

        StringBuilder sb = new StringBuilder();
        int index = arr[0]==0?1:0;
        while(index<n+1){
            sb.append(arr[index]);
            index++;
        }
        return sb.toString();
    }
}
