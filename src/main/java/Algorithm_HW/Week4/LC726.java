//package Algorithm_HW.Week4;
//
//import java.util.LinkedList;
//import java.util.TreeMap;
//
///**
// * @author Chaoqun Cheng
// * @date 2021-07-2021/7/2-8:53
// */
//
//public class LC726 {
//    public String countOfAtoms(String formula) {
//        /**
//         大写字母 算作一个原子
//         大写后面跟着小写 Xxxx 算作一个原子
//         (XX)N 括号里面的原子数量需要乘以N
//         XN 字母后面跟着的N只对这个X原子有效
//         */
//        TreeMap<String, Integer> map = new TreeMap<>((a,b)->a.compareTo(b));
//        int len = formula.length();
//        Dequeue<Character> stack = new LinkedList<>();
//        String pre = "";
//        boolean needPush = false;
//        for(int i=0; i<len; i++){
//            char cur = formula.charAt(i);
//            if(cur=='('){
//                // 左括号
//                stack.push(cur);
//                needPush = true;
//            }else if(isNum(c)){
//                //数字
//                int curNum = cur - '0';
//                int j = i+1;
//                //找到后面连续的数字
//                while(j<len && isNum(formula.charAt(j))){
//                    curNum *= 10;
//                    curNum += formula.charAt(j)-'0';
//                    j++;
//                }
//                if(!needPush){
//                    map.put(pre, curNum);
//                }else{
//                    stack.push(curNum+"");
//                }
//            }else if(cur==')'){
//                if(i+1<len )
//                    while(!stack.peek().equals("(")){
//
//                    }
//            }
//        }
//    }
//
//    public boolean isNum(char c){
//        return 0<=c-'0' && c-'0'<='9'
//    }
//}
