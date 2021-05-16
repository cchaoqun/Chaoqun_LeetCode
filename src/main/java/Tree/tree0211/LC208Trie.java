package Tree.tree0211;
/*
 * @Description: 
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/25 11:46
 */
public class LC208Trie {

    private boolean isString = false;
    private LC208Trie next[] = new LC208Trie[26];


    /** Initialize your data structure here. */
    public LC208Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        LC208Trie root = this;
        char[] wordArr = word.toCharArray();
        for(int i=0; i<wordArr.length; ++i){
            int curr = wordArr[i] - 'a';
            if(root.next[curr] == null){
                root.next[curr] = new LC208Trie();
            }
            root = root.next[curr];
        }
        root.isString = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        LC208Trie root = this;
        char[] wordArr = word.toCharArray();
        for(int i=0; i<word.length(); ++i){
            int curr = wordArr[i] - 'a';
            if(root.next[curr]==null){
                return false;
            }
            root = root.next[curr];
        }
        //查看是否是叶子结点,有可能为前缀
        return root.isString;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        LC208Trie root = this;
        char[] wordArr = prefix.toCharArray();
        for(int i=0; i<wordArr.length; ++i){
            int curr = wordArr[i] - 'a';
            if(root.next[curr]==null){
                return false;
            }
            root = root.next[curr];
        }
        return true;
    }
}
