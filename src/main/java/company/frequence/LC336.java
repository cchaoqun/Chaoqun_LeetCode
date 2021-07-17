package company.frequence;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/9-13:06
 */

public class LC336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(isPalind(words[i]+words[j])){
                    res.add(Arrays.asList(i,j));
                }
                if(isPalind(words[j]+words[i])){
                    res.add(Arrays.asList(j,i));
                }
            }
        }
        return res;
    }

    private boolean isPalind(String str){
        if(str==null || str.length()==0){
            return true;
        }
        int i = 0;
        int j = str.length();
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class LC336_M2{
    List<String> wordRev = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(String word : words){
            wordRev.add(new StringBuffer(word).reverse().toString());
        }
        for(int i=0; i<words.length; i++){
            map.put(wordRev.get(i), i);
        }
        int len = words.length;
        for(int i=0; i<len; i++){
            String word = words[i];
            int m = word.length();
            if(m==0){
                continue;
            }
            for(int j=0;j<=m; j++){
                if(j!=0 && isPalind(word, 0, j-1)){
                    int right = find(word, j, m-1);
                    if(right!=-1 && right!=i){
                        res.add(Arrays.asList(right,i));
                    }
                }
                if(isPalind(word, j, m-1)){
                    int left = find(word, 0, j-1);
                    if(left!=-1 && left!=i){
                        res.add(Arrays.asList(i,left));
                    }
                }
            }
        }
        return res;
    }

    private int find(String str, int left, int right){
        return map.getOrDefault(str.substring(left, right+1), -1);
    }

    private boolean isPalind(String str, int i, int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
