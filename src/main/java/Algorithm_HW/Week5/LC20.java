package Algorithm_HW.Week5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/3-10:30
 */

public class LC20 {

    public boolean isValid(String s) {
        /**
         1. 数量相等
         2. 括号匹配
         3. 空间优化 index s.toCharArray() arr[index-1] 代表栈顶
         */
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        int index = 0;
        char[] arr = s.toCharArray();
        for(char cur : s.toCharArray()){
            if(map.containsKey(cur)){
                if(index==0 || arr[index-1]!=map.get(cur)){
                    return false;
                }
                index--;
            }else{
                arr[index++] = cur;
            }
        }
        return index==0;
    }
}
