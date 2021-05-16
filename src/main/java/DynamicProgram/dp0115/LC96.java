package DynamicProgram.dp0115;
/*
 * @Description: 96. 不同的二叉搜索树
给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？

示例:
输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 14:43
 */
public class LC96 {

    //dp
    //遍历1-n的每个数字i将其作为根结点构造二叉搜索树,将 1-(i-1) 和 (i+1)-n 作为左右子树
    public int numTrees(int n) {
        //每个下标对应的是序列长度为i时的可能情况
        int[] createTree = new int[n+1];
        //序列长度为0或1只有一种情况
        createTree[0] = 1;
        createTree[1] = 1;
        //主循环为了确定每个下标对应的可能情况的总数
        for(int i=2; i<=n; i++){
            //内循环为了确定从1~i作为根结点的每种情况的二叉树个数 并全部加起来
            for(int j=1; j<=i; j++){
                //对应j为根结点  左子树从1~j-1(j-1-1+1)   右子树j+1~i(i-(j+1)+1)
                createTree[i] += createTree[j-1]*createTree[i-j];
            }
        }
        return createTree[n];

    }
}


