package BackTracking.backtrack0221;
/*
 * @Description: 211. 添加与搜索单词 - 数据结构设计
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。


示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


提示：

1 <= word.length <= 500
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最多调用 50000 次 addWord 和 search
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 13:38
 */
public class WordDictionary {

    //将字符串的字符保存在路径中
    class Node {
        // next可能不止一个字符
        private Node[] next;
        // 叶子结点isWord=true
        private boolean isWord;

        public Node() {
            //只有叶子结点,可以初始化为大小26的数组
            next = new Node [26];
            isWord = false;
        }
    }

    Node root;


    /** Initialize your data structure here. */
    public WordDictionary() {
        //初始化根结点
        root = new Node();
    }

    public void addWord(String word) {
        int len = word.length();
        Node curr = root;
        for(int i=0; i<len; ++i) {
            char curChar = word.charAt(i);
            Node next = curr.next[curChar - 'a'];
            if(next == null) {
                curr.next[curChar - 'a'] = new Node();
            }
            curr = curr.next[curChar-'a'];
        }
        if(!curr.isWord){
            curr.isWord = true;
        }
    }

    public boolean search(String word) {
        return match(word, root, 0);
    }

    public boolean match(String word, Node root, int start){
        if(start==word.length()){
            return root.isWord;
        }
        char currChar = word.charAt(start);
        if(currChar == '.'){
            for(int i=0; i<26; ++i){
                if(root.next[i]!=null && match(word, root.next[i], start+1)){
                    return true;
                }
            }
            return false;
        }else{
            if(root.next[currChar] == null){
                return false;
            }
            return match(word, root.next[currChar - 'a'], start+1);
        }

    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
