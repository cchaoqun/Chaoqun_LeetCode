package Algorithm_HW.Week2;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/5-11:34
 */

public class LC6 {
    public String convert(String s, int numRows){
        /*
        创建numRows层Stringbuffer, 每一层都需要初始化
        维护index范围在 [0,numRows-1], 从上到下, 从下到上, 遇到边界就改变方向
        flag = 1 || -1 表示下一步需要在[0,numRows-1]内移动的方向,遇到边界改变方向
            index = 0, flag = 1;
            index = numRows-1 flag = -1;
        最后将后面的StringBuffer都添加到第一个StringBuffer后面
         */
        StringBuffer[] sbArr = new StringBuffer[numRows];
        if(numRows==1){
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuffer();
        }
        //初始位置为index=0, 好像之前是从右边过来的, 所以flag=-1
        int flag = -1;
        int index = 0;
        for(char c:s.toCharArray()){
            //取出对应层的StringBuffer把当前字符append到字符后面
            sbArr[index].append(c);
            //遇到边界改变方向
            if(index==0 || index==numRows-1){
                flag = -flag;
            }
            //按照指定的方向移动
            index += flag;
        }
        for(int i=1; i<numRows; i++){
            sbArr[0].append(sbArr[i].toString());
        }
        return sbArr[0].toString();

    }
}





































