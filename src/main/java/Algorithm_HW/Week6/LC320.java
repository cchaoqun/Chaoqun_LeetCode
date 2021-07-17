package Algorithm_HW.Week6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/10-14:35
 */

public class LC320 {

    @Test
    public void test(){
        StringBuffer sb = new StringBuffer();
        String word = "interaction";
        List<String> res  = generateAbbreviations(word);
        System.out.println(res);
    }

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(res, sb, word, 0, 0, word.length());
        return res;
    }

    private void backtrack(List<String> res, StringBuffer sb, String word, int abbr, int index,  int len){
        if(index==len){
            res.add(new String(sb));
            return;
        }
        //本层加字符
        sb.append(word.charAt(index));
        backtrack(res, sb, word, 0, index+1, len);
        sb.deleteCharAt(sb.length()-1);

        // 本层添加数字
        //记录sb的长度, 防止加的数字长度是两位及以上, 需要删除的字符数量不确定
        int curLen = sb.length();
        //加数字 上一次添加的是数字,需要先删除上一次的数字, 再把数字+1再添加进去
        if(abbr!=0){
            int temp = abbr;
            //防止添加的数字不止一位, 需要全部删除
            while(temp>0){
                sb.deleteCharAt(sb.length()-1);
                temp /= 10;
            }
            //本次添加的数字是上一次添加的数字+1
            int temp2 = abbr+1;
            sb.append(abbr+1);
            backtrack(res, sb, word, abbr+1, index+1, len);
            //同样需要考虑数字位数>1的情况
            while(temp2>0){
                sb.deleteCharAt(sb.length()-1);
                temp2 /= 10;
            }
            //将上一次添加的数字重新放回去
            sb.append(abbr);
        }
        //上一次添加的是字符,这次从1添加即可
        if(abbr==0){
            sb.append(1);
            backtrack(res, sb, word, 1, index+1, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
