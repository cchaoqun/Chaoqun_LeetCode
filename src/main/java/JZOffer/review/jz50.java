package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-14:13
 */

public class jz50 {
    public char firstUniqChar(String s) {
        char res = ' ';
        //统计每个字符出现的次数
        int[] visited = new int[26];
        for(char c : s.toCharArray()){
            visited[c-'a']++;
        }
        //再次遍历字符串, 第一个出现一次的字符就是找的结果
        for(char c : s.toCharArray()){
            if(visited[c-'a']==1){
                res = c;
                break;
            }
        }
        return res;
    }
}
