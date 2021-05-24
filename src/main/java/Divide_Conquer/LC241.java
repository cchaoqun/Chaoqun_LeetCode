package Divide_Conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/20-17:01
 */

public class LC241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if(input==null || input.length()==0){
            return list;
        }

        int n = input.length();
        for(int i=0; i<n; i++){
            //遇到操作符, 将两边递归进行计算
            if(!isNum(input.charAt(i))){
                //得到两边所有可能的结果求笛卡尔乘积
                List<Integer> list1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i+1,n));
                for(int num1:list1){
                    for(int num2:list2){
                        list.add(ope(num1,num2,input.charAt(i)));
                    }
                }
            }
        }
        //当前字符串只有一个数字
        if(list.isEmpty()){
            //转换成数字加进去
            list.add(Integer.valueOf(input));
        }
        return list;
    }
    //判断是否是数字
    public boolean isNum(char c){
        return 0<=(c-'0') && (c-'0')<=9;
    }
    //根据操作符运算返回结果
    public int ope(int num1, int num2, char oper){
        if(oper=='+'){
            return num1+num2;
        }else if(oper=='-'){
            return num1-num2;
        }else {
            return num1*num2;
        }
    }
}
