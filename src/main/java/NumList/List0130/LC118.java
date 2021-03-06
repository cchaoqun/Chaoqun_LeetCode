package NumList.List0130;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
* 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 22:31
 */
public class LC118 {
    public static void main(String[] args) {
        List<List<Integer>> res= generate(5);
        System.out.println(res);

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    list.add(1);
                }else{
                    //上一行当前位置和前一个位置的和
                    list.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
            }
            //本行添加到res
            res.add(list);
        }
        return res;
    }
}
