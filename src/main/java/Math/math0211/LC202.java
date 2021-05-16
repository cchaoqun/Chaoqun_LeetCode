package Math.math0211;

import java.util.Set;

/*
 * @Description: 202. 快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 true ；不是，则返回 false 。


示例 1：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：

输入：n = 2
输出：false


提示：

1 <= n <= 231 - 1
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 10:21
 */
public class LC202 {
    public static void main(String[] args) {
        int n = 7;
        boolean res = isHappy(n);
        System.out.println(res);
    }

    public static boolean isHappy (int n){
        //递归
//        Set<Integer> set = new HashSet<>();
//        return dfs(n, n, set);
        //快慢指针
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && fast!=slow){
            //慢指针每次走一步
            slow = getNext(slow);
            //快指针每次走两步
            fast = getNext(getNext(fast));
        }
        //如果退出循环fast==1 是快乐数
        //如果 fast!=1, 因为快慢指针相遇导致退出循环,不是快乐数
        return fast == 1;
    }
    public static boolean dfs(int n, int num, Set<Integer> set) {
        if(num == 1){
            return true;
        }
        //如果遇到之前出现的数字,则进入了循环,不可能到达1
        if(set.contains(num)){
            return false;
        }
        //之前未遇到过,将该数添加到set中
        set.add(num);
        //获取下一个数
        int next = getNext(num);
        //递归
        return dfs(n, next, set);
    }

    //获取下一个数
    public static int getNext(int num){
        int next = 0;
        while(num != 0){
            next += (num % 10) * (num % 10);
            num /= 10;
        }
        return next;
    }
}
